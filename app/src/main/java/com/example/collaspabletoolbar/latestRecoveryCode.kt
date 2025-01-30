package com.example.collaspabletoolbar

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.appbar.AppBarLayout

class latestRecoveryCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize the image slider
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.albatros)) // Add image to slider
        imageList.add(SlideModel(R.drawable.albatros))
        imageList.add(SlideModel(R.drawable.albatros))
        imageList.add(SlideModel(R.drawable.albatros))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

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
                } else {
                    // Toolbar is expanded
                    searchLayoutOuter.visibility = LinearLayout.VISIBLE
                    searchLayoutInner.visibility = LinearLayout.GONE
                }
            }
        })
    }
}