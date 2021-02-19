package com.example.taskproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListCreation()
    }

    var MainList: MutableList<Int> = mutableListOf(1, 3, 5, 7, 9)
    val ADD_KEY: Int = 0
    val CHANGE_KEY: Int = 1
    var selectedItemPosition: Int = 0

    fun addValueClick(view: View){
        val detailsIntent =Intent(this, DetailsScreenActivity::class.java)
        startActivityForResult(detailsIntent, ADD_KEY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val listView: ListView = findViewById((R.id.listView))
        val text: Int? = data?.getStringExtra(DetailsScreenActivity.VALUE)?.toInt()
        val adapter: ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_list_item_1, MainList)
        listView.adapter = adapter

        if (text != null) {
            if (requestCode == ADD_KEY){
                MainList.add(MainList.size, text)
                adapter.notifyDataSetChanged()
            }
            if (requestCode == CHANGE_KEY){
                MainList[selectedItemPosition] = text
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun ListCreation(){

        val listView: ListView = findViewById(R.id.listView)
        val adapter: ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_list_item_1, MainList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            selectedItemPosition = position
            val detailsIntent =Intent(this, DetailsScreenActivity::class.java)
            startActivityForResult(detailsIntent, CHANGE_KEY)
        }
    }
}