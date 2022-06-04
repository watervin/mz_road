package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_choice_main.btn_next
import kotlinx.android.synthetic.main.activity_select_one.*

class SelectOne : AppCompatActivity() {

    var feelings : String= ""



    var one :String =""
    var two :String =""
    var three :String =""
    var four :String =""
    var five :String =""
    var six :String =""
    var seven :String =""
    var eight :String =""
    var nine :String =""
    var one_nine:String = ""
    var check : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_one)
        //값 넘기기
        feelings = intent.getStringExtra("feelings").toString()



        Log.i("show", "Choice main 값이 잘 넘어왔는지 확인  [ $feelings ]")

        //1번
        radioGroup5.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans1_1 -> one = "1"
                R.id.ans1_2 -> one = "2"
                R.id.ans1_3 -> one = "3"
                R.id.ans1_4 -> one = "4"
                R.id.ans1_5 -> one = "5"
                R.id.ans1_6 -> one = "6"
                R.id.ans1_7 -> one = "7"
                else -> check = 1
            }
            Log.i("radio", "1번 $one")
        }


        //2번
        radioGroup6.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans2_1 -> two = "1"
                R.id.ans2_2 -> two = "2"
                R.id.ans2_3 -> two = "3"
                R.id.ans2_4 -> two = "4"
                R.id.ans2_5 -> two = "5"
                R.id.ans2_6 -> two = "6"
                R.id.ans2_7 -> two = "7"
                else -> check = 1
            }
            Log.i("radio", "2번 $two")
        }


        //3번
        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans3_1 -> three = "1"
                R.id.ans3_2 -> three = "2"
                R.id.ans3_3 -> three = "3"
                R.id.ans3_4 -> three = "4"
                R.id.ans3_5 -> three = "5"
                R.id.ans3_6 -> three = "6"
                R.id.ans3_7 -> three = "7"
                else -> check = 1
            }
            Log.i("radio", "3번 $three")
        }


        //4번
        radioGroup7.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans4_1 -> four = "1"
                R.id.ans4_2 -> four = "2"
                R.id.ans4_3 -> four = "3"
                R.id.ans4_4 -> four = "4"
                R.id.ans4_5 -> four = "5"
                R.id.ans4_6 -> four = "6"
                R.id.ans4_7 -> four = "7"
                else -> check = 1
            }
            Log.i("radio", "4번 $four")
        }



        //5번
        radioGroup8.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans5_1 -> five = "1"
                R.id.ans5_2 -> five = "2"
                R.id.ans5_3 -> five = "3"
                R.id.ans5_4 -> five = "4"
                R.id.ans5_5 -> five = "5"
                R.id.ans5_6 -> five = "6"
                R.id.ans5_7 -> five = "7"
                else -> check = 1
            }
            Log.i("radio", "5번 $five")
        }



        //6번
        radioGroup9.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans6_1 -> six = "1"
                R.id.ans6_2 -> six = "2"
                R.id.ans6_3 -> six = "3"
                R.id.ans6_4 -> six = "4"
                R.id.ans6_5 -> six = "5"
                R.id.ans6_6 -> six = "6"
                R.id.ans6_7 -> six = "7"
                else -> check = 1
            }
            Log.i("radio", "6번 $six")
        }



        //7번
        radioGroup11.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans7_1 -> seven = "1"
                R.id.ans7_2 -> seven = "2"
                R.id.ans7_3 -> seven = "3"
                R.id.ans7_4 -> seven = "4"
                R.id.ans7_5 -> seven = "5"
                R.id.ans7_6 -> seven = "6"
                R.id.ans7_7 -> seven = "7"
                else -> check = 1
            }
            Log.i("radio", "7번 $seven")
        }




        //8번
        radioGroup12.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans8_1 -> eight = "1"
                R.id.ans8_2 -> eight = "2"
                R.id.ans8_3 -> eight = "3"
                R.id.ans8_4 -> eight = "4"
                R.id.ans8_5 -> eight = "5"
                R.id.ans8_6 -> eight = "6"
                R.id.ans8_7 -> eight = "7"
                else -> check = 1
            }
            Log.i("radio", "8번 $eight")
        }



        //9번
        radioGroup13.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.ans9_1 -> nine = "1"
                R.id.ans9_2 -> nine = "2"
                R.id.ans9_3 -> nine = "3"
                R.id.ans9_4 -> nine = "4"
                R.id.ans9_5 -> nine = "5"
                R.id.ans9_6 -> nine = "6"
                R.id.ans9_7 -> nine = "7"

            }
            Log.i("radio", "9번 $nine")
        }



        btn_next.setOnClickListener {


            if ((one =="") || (two=="") || (three=="") || (four=="") || (five=="") || (six=="") || (seven=="") || (eight=="") || (nine==""))
            {

                Toast.makeText(this@SelectOne, "선택 하지 않은 항목이 있습니다. ", Toast.LENGTH_SHORT).show()

            }
            else {
                one_nine = one + two + three + four + five + six + seven + eight + nine
                Log.i("show", "잘 들어갔을까~ $one_nine")


                val intent = Intent(this, SelectTwo::class.java)

                intent.putExtra("feelings", feelings).toString()
                intent.putExtra("one_nine", one_nine).toString()



                startActivity(intent)
            }
        }


    }
}