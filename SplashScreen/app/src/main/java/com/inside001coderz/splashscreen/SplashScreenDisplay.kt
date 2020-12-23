package com.inside001coderz.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_display)

        val bg = object: Thread()
        {
           override fun run() {
                try{
                    sleep(3000)
                    val intent= Intent(applicationContext,MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }

        }
        bg.start()
    }
}