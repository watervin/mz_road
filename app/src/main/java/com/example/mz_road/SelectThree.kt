package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_select_three.*

class SelectThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_three)

        btn_result2.setOnClickListener {
            val intent = Intent(this, ResultMain::class.java)
            startActivity(intent)

        }
    }
}