package com.the.imageeffects

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants
import com.the.imageeffects.databinding.ActivityEditAcitvityBinding


class EditAcitvity : AppCompatActivity() {

    private lateinit var binding: ActivityEditAcitvityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = intent.getStringExtra("imageUri").toString()
        val dsPhotoEditor = Intent(this, DsPhotoEditorActivity::class.java)
        dsPhotoEditor.data = imageUri.toUri()
        dsPhotoEditor.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "Edited Image")
        startActivityForResult(dsPhotoEditor, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK){
           if (requestCode == 100){
               val outPutUri: Uri? = data!!.data
               binding.ivEdited.setImageURI(outPutUri)
           }
        }
    }
}