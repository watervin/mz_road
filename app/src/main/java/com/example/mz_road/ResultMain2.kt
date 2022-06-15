package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
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


    var send:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main2)


        send = intent.getStringExtra("send").toString()


        Log.i("show_vale", " SelectOne 페이지 값이 잘 넘어왔는지 확인 $send")


        webview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        webview.loadUrl("https://m.search.naver.com/search.naver?query=$send")

        btn_back.setOnClickListener {
            val intent = Intent(this, KakaoMap::class.java)
            startActivity(intent)

        }
        btn_start2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

}
    override fun onBackPressed() {
        if (webview.canGoBack())
        {
            webview.goBack()
        }
        else
        {
            finish()
        }
    }
}