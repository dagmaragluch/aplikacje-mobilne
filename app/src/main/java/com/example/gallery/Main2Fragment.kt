package com.example.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main2.*
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
        addOnClickText()

        if (activity?.intent != null) {
            val extra = activity!!.intent.getIntExtra("data", 0)
            //println("EXTRA = $extra")
            pictureActivity(extra)
        }

    }


//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        activity.onRestoreInstanceState(savedInstanceState)
//        textView.text = savedInstanceState?.getCharSequence("data").toString()
//    }


    fun pictureActivity(nr: Int) {
        // println("PICTURE ACTIVITY")
        if (mainFragment.temporaryClass.pictures.isEmpty()) {
            mainFragment.temporaryClass.addPictures()
            mainFragment.temporaryClass.sortPictures()
        }

        imageA.setImageResource(mainFragment.temporaryClass.pictures[nr].id)

//        editText(nr)
        setText(nr)

        mainFragment.temporaryClass.pictures.forEach { println(it) }
    }


    fun setText(nr: Int) {

        var textView = activity!!.findViewById(R.id.textView) as TextView
        textView.text = mainFragment.temporaryClass.pictures[nr].description
    }

    fun addOnClickText() {
        println("addOnClickText addOnClickText addOnClickText ")
        var nr = 0

        var textView = activity!!.findViewById(R.id.textView) as TextView
        textView.setOnClickListener {
            editText(nr)
        }
    }


    fun editText(nr: Int) {
        val builder = AlertDialog.Builder(context!!)
        val inflater = layoutInflater
        builder.setTitle("With EditText")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i ->
            // Toast.makeText(activity, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show()
            var string = editText.text.toString()
            println("STRING w editText = $string")

            mainFragment.temporaryClass.pictures[nr].description = string
            mainFragment.temporaryClass.pictures.forEach { println(it) }
            setText(nr)
        }
        builder.show()
    }


}