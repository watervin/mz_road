package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice_main.*

class SelectOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_one)

        btn_next.setOnClickListener {
            val intent = Intent(this, SelectTwo::class.java)
            startActivity(intent)

        }
    }
}