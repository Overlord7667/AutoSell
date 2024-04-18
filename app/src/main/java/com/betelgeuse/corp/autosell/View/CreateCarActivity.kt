package com.betelgeuse.corp.autosell.View

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.betelgeuse.corp.autosell.R

import com.bumptech.glide.Glide

class CreateCarActivity : AppCompatActivity() {
    private lateinit var imageCar: ImageView
    private lateinit var textName: EditText
    private lateinit var textAge: EditText
    private lateinit var textPrice: EditText
    private lateinit var createBtn: ImageButton
    private lateinit var saveBtn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.create_car_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageCar = findViewById(R.id.imageCar)
        textName = findViewById(R.id.nameText)
        textAge = findViewById(R.id.ageText)
        textPrice = findViewById(R.id.priceText)
        createBtn = findViewById(R.id.createButton)
        saveBtn = findViewById(R.id.saveButton)

        createBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            val imageUri: Uri? = data?.data
            Glide.with(this).load(imageUri).into(imageCar)
        }
    }

    companion object {
        private const val IMAGE_PICK_CODE = 1000
    }
}