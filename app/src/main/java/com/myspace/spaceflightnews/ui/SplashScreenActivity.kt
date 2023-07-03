package com.myspace.spaceflightnews.ui


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.myspace.spaceflightnews.R

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_DURATION = 5000L // 5 seconds
    private val COUNTDOWN_INTERVAL = 1000L // 1 second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val countdownText = findViewById<TextView>(R.id.countdown_text)

        val countDownTimer = object : CountDownTimer(SPLASH_SCREEN_DURATION, COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                countdownText.text = secondsLeft.toString()
            }

            override fun onFinish() {
                navigateToMainActivity()
            }
        }

        countDownTimer.start()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
