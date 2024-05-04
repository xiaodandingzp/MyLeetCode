package com.example.myleetcode

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myleetcode.test.IServiceApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscription
import rx.schedulers.Schedulers

class RxTestActivity :  ComponentActivity() {
    val api: IServiceApi by lazy {
        getRetrofit().create(IServiceApi::class.java)
    }

    var request: Subscription? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_test)
        findViewById<Button>(R.id.zp_rx_button).setOnClickListener {
            clickProcess()
        }
    }

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder().baseUrl("https://www.wanandroid.com")
//            .addCallAdapterFactory(RetryRxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun clickProcess() {

//        request?.unsubscribe()
        request =
            api.getPrigectInfo()
            .flatMap {info ->
                Log.i("zpppppp", "info: $info")
                Observable.from(info.data)
            }
            .flatMap { projectItemInfo ->
                api.getItemInfo(projectItemInfo.id)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe ({
                        Log.i("zpppppp", "it: $it")
            }, {
                Log.e("zpppp", "it: $it")
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        request?.unsubscribe()
    }
}