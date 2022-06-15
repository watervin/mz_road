package com.example.mz_road

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
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
import kotlin.math.abs

class SelectThree : AppCompatActivity() {

    //retrofit
    internal lateinit var retrofit: Retrofit
    internal lateinit var apiService: ApiService
    internal lateinit var comment: Call<Json_Test_Java>
    internal lateinit var comment2: Call<ResponseBody>
    internal lateinit var result:String

    //위도 경도
    var mLocationRequest_result:String = ""
    private var mFusedLocationProviderClient: FusedLocationProviderClient? = null // 현재 위치를 가져오기 위한 변수
    lateinit var mLastLocation: Location  // 위치 값을 가지고 있는 객체
    internal lateinit var mLocationRequest: LocationRequest // 위치 정보 요청의 매개변수를 저장하는
    private val REQUEST_PERMISSION_LOCATION = 10

    //감정
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

        //값 받아오기
        feelings = intent.getStringExtra("feelings").toString()
        one_nine = intent.getStringExtra("one_nine").toString()
        ten_eighteen = intent.getStringExtra("ten_eighteen").toString()
        mLocationRequest_result = intent.getStringExtra("mLocationRequest_result").toString()


        Log.i("show", "mLocationRequest_result가 잘 넘어왔는지 확인 $mLocationRequest_result")
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


        btn_next1.setOnClickListener {

            if ((nineteen == "") || (twenty == "") || (twenty_one == "") || (twenty_two == "") || (twenty_three == "") || (twenty_four == "") || (twenty_five == "")) {

                Toast.makeText(this@SelectThree, "선택 하지 않은 항목이 있습니다. ", Toast.LENGTH_SHORT).show()

            } else {
                nineteen_25 =
                    nineteen + twenty + twenty_one + twenty_two + twenty_three + twenty_four + twenty_five
                total = one_nine + ten_eighteen + nineteen_25

                Log.i("show", "19-25 잘 들어갔을까~ $nineteen_25")
                Log.i("show", " [ 총 테스트 ] 뭐하는지 : $feelings,  총 점수 25개 $total ")

                type1()
                val intent = Intent(this, ResultMain::class.java)
                startActivity(intent)
            }
        }

        mLocationRequest =  LocationRequest.create().apply {

            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

//버튼 이벤트 없이 그냥 찾기
        if (checkPermissionForLocation(this)) {
            startLocationUpdates()
        }


    }

    fun type1(){


        retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
        apiService = retrofit.create(ApiService::class.java)


        val version = Json_Test_Java(feelings.toString(),total.toString(),"null","null")


        Log.e("show", "$version")
        comment = apiService.post_json_test_java("json", version)
        Log.e("show", "$comment")
        comment.enqueue(object : Callback<Json_Test_Java> {

            override fun onResponse(call: Call<Json_Test_Java>, response: Response<Json_Test_Java>) {
                Log.e("show", "2차")
                if (response.isSuccessful) {
                    Log.e("show", "성공!!!!!")

                } else {
                    val StatusCode = response.code()
                    var a = response
                    Log.e("show","$a")
                    Log.e("show", "Status Code : $StatusCode")
                    if (response.code() == 400) {
                        response.errorBody()?.let { Log.e("show2222", it.string()) }
                    }
                }
            }
            override fun onFailure(call: Call<Json_Test_Java>, t: Throwable) {
                try {
                    result = "error!!"
                    Log.e("show", "SelectThree 실패....")
                    var a = t.message
                    Log.e("show","$a")
                }
                catch (e : Exception)
                {
                    Log.e("show", "$e")
                }
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

    private fun startLocationUpdates() {

        //FusedLocationProviderClient의 인스턴스를 생성.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        // 기기의 위치에 관한 정기 업데이트를 요청하는 메서드 실행
        // 지정한 루퍼 스레드(Looper.myLooper())에서 콜백(mLocationCallback)으로 위치 업데이트를 요청
        mFusedLocationProviderClient!!.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())
    }

    // 시스템으로 부터 위치 정보를 콜백으로 받음
    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            // 시스템에서 받은 location 정보를 onLocationChanged()에 전달
            locationResult.lastLocation
            onLocationChanged(locationResult.lastLocation)
        }
    }

    // 시스템으로 부터 받은 위치정보를 화면에 갱신해주는 메소드
    fun onLocationChanged(location: Location) {
        mLastLocation = location

        var a = mLastLocation.latitude.toString()
        var b = abs(mLastLocation.longitude).toString()

        Log.e("여기는 위치 테스트입니다.show", "경도는 $a 위도는 $b ")

        mLocationRequest_result = a+","+b


        val intent = Intent(this, SelectThree::class.java)


        intent.putExtra("mLocationRequest_result",mLocationRequest_result).toString()

    }




    // 위치 권한이 있는지 확인하는 메서드
    private fun checkPermissionForLocation(context: Context): Boolean {
        // Android 6.0 Marshmallow 이상에서는 위치 권한에 추가 런타임 권한이 필요
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                // 권한이 없으므로 권한 요청 알림 보내기
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_PERMISSION_LOCATION)
                false
            }
        } else {
            true
        }
    }

    // 사용자에게 권한 요청 후 결과에 대한 처리 로직
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates()


                //여기에 추가


            } else {
                Log.d("ttt", "onRequestPermissionsResult() _ 권한 허용 거부")
                Toast.makeText(this, "권한이 없어 해당 기능을 실행할 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}