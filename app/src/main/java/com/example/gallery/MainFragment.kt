package com.example.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        temporaryClass.addPictures()
        addImages()
        temporaryClass.sortPictures()
        showPictures()

    }

    /****************/

    val temporaryClass = TemporaryClass()
    var imageList = ArrayList<ImageView>()


    fun addImages() {

        imageList.add(activity!!.findViewById(R.id.imageView1))
        imageList.add(activity!!.findViewById(R.id.imageView2))
        imageList.add(activity!!.findViewById(R.id.imageView3))
        imageList.add(activity!!.findViewById(R.id.imageView4))
        imageList.add(activity!!.findViewById(R.id.imageView5))


        for (i in imageList.indices) {
            imageList[i].setOnClickListener {
                Toast.makeText(
                    activity,
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

    fun pictureActivity() {

    }


}