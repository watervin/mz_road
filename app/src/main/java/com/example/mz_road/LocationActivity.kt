package com.example.mz_road

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import android.widget.Button
import kotlinx.android.synthetic.main.activity_face2.*
import java.io.IOException
import java.util.*
import kotlin.math.*


open class LocationActivity : AppCompatActivity() {


    private var mFusedLocationProviderClient: FusedLocationProviderClient? =
        null // 현재 위치를 가져오기 위한 변수
    lateinit var mLastLocation: Location  // 위치 값을 가지고 있는 객체
    internal lateinit var mLocationRequest: LocationRequest // 위치 정보 요청의 매개변수를 저장하는
    private val REQUEST_PERMISSION_LOCATION = 10

    lateinit var text1: TextView
    lateinit var text2: TextView
    var locationManager: LocationManager? = null
    private val REQUEST_CODE_LOCATION: Int = 2
    var currentLocation: String = ""
    var latitude: Double? = null
    var longitude: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)



        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)


        mLocationRequest = LocationRequest.create().apply {

            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

//버튼 이벤트 없이 그냥 찾기
        if (checkPermissionForLocation(this)) {
            startLocationUpdates()
        }


    }

    private fun startLocationUpdates() {

        //FusedLocationProviderClient의 인스턴스를 생성.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        // 기기의 위치에 관한 정기 업데이트를 요청하는 메서드 실행
        // 지정한 루퍼 스레드(Looper.myLooper())에서 콜백(mLocationCallback)으로 위치 업데이트를 요청
        mFusedLocationProviderClient!!.requestLocationUpdates(
            mLocationRequest,
            mLocationCallback,
            Looper.myLooper()
        )
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

       latitude = mLastLocation.latitude
      longitude = abs(mLastLocation.longitude)

        var mGeocoder = Geocoder(applicationContext, Locale.KOREAN)
        var mResultList: List<Address>? = null
        try {
            mResultList = mGeocoder.getFromLocation(
                latitude!!, longitude!!, 1
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (mResultList != null) {
            Log.d("CheckCurrentLocation", mResultList[0].getAddressLine(0))
            currentLocation = mResultList[0].getAddressLine(0)
            currentLocation = currentLocation.substring(11)
            Log.d("CheckCurrentLocation", "현재 내 위치 값: $currentLocation")


//            Log.e("여기는 위치 테스트입니다.show", "경도는 $a 위도는 $b ")
//
//            var mLocationRequest_result = a + b


            val intent = Intent(this, SelectThree::class.java)


//            intent.putExtra("mLocationRequest_result", mLocationRequest_result).toString()
        }
        }




        // 위치 권한이 있는지 확인하는 메서드
        private fun checkPermissionForLocation(context: Context): Boolean {
            // Android 6.0 Marshmallow 이상에서는 위치 권한에 추가 런타임 권한이 필요
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    true
                } else {
                    // 권한이 없으므로 권한 요청 알림 보내기
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        REQUEST_PERMISSION_LOCATION
                    )
                    false
                }
            } else {
                true
            }
        }

        // 사용자에게 권한 요청 후 결과에 대한 처리 로직
        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
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
