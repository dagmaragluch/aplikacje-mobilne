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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       // if (temporaryClass.pictures.isEmpty()) {
            temporaryClass.addPictures()
            addImages()
      //  }
        temporaryClass.sortPictures()
        showPictures()


    }

    /****************/

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

    /*fun onClick(view: View) {
        var s = when (view) {
            button1 -> "button 1"
            button2 -> "button 2"
            else -> "button 3"
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            var myintent = Intent(activity, Main2Activity::class.java)
            myintent.putExtra("data", s)
            startActivity(myintent)
        } else {
            var frag = fragmentManager!!.findFragmentById(R.id.main2fragment) as Main2Fragment
            frag.display(s)
        }
    }*/


    /*override fun onFragmentInteraction(picture: Picture) {
        val intent = Intent()
        intent.putExtra("newRating",picture.rating)
        intent.putExtra("newDescription", picture.description)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }*/


    fun onImageClick(id: Int) {

        Toast.makeText(activity, "You clicked on ImageView $id", Toast.LENGTH_SHORT).show()


        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            var myintent = Intent(activity, Main2Activity::class.java)
            myintent.putExtra("data", id)
            startActivity(myintent)
        } else {
            var frag = fragmentManager!!.findFragmentById(R.id.main2fragment) as Main2Fragment
            frag.pictureActivity(id)
        }


    }


}