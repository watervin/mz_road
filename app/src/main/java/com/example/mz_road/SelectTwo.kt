package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_choice_main.btn_next
import kotlinx.android.synthetic.main.activity_select_one.*

class SelectTwo : AppCompatActivity() {


    var feelings : String= ""

    var ten:String = ""
    var eleven:String = ""
    var twelve:String = ""
    var thirteen:String = ""
    var fourteen:String = ""
    var fifteen:String = ""
    var sixteen:String = ""
    var seveneteen:String = ""
    var eighteen:String =""

    var ten_eighteen:String=""
    var one_nine:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_two)


        feelings = intent.getStringExtra("feelings").toString()
        one_nine = intent.getStringExtra("one_nine").toString()


        Log.i("show", " SelectOne 페이지 값이 잘 넘어왔는지 확인 $feelings , $one_nine")

        //10번
        radioGroup5.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans10_1 -> ten= "1"
                R.id.ans10_2 -> ten = "2"
                R.id.ans10_3 -> ten = "3"
                R.id.ans10_4 -> ten = "4"
                R.id.ans10_5 -> ten = "5"
                R.id.ans10_6 -> ten = "6"
                R.id.ans10_7 -> ten = "7"
            }
            Log.i("radio", "10번 $ten")

        }

        //11번
        radioGroup6.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans11_1 -> eleven = "1"
                R.id.ans11_2 -> eleven = "2"
                R.id.ans11_3 -> eleven = "3"
                R.id.ans11_4 -> eleven = "4"
                R.id.ans11_5 -> eleven = "5"
                R.id.ans11_6 -> eleven = "6"
                R.id.ans11_7 -> eleven = "7"
            }
            Log.i("radio", "11번 $eleven")

        }

        //12번
        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans12_1 -> twelve = "1"
                R.id.ans12_2 -> twelve = "2"
                R.id.ans12_3 -> twelve = "3"
                R.id.ans12_4 -> twelve = "4"
                R.id.ans12_5 -> twelve = "5"
                R.id.ans12_6 -> twelve = "6"
                R.id.ans12_7 -> twelve = "7"
            }
            Log.i("radio", "12번 $twelve")

        }

        //13번
        radioGroup7.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans13_1 -> thirteen = "1"
                R.id.ans13_2 -> thirteen = "2"
                R.id.ans13_3 -> thirteen = "3"
                R.id.ans13_4 -> thirteen = "4"
                R.id.ans13_5 -> thirteen = "5"
                R.id.ans13_6 -> thirteen = "6"
                R.id.ans13_7 -> thirteen = "7"
            }
            Log.i("radio", "13번 $thirteen")

        }
        //14번
        radioGroup8.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans14_1 -> fourteen = "1"
                R.id.ans14_2 -> fourteen = "2"
                R.id.ans14_3 -> fourteen = "3"
                R.id.ans14_4 -> fourteen = "4"
                R.id.ans14_5 -> fourteen = "5"
                R.id.ans14_6 -> fourteen = "6"
                R.id.ans14_7 -> fourteen = "7"
            }
            Log.i("radio", "14번 $fourteen")
        }
        //15
        radioGroup9.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans15_1 -> fifteen = "1"
                R.id.ans15_2 -> fifteen = "2"
                R.id.ans15_3 -> fifteen = "3"
                R.id.ans15_4 -> fifteen = "4"
                R.id.ans15_5 -> fifteen = "5"
                R.id.ans15_6 -> fifteen = "6"
                R.id.ans15_7 -> fifteen = "7"
            }
            Log.i("radio", "15번 $fifteen")

        }
        //16번
        radioGroup11.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans16_1 -> sixteen = "1"
                R.id.ans16_2 -> sixteen = "2"
                R.id.ans16_3 -> sixteen = "3"
                R.id.ans16_4 -> sixteen = "4"
                R.id.ans16_5 -> sixteen = "5"
                R.id.ans16_6 -> sixteen = "6"
                R.id.ans16_7 -> sixteen = "7"
            }
            Log.i("radio", "16번 $sixteen")
        }

        //17번
        radioGroup12.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans17_1 -> seveneteen = "1"
                R.id.ans17_2 -> seveneteen = "2"
                R.id.ans17_3 -> seveneteen = "3"
                R.id.ans17_4 -> seveneteen = "4"
                R.id.ans17_5 -> seveneteen = "5"
                R.id.ans17_6 -> seveneteen = "6"
                R.id.ans17_7 -> seveneteen = "7"
            }
            Log.i("radio", "17번 $seveneteen")

        }
        //18번
        radioGroup13.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans18_1 -> eighteen = "1"
                R.id.ans18_2 -> eighteen = "2"
                R.id.ans18_3 -> eighteen = "3"
                R.id.ans18_4 -> eighteen = "4"
                R.id.ans18_5 -> eighteen = "5"
                R.id.ans18_6 -> eighteen = "6"
                R.id.ans18_7 -> eighteen = "7"
            }
            Log.i("radio", "18번 $eighteen")

        }



        btn_next.setOnClickListener {


            if ((ten =="") || (eleven=="") || (twelve=="") || (thirteen=="") || (fourteen=="") || (sixteen=="") || (seveneteen=="") || (eighteen==""))
            {

                Toast.makeText(this@SelectTwo, "선택 하지 않은 항목이 있습니다. ", Toast.LENGTH_SHORT).show()

            }
            else {
                ten_eighteen =
                    ten + eleven + twelve + thirteen + fourteen + fifteen + sixteen + seveneteen + eighteen
                Log.i("show", "10-18 잘 들어갔을까~ $ten_eighteen")
                Log.i("show", "여기를 주목!")

                Log.i("show", "$feelings,$one_nine,$ten_eighteen")
                val intent = Intent(this, SelectThree::class.java)

                intent.putExtra("feelings", feelings).toString()
                intent.putExtra("one_nine", one_nine).toString()
                intent.putExtra("ten_eighteen", ten_eighteen).toString()

                startActivity(intent)
            }
        }


    }

}