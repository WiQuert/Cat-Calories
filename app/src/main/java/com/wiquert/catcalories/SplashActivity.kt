package com.wiquert.catcalories

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.wiquert.catcalories.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Thread {
            val source = ImageDecoder.createSource(resources, R.drawable.catsplash)
            val drawable = ImageDecoder.decodeDrawable(source)
            binding.imSplash.post {
                binding.imSplash.setImageDrawable(drawable)
                if (drawable is AnimatedImageDrawable) {
                    drawable.start()
                }
            }

        }.start()



                timer = object : CountDownTimer(2000, 1000) {

                    override fun onTick(p0: Long) {

                    }

                    override fun onFinish() {
                        val intent = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(intent)
                    }

                }
                    .start()
            }


            override fun onDestroy() {
                super.onDestroy()
                timer.cancel()
            }

    }






