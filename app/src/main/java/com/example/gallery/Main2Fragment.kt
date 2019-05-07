package com.example.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_main2.*


class Main2Fragment : Fragment(), RatingBar.OnRatingBarChangeListener {

    lateinit var imageA: ImageView
    val mainFragment = MainFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imageA = activity!!.findViewById(R.id.imageViewA) as ImageView
        addOnClickText()

        if (activity?.intent != null) {
            val extra = activity!!.intent.getIntExtra("data", 0)
            pictureActivity(extra)
        }

    }


    fun pictureActivity(nr: Int) {

        if (mainFragment.temporaryClass.pictures.isEmpty()) {
            mainFragment.temporaryClass.addPictures()
            mainFragment.temporaryClass.sortPictures()
        }
        imageA.setImageResource(mainFragment.temporaryClass.pictures[nr].id)
        setText(nr)
        setRatingBar(nr)
        // mainFragment.temporaryClass.pictures.forEach { println(it) }
    }


    fun setText(nr: Int) {
        var textView = activity!!.findViewById(R.id.textView) as TextView
        textView.text = mainFragment.temporaryClass.pictures[nr].description
    }

    fun setRatingBar(nr: Int) {
        var ratingBar = activity!!.findViewById(R.id.ratingBar) as RatingBar
        ratingBar.rating = mainFragment.temporaryClass.pictures[nr].rating.toFloat()

    }

    fun addOnClickText() {
        println("addOnClickText addOnClickText addOnClickText ")
        var nr = 0

        var textView = activity!!.findViewById(R.id.textView) as TextView
        textView.setOnClickListener {
            editText(nr)
        }

        ratingBar.onRatingBarChangeListener = this
    }


    fun editText(nr: Int) {
        val builder = AlertDialog.Builder(context!!)
        val inflater = layoutInflater
        builder.setTitle("EditText")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i ->

            var string = editText.text.toString()
            println("STRING w editText = $string")
            mainFragment.temporaryClass.pictures[nr].description = string
            // mainFragment.temporaryClass.pictures.forEach { println(it) }
            setText(nr)
        }
        builder.show()
    }


    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        // ratingBar!!. = rating.roundToInt()
        //mainFragment.temporaryClass.pictures[].rating = rating.roundToInt()
    }


}