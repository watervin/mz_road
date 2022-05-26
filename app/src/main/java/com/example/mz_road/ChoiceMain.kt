package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_main.*

class ChoiceMain : AppCompatActivity() {

    lateinit var select_position1 : String
    lateinit var select_position2 : String
    lateinit var select_position3 : String
    lateinit var select_position4 : String
    lateinit var select_position5 : String
    lateinit var select_position6 : String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_main)


        //어댑터 1
        var select1 = resources.getStringArray(R.array.my_array)
        spinner1.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select1)
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position1 = select1[position].toString()
                Log.i("show", "선택값")

            }
        }

        //어댑터 2
        var select2 = resources.getStringArray(R.array.my_array)
        spinner2.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select2)
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position2 = select2[position].toString()
                Log.i("show", "선택값")

            }
        }

        //어댑터 3
        var select3 = resources.getStringArray(R.array.my_array)
        spinner3.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select3)
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position3 = select3[position].toString()
                Log.i("show", "선택값")

            }
        }



        //어댑터 4
        var select4 = resources.getStringArray(R.array.my_array)
        spinner4.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select4)
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position4 = select4[position].toString()
                Log.i("show", "선택값")

            }
        }

        //어댑터 5
        var select5 = resources.getStringArray(R.array.my_array)
        spinner5.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select5)
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position5 = select5[position].toString()
                Log.i("show", "선택값")

            }
        }

        //어댑터 6
        var select6 = resources.getStringArray(R.array.my_array)
        spinner6.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, select6)
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                select_position6 = select6[position].toString()
                Log.i("show", "선택값")

            }
        }
        btn_next.setOnClickListener {
            val intent = Intent(this, SelectOne::class.java)
            startActivity(intent)

        }

    }
}