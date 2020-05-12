package com.example.slides

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.slides.ExtGallery.ExtPhotoAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgURL: String?) {
   imgURL?.let {
//        val imgURI = imgURL.toUri().buildUpon().scheme("https").build()
//        with(imgView.context).load(imgURI).into(imgView)

        Glide.with(imgView.context).load(imgURL).centerCrop()
            .into(imgView);


    }

}

@BindingAdapter("listImage")
fun bindList(recyclerView: RecyclerView, data: List<String>?) {

    val adapter = recyclerView.adapter as ExtPhotoAdapter
    adapter.submitList(data)

}