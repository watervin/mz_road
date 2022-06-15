package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_result_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ResultMainFace : AppCompatActivity() {

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
        setContentView(R.layout.activity_result_main_face)






        //값 읽어오기(get)
        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).build()
        apiService = retrofit.create(ApiService::class.java)
        comment = apiService.get_Test("json")
        comment.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val str = response.body()!!.string() as String
                var dataresult = Gson().fromJson<DataResult>(str, DataResult::class.java)
                final_result = dataresult.last().final_result
                Log.d("main_test", "show 값 보기 $final_result")

                final_result2 = final_result.split(' ').toTypedArray()
                Log.d("main_test", "show 값 보기 ${final_result2[0]}")

                btn1.text = final_result

                when (final_result2[0]) {
                    "영화관" -> check = "movie"
                    "게임(모바일·PC·콘솔)" -> final_result2[0] = "pc방"
                    "음주" ->  final_result2[0] = "술집"
                    "독서(도서관·책/잡지보기)" -> final_result2[0] = "도서관"
                    "만화·애니" -> final_result2[0] = "도서관"
                    "미용(미용실·네일아트 등)" -> final_result2[0] = "미용"
                    "반려 동물 활동" -> final_result2[0] = "공원"
                    "보드" -> final_result2[0] = "보드게임"
                    "생활공예(라탄·도자기" -> final_result2[0] = "원데이 클래스"
                    "요리(쿠킹" -> final_result2[0] = "쿠킹 클래스"
                    "원예·재배" -> final_result2[0] = "꽃집"
                    "콘서트·공연·전시회" -> final_result2[0] = "전시회"
                    else -> { // else 를 사용해서 앞의 조건에 해당되지 않는 모든 케이스를 처리할 수 있습니다.
                        final_result2[0] = "호텔"
                    }
                }
                if(final_result2[0] == "영화관"){
                    check = "movie"
                }







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
                val intent = Intent(this, Movie2Activity::class.java)
                intent.putExtra("final_result",final_result2[0]).toString()
                startActivity(intent)
            }
//            else if(check == "game"){
//                val intent = Intent(this, Game::class.java)
//                intent.putExtra("final_result",final_result2[0]).toString()
//                startActivity(intent)
//            }


            else {
                val intent = Intent(this, KakaoMap::class.java)
                intent.putExtra("final_result", final_result2[0]).toString()
                startActivity(intent)
            }



        }
        btn_start.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }


}