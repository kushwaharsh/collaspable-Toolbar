package com.example.collaspabletoolbar

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.collaspabletoolbar.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the image slider
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.albatros)) // Add image to slider
        imageList.add(SlideModel(R.drawable.albatros))
        imageList.add(SlideModel(R.drawable.albatros))
        imageList.add(SlideModel(R.drawable.albatros))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

       imageSlider.scrollIndicators


        // Initialize AppBarLayout and search layouts
        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
        val searchLayoutOuter = findViewById<LinearLayout>(R.id.outerSearchLayout)
        val searchLayoutInner = findViewById<LinearLayout>(R.id.innerSearchLayout)

        // Set AppBarLayout listener to toggle search layout visibility
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                val totalScrollRange = appBarLayout?.totalScrollRange ?: 0

                // Check if the AppBarLayout is collapsed
                if (Math.abs(verticalOffset) == totalScrollRange) {
                    // Toolbar is collapsed
                    searchLayoutOuter.visibility = LinearLayout.GONE
                    searchLayoutInner.visibility = LinearLayout.VISIBLE
                    binding.gradientBlend.visibility = View.GONE

                } else {
                    // Toolbar is expanded
                    searchLayoutOuter.visibility = LinearLayout.VISIBLE
                    searchLayoutInner.visibility = LinearLayout.GONE
                    binding.gradientBlend.visibility = View.VISIBLE

                }
            }
        })
    }
}
