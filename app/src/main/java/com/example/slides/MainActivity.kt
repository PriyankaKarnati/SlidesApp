package com.example.slides


import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.example.slides.extGallery.ExtGalFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mains)
//        val permission= ActivityCompat.requestPermissions(this, new String[]{"Manifest.permission.READ_PHONE_STATE"}, 225);
//        if(permission== PackageManager.PERMISSION_GRANTED) {
//            print("YES")
//        }
//        else{
//            return
//        }

    }


}
