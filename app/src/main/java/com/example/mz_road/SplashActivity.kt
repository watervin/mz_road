package com.example.mz_road

import android.content.Intent
import android.location.Location
import android.location.LocationRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mz_road.MainActivity
import com.example.mz_road.R
import com.google.android.gms.location.FusedLocationProviderClient

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        },DURATION)



    }
    companion object {
        private const val DURATION : Long = 6000
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}