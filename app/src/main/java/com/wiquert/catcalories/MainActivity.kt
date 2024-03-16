package com.wiquert.catcalories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wiquert.catcalories.databinding.ActivityMainBinding
import com.wiquert.catcalories.fragments.AboutFragment
import com.wiquert.catcalories.fragments.CalcFragment
import com.wiquert.catcalories.fragments.InfoFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(CalcFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_calc -> changeFragment(CalcFragment())
                R.id.menu_info -> changeFragment(InfoFragment())
                R.id.menu_about -> changeFragment(AboutFragment())
            }

            true
        }


    }


    private fun changeFragment(fragment: Fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragHolder, fragment)
            transaction.commit()
    }


}