package com.example.taskproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class DetailsScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_screen)
    }

    companion object{
        const val VALUE = "VALUE"
    }

    fun OKClick(view: View){
        val valueIntent = Intent(this, DetailsScreenActivity::class.java)
        var editValue = findViewById<EditText>(R.id.editTextTextPersonName)
        valueIntent.putExtra(VALUE, editValue.text.toString())
        setResult(RESULT_OK, valueIntent)
        finish()
    }
}