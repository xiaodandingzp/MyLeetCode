package com.example.myleetcode.test

import com.example.myleetcode.test.bean.ProjectInfo
import com.yy.luoxi.test.bean.ItemInfo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface IServiceApi {
    @GET("project/tree/json")
    fun getPrigectInfo(): Observable<ProjectInfo>

    @GET("project/list/{pageIndex}/json?cid=294")
    fun getItemInfo(@Path("pageIndex") pageIndex: Int): Observable<ItemInfo>
}