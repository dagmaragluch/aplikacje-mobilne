package com.example.gallery

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

class MainFragment : Fragment() {

    val temporaryClass = TemporaryClass()
    var imageList = ArrayList<ImageView>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        temporaryClass.addPictures()
        addImages()
        temporaryClass.sortPictures()
        showPictures()
    }

    fun addImages() {

        imageList.add(activity!!.findViewById(R.id.imageView1))
        imageList.add(activity!!.findViewById(R.id.imageView2))
        imageList.add(activity!!.findViewById(R.id.imageView3))
        imageList.add(activity!!.findViewById(R.id.imageView4))
        imageList.add(activity!!.findViewById(R.id.imageView5))


        for (i in imageList.indices) {
            imageList[i].setOnClickListener {
                onImageClick(i)
            }
        }
    }


    fun showPictures() {

        for (i in imageList.indices) {
            imageList[i].setImageResource(temporaryClass.pictures[i].id)
        }
    }



    fun onImageClick(id: Int) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val myintent = Intent(activity, Main2Activity::class.java)
            myintent.putExtra("data", id)
            startActivity(myintent)
        } else {
            var frag = fragmentManager!!.findFragmentById(R.id.main2fragment) as Main2Fragment
            frag.pictureActivity(id)
        }
    }


}