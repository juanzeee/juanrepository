package com.example.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashActivity {


    class SplashActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)
        }

        fun startGameFacil(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("modoDificuldade", "Fácil")
            startActivity(intent)
            finish()
        }

        fun startGameDificil(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("modoDificuldade", "Difícil")
            startActivity(intent)
            finish()
        }
    }
}