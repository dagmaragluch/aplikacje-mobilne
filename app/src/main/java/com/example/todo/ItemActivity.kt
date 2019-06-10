package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout_edit.*


class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout_edit)

        button.setOnClickListener { v -> onClick(v) }


    }



    fun onClick(view: View){
        val text = findViewById<View>(R.id.editTitle) as EditText
        val eTitle = text.text.toString()



        Log.d("edit", "TITLE = $eTitle")

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("task", eTitle)
        startActivity(intent)
        finish()

    }
}