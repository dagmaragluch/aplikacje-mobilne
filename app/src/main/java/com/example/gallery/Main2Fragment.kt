package com.example.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

class Main2Fragment : Fragment() {

//    var imageA : ImageView = activity!!.findViewById(R.id.imageViewA)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity?.intent != null) {
//            val extra = activity!!.intent.getStringExtra("data")
//            display(extra)

//            val extra = activity!!.intent.getIntExtra("data", 0)
//            pictureActivity(extra)
        }
        pictureActivity()
    }

//    fun display(s: String?) {
//        if (s != null)
//            textView.text = s
//    }



//    fun pictureActivity(nr : Int) {
//        imageA.setImageResource(nr)
//    }

    fun pictureActivity() {
        Toast.makeText(activity,"Hello World!", Toast.LENGTH_SHORT).show()
    }


}