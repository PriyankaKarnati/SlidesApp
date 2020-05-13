package com.example.slides.extGallery

import android.app.Application
import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.io.File
import kotlin.coroutines.CoroutineContext


class ExtViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    private var _imagesList = MutableLiveData<List<String>>()
    var imagesList: LiveData<List<String>> = _imagesList

    init {
        getAllImages()

    }

    fun getImageList(): List<String>? {
        return imagesList.value
    }

    private fun loadImagesFromInternalStorage(): ArrayList<String> {
        val path = Environment.DIRECTORY_PICTURES
        val files = File(path).listFiles()
        Log.i("PICTURES", "${files.size}")
        val imagePath = ArrayList<String>()
        for (file in files!!) imagePath.add(file.absolutePath)
        return imagePath

    }


    fun getAllImages() {
        launch(Dispatchers.Main) {
            _imagesList.value = withContext(Dispatchers.IO) {
                loadImagesFromInternalStorage()
            }
        }
        Log.i("called", "called")
    }
}

