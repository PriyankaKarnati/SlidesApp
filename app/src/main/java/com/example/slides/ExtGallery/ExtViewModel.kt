package com.example.slides.ExtGallery

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ExtViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    private var _imagesList = MutableLiveData<List<String>>()
    private var imagesList: LiveData<List<String>> = _imagesList

    init{
        getAllImages(application.applicationContext)

    }
    fun getImageList():List<String>?{
        return imagesList.value
    }
    internal fun LoadImagesFromInternalStorage(context: Context):ArrayList<String>{

                 val uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI
                 val cursor: Cursor?
                 val column_index_data: Int
                 val column_index_folder_name: Int
                 val listOfAllImages = ArrayList<String>()
                 var absolutePathOfImage: String? = null

                val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

                cursor =  context.contentResolver.query(uri, projection, null, null, null)
                column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
                column_index_folder_name  = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
                while (cursor!!.moveToNext()){
                    absolutePathOfImage = cursor.getString(column_index_data)
                    listOfAllImages.add(absolutePathOfImage)
                }
                 return listOfAllImages

    }

    fun getAllImages(context: Context) {
        launch(Dispatchers.Main) {
            _imagesList.value = withContext(Dispatchers.IO) {
                LoadImagesFromInternalStorage(context)
            }
        }
    }
}