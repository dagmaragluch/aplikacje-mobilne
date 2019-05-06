package com.example.gallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    val temporaryClass = TemporaryClass()

    var imageList = ArrayList<ImageView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temporaryClass.addPictures()
        addImages()
        temporaryClass.sortPictures()
        showPictures()


    }


    fun addImages() {
        imageList.add(findViewById<ImageView>(R.id.imageView1).imageView1)
        imageList.add(findViewById<ImageView>(R.id.imageView2).imageView2)
        imageList.add(findViewById<ImageView>(R.id.imageView3).imageView3)
        imageList.add(findViewById<ImageView>(R.id.imageView4).imageView4)
        imageList.add(findViewById<ImageView>(R.id.imageView5).imageView5)

        for (i in imageList.indices) {
            imageList[i].setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "You clicked on ImageView.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    fun showPictures() {

        for (i in imageList.indices) {
            imageList[i].setImageResource(temporaryClass.pictures[i].id)
        }
    }

    fun pictureActivity(){

    }


}



