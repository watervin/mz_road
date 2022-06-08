package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result_main.*
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ResultMain : AppCompatActivity() {

    //값 읽어오기

    internal lateinit var retrofit: Retrofit
    internal lateinit var apiService: ApiService
    internal lateinit var comment: Call<ResponseBody>
    internal lateinit var result:String
    lateinit var final_result : String
    lateinit var final_result2 : Array<String>
    var check = "123"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)


        btn_test.setOnClickListener {
            val intent = Intent(this, ResultMain2::class.java)
            intent.putExtra("final_result",final_result2[0]).toString()
            startActivity(intent)

        }



        //값 읽어오기(get)
        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).build()
        apiService = retrofit.create(ApiService::class.java)
        comment = apiService.get_Test("json")
        comment.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val str = response.body()!!.string() as String
                var dataresult = Gson().fromJson<DataResult>(str, DataResult::class.java)
                final_result = dataresult.first().final_result
                Log.d("main_test", "show 값 보기 $final_result")

                final_result2 = final_result.split(' ').toTypedArray()
                Log.d("main_test", "show 값 보기 ${final_result2[0]}")

                if(final_result2[0] == "영화관"){
                   check = "movie"
                }
                Log.d("main_test", "show 값 보기 $check")

                if(final_result2[0] == "게임(모바일·PC·콘솔)"){
                    check = "game"
                }

                btn1.text = final_result

            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                result = "error!!"
               Log.e("d_show", "페일!")
                Log.e("d_show", "$t!")

            }
        })

        btn1.setOnClickListener {
            Log.d("main_test", "real check 값 보기 $check")

            if(check == "movie"){
                val intent = Intent(this, Movie::class.java)
                intent.putExtra("final_result",final_result2[0]).toString()
                startActivity(intent)
            }
            else if(check == "game"){
                val intent = Intent(this, Game::class.java)
                intent.putExtra("final_result",final_result2[0]).toString()
                startActivity(intent)
            }


            else {
                val intent = Intent(this, KakaoMap::class.java)
                intent.putExtra("final_result", final_result2[0]).toString()
                startActivity(intent)
            }



        }




    }


}