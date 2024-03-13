package com.wiquert.catcalories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wiquert.catcalories.databinding.ActivityMainBinding
import com.wiquert.catcalories.fragments.CalcFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragHolder, CalcFragment.newInstance())
            .commit()

    }
}