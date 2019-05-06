package com.example.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main2.view.*

class Main2Fragment : Fragment() {


    lateinit var imageA: ImageView
    val mainFragment = MainFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imageA = activity!!.findViewById(R.id.imageViewA) as ImageView
        println("IMG = $imageA")

        if (activity?.intent != null) {

            val extra = activity!!.intent.getIntExtra("data", 0)
            println("EXTRA = $extra")
            pictureActivity(extra)
        }

    }


    fun pictureActivity(nr: Int) {
        println("PICTURE ACTIVITY")
        if (mainFragment.temporaryClass.pictures.isEmpty()){
            mainFragment.temporaryClass.addPictures()
            mainFragment.temporaryClass.sortPictures()
        }

        imageA.setImageResource(mainFragment.temporaryClass.pictures[nr].id)

        //mainFragment.temporaryClass.pictures.forEach { println(it) }
    }


}