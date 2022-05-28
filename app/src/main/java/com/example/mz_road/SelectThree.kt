package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_select_one.*
import kotlinx.android.synthetic.main.activity_select_three.*
import kotlinx.android.synthetic.main.activity_select_three.radioGroup
import kotlinx.android.synthetic.main.activity_select_three.radioGroup11
import kotlinx.android.synthetic.main.activity_select_three.radioGroup5
import kotlinx.android.synthetic.main.activity_select_three.radioGroup6
import kotlinx.android.synthetic.main.activity_select_three.radioGroup7
import kotlinx.android.synthetic.main.activity_select_three.radioGroup8
import kotlinx.android.synthetic.main.activity_select_three.radioGroup9
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SelectThree : AppCompatActivity() {

    internal lateinit var retrofit: Retrofit
    internal lateinit var apiService: ApiService
    internal lateinit var comment: Call<Json_Test_Java>
    internal lateinit var comment2: Call<ResponseBody>
    internal lateinit var result:String


    var feelings : String = ""

    var one_nine:String = ""
    var ten_eighteen:String = ""
    var nineteen_25:String =""
    var total:String=""

    var nineteen:String = ""
    var twenty:String = ""
    var twenty_one:String = ""
    var twenty_two:String = ""
    var twenty_three:String = ""
    var twenty_four:String = ""
    var twenty_five:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_three)

        feelings = intent.getStringExtra("feelings").toString()
        one_nine = intent.getStringExtra("one_nine").toString()
        ten_eighteen = intent.getStringExtra("ten_eighteen").toString()



        Log.i("show", "SelectTwo 페이지가 잘 넘어왔는지 확인 $feelings ],$one_nine,$ten_eighteen")


        //19번
        radioGroup5.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans19_1 -> nineteen= "1"
                R.id.ans19_2 -> nineteen = "2"
                R.id.ans19_3 -> nineteen = "3"
                R.id.ans19_4 -> nineteen = "4"
                R.id.ans19_5 -> nineteen = "5"
                R.id.ans19_6 -> nineteen = "6"
                R.id.ans19_7 -> nineteen = "7"
            }
        }

        //20번
        radioGroup6.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans20_1 -> twenty = "1"
                R.id.ans20_2 -> twenty = "2"
                R.id.ans20_3 -> twenty = "3"
                R.id.ans20_4 -> twenty = "4"
                R.id.ans20_5 -> twenty = "5"
                R.id.ans20_6 -> twenty = "6"
                R.id.ans20_7 -> twenty = "7"
            }
        }

        //21번
        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans21_1 -> twenty_one = "1"
                R.id.ans21_2 -> twenty_one = "2"
                R.id.ans21_3 -> twenty_one = "3"
                R.id.ans21_4 -> twenty_one = "4"
                R.id.ans21_5 -> twenty_one = "5"
                R.id.ans21_6 -> twenty_one = "6"
                R.id.ans21_7 -> twenty_one = "7"
            }
        }

        //22번
        radioGroup7.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans22_1 -> twenty_two = "1"
                R.id.ans22_2 -> twenty_two = "2"
                R.id.ans22_3 -> twenty_two = "3"
                R.id.ans22_4 -> twenty_two = "4"
                R.id.ans22_5 -> twenty_two = "5"
                R.id.ans22_6 -> twenty_two = "6"
                R.id.ans22_7 -> twenty_two = "7"
            }
        }
        //23번
        radioGroup8.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans23_1 -> twenty_three = "1"
                R.id.ans23_2 -> twenty_three = "2"
                R.id.ans23_3 -> twenty_three = "3"
                R.id.ans23_4 -> twenty_three = "4"
                R.id.ans23_5 -> twenty_three = "5"
                R.id.ans23_6 -> twenty_three = "6"
                R.id.ans23_7 -> twenty_three = "7"
            }
        }
        //24번
        radioGroup9.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans24_1 -> twenty_four = "1"
                R.id.ans24_2 -> twenty_four = "2"
                R.id.ans24_3 -> twenty_four = "3"
                R.id.ans24_4 -> twenty_four = "4"
                R.id.ans24_5 -> twenty_four = "5"
                R.id.ans24_6 -> twenty_four = "6"
                R.id.ans24_7 -> twenty_four = "7"
            }
        }
        //25번
        radioGroup11.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans25_1 -> twenty_five = "1"
                R.id.ans25_2 -> twenty_five = "2"
                R.id.ans25_3 -> twenty_five = "3"
                R.id.ans25_4 -> twenty_five = "4"
                R.id.ans25_5 -> twenty_five = "5"
                R.id.ans25_6 -> twenty_five = "6"
                R.id.ans25_7 -> twenty_five = "7"
            }
        }


        btn_result2.setOnClickListener {
            nineteen_25 = nineteen+twenty+twenty_one+twenty_two+twenty_three+twenty_four+twenty_five
            total=one_nine+ten_eighteen+nineteen_25

            Log.i("show", "19-25 잘 들어갔을까~ $nineteen_25")
            Log.i("show", " [ 총 테스트 ] 뭐하는지 : $feelings,  총 점수 25개 $total "  )

            type1()
            val intent = Intent(this, ResultMain::class.java)
            startActivity(intent)

        }




    }

    fun type1(){


        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
        apiService = retrofit.create(ApiService::class.java)


        val version = Json_Test_Java(feelings,total.toString())

        comment = apiService.post_json_test_java("json", version)
        comment.enqueue(object : Callback<Json_Test_Java> {

            override fun onResponse(call: Call<Json_Test_Java>, response: Response<Json_Test_Java>) {
                Log.e("show", "2차")
                if (response.isSuccessful) {
                    Log.e("show", "성공!!!!!")
                } else {
                    val StatusCode = response.code()
                    Log.e("show", "Status Code : $StatusCode")
                }
            }
            override fun onFailure(call: Call<Json_Test_Java>, t: Throwable) {
                result = "error!!"
                Log.e("show", "실패....")
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