package com.example.slides.ExtGallery

import android.app.Activity
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.ViewModelProviders
import com.example.slides.R
import com.example.slides.databinding.ActivityExtGalleryBinding

class ExtGalleryActivity : FragmentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = DataBindingUtil.setContentView<ActivityExtGalleryBinding>(this,R.layout.activity_ext_gallery)



        binding.extViewModel = ExtViewModel(application)

        binding.galleryList.adapter = ExtPhotoAdapter()


    }

}