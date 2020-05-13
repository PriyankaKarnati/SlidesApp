package com.example.slides.extGallery

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.slides.R
import com.example.slides.databinding.FragmentExtGalleryBinding


class ExtGalFragment : AppCompatActivity() {
    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<FragmentExtGalleryBinding>(
            this,
            R.layout.fragment_ext_gallery
        )

        // Here, thisActivity is the current activity


        if (setPermissions()) {
            val viewModel = ViewModelProviders.of(this).get(ExtViewModel::class.java)
            binding.viewModel = viewModel

            val adapter = ExtPhotoAdapter()
//            viewModel.imagesList.observe(this, Observer { adapter.submitList(it)
//                Log.i("HRusu","${it.size}")})

            binding.galleryList.adapter = adapter


        }


    }

    private fun setPermissions(): Boolean {
        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return permission == PackageManager.PERMISSION_GRANTED
    }
}