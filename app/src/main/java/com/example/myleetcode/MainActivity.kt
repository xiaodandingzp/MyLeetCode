package com.example.myleetcode

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.myleetcode.ui.theme.MyLeetCodeTheme
import com.example.myleetcode.ui.theme.leedcode.Test354

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLeetCodeTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
    Button(
        shape = RoundedCornerShape(50),
        modifier = Modifier.padding(Dp(100f)),
        onClick = {
            val per =
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3,4),
                    intArrayOf(3, 5), intArrayOf(4, 5), intArrayOf(5,5),
                    intArrayOf(5, 6), intArrayOf(6, 7), intArrayOf(7,8))
            val result = Test354().maxEnvelopes(per)
            Log.i("zpppppp", "result:$result")
    }) {
        Text(text = "点击测试")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLeetCodeTheme {
        Greeting("Android")
    }
}