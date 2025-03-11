package com.the.imageeffects


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.github.dhaval2404.imagepicker.ImagePicker
import com.the.imageeffects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.selectImCard.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (data != null){
                imageUri = data.data
                val intent = Intent(this, EditAcitvity::class.java)
                intent.putExtra("imageUri", imageUri.toString() )
                startActivity(intent)
            }
        }catch (exeption:Exception){

        }
    }
}