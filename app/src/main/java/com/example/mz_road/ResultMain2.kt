package com.example.mz_road

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_result_main.*
import kotlinx.android.synthetic.main.activity_result_main2.*
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ResultMain2 : AppCompatActivity() {

    //값 읽어오기




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main2)


        webview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        webview.loadUrl("https://m.search.naver.com/search.naver?query=%ed%98%84%ec%9e%ac%ec%83%81%ec%98%81%ec%98%81%ed%99%94")




}
}