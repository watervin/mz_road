package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_face2.*

class WaitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait)


        Glide.with(this).load(R.raw.act_gif).into(imageView)

        Handler().postDelayed({
            val intent = Intent(this, ResultMainFace::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        },DURATION)



    }
    companion object {
        private const val DURATION : Long = 50000
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}