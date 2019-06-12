package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MyArrayAdapter(context: Context, tasks: ArrayList<Task>, var listener: MyListener) :
    ArrayAdapter<Task>(context, R.layout.item_layout, tasks) {


    interface MyListener {
        fun onInteraction(index: Int)
        fun onDelete(index: Int)
    }

    private class ItemViewHolder {
        internal var text: TextView? = null
        internal var deadline: TextView? = null
        internal var image: ImageView? = null
        internal var priority: TextView? = null
    }

    private lateinit var viewHolder: ItemViewHolder

    override fun getView(position: Int, v: View?, parent: ViewGroup): View {

        var view = v
        lateinit var inflater: LayoutInflater
        if (view == null) {
            inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_layout, parent, false)

            viewHolder = ItemViewHolder()
            viewHolder.text = view!!.findViewById<View>(R.id.editTitle) as TextView
            viewHolder.deadline = view.findViewById<View>(R.id.textDeadline) as TextView
            viewHolder.image = view.findViewById<View>(R.id.imageView) as ImageView
            viewHolder.priority = view.findViewById<View>(R.id.textPriority) as TextView
        } else {
            viewHolder = view.tag as ItemViewHolder
        }

        val items = getItem(position)
        viewHolder.text!!.text = items!!.text
        viewHolder.deadline!!.text = items.deadline
        viewHolder.priority!!.text = items.priority.toString()
//        viewHolder.image!!.setImageResource(items.image)
        viewHolder.image!!.setImageResource(setImageId(items.image))


        view.setOnClickListener {
            listener.onInteraction(position)
        }

        view.setOnLongClickListener {
            listener.onDelete(position)
            true
        }

        view.tag = viewHolder
        return view
    }


    fun setImageId(i : Int) : Int{
//        val img = findViewById<ImageView>(R.id.imageView).imageView
        var imgResId = 0

        when (i) {
            0 -> imgResId = R.drawable.ic_launcher_round
            1 -> imgResId = R.drawable.obraz1
            2 -> imgResId = R.drawable.obraz2
            3 -> imgResId = R.drawable.obraz3
//            else -> imgResId = R.drawable.ic_launcher_round
        }
//        img.setImageResource(imgResId)
        return imgResId
    }



}


