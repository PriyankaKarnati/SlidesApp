package com.example.slides.ExtGallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.slides.R
import com.example.slides.bindImage
import kotlin.reflect.typeOf

class ExtPhotoAdapter:ListAdapter<String,ExtPhotoAdapter.ListItemViewHolder>(DiffCallBack){



        override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): ListItemViewHolder {
            val layoutInflater =
                LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.grid_item_view,
                    parent, false)
            return ListItemViewHolder(view)
        }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)

        }
    }

    class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageID = itemView.findViewById<ImageView>(R.id.GalImageView)
        fun bind(imageURL:String) {
            with(imageURL) {
                bindImage(imageID, this)
            }
        }

    }


            companion object DiffCallBack : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem is String == newItem is String
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.equals(newItem)
        }


    }
}