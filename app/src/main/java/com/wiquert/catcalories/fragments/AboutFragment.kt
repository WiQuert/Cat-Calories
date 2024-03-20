package com.wiquert.catcalories.fragments

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wiquert.catcalories.BuildConfig
import com.wiquert.catcalories.R
import com.wiquert.catcalories.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAppName.text = getString(R.string.app_name)
        binding.tvAuthor.text = getText(R.string.developed)

        setAnimation(R.drawable.catsplash)

        setVersionApp()

    }



    private fun setAnimation(image: Int) {
        Thread{
            val source = ImageDecoder.createSource(resources, image)
            val drawable = ImageDecoder.decodeDrawable(source)
            binding.imAnimation.post {
                binding.imAnimation.setImageDrawable(drawable)
                if (drawable is AnimatedImageDrawable) {
                    drawable.start()
                }
            }
        } .start()
    }


    private fun setVersionApp() = with(binding) {
        val versionHeader = getString(R.string.version_app)
        val versionNum = BuildConfig.VERSION_NAME
        val versionApp = versionHeader + versionNum
        tvVersionApp.text = versionApp
    }



}
