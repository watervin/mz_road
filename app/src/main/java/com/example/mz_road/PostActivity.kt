package com.example.mz_road

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_face2.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PostActivity : AppCompatActivity() {

    // ai

    internal lateinit var retrofit: Retrofit
    internal lateinit var apiService: ApiService
    internal lateinit var comment: Call<Json_Test_Java>
    internal lateinit var comment2: Call<ResponseBody>

    var feelings : String = ""
    var feelings2 : String = ""


    internal lateinit var result:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val secondIntent = intent
        feelings = secondIntent.getIntExtra("feeling", 0).toString()
        Log.e("여기는 post 테스트입니다.show", feelings)

        feelings2 = secondIntent.getStringExtra("feeling2").toString()
        Log.e("show", feelings2)

        type1()


            val intent = Intent(this, WaitActivity::class.java)
            startActivity(intent)


    }








    fun type1(){
        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiService = retrofit.create(ApiService::class.java)
        val version = Json_Test_Java("null","null",feelings2,null)

        comment = apiService.post_json_test_java("json", version)
        comment.enqueue(object : Callback<Json_Test_Java> {

            override fun onResponse(call: Call<Json_Test_Java>, response: Response<Json_Test_Java>) {
                Log.e("D_Test", "2차")
                if (response.isSuccessful) {
                    Log.e("post", "성공")
                } else {
                    val StatusCode = response.code()
                    Log.e("post", "Status Code : $StatusCode")
                }
            }
            override fun onFailure(call: Call<Json_Test_Java>, t: Throwable) {
                result = "error!!"
                Log.e("D_Test", "POST 페일!")
            }
        })
    }




    fun get_code(){
        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).build()
        apiService = retrofit.create(ApiService::class.java)
        comment2 = apiService.get_Test("json")
        comment2.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {

                    result = response.body()!!.string()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                result = "error!!"
                Log.e("D_Test", "페일!")
            }
        })
    }

}