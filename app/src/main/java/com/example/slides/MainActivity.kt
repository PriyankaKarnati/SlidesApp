package com.example.slides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.slides.ExtGallery.ExtGalleryActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonID = findViewById<FloatingActionButton>(R.id.fab)

        buttonID.setOnClickListener{
            val intent = Intent(applicationContext,ExtGalleryActivity::class.java)
            startActivity(intent)
        }
    }
}
