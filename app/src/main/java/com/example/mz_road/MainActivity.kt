package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_face.setOnClickListener {
            val intent = Intent(this, Face2Activity::class.java)
            startActivity(intent)

        }
        btn_custom.setOnClickListener {
            val intent = Intent(this, ChoiceMain::class.java)
            startActivity(intent)

        }

        btn_location.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)

        }

    }
}