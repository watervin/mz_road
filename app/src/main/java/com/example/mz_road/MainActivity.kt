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
            val intent = Intent(this, FaceActivity::class.java)
            startActivity(intent)

        }
        btn_custom.setOnClickListener {
            val intent = Intent(this, ChoiceMain::class.java)
            startActivity(intent)

        }

        btn_django.setOnClickListener {
            val intent = Intent(this, GetActivity::class.java)
            startActivity(intent)

        }

    }
}