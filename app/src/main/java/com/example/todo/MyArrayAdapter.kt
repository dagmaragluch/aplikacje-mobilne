package com.example.todo

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MyArrayAdapter(context: Context, tasks: ArrayList<Task>) :
    ArrayAdapter<Task>(context, R.layout.item_layout, tasks) {

    //view holder is used to prevent findViewById calls
    private class ItemViewHolder {
        internal var text: TextView? = null
        internal var deadline: TextView? = null
        internal var image: ImageView? = null
        internal var priority: TextView? = null
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        var view = view
        val viewHolder: ItemViewHolder
        lateinit var inflater : LayoutInflater
        if (view == null) {
             inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_layout, parent, false)

            viewHolder = ItemViewHolder()
            viewHolder.text = view!!.findViewById<View>(R.id.textTitle) as TextView
            viewHolder.deadline = view.findViewById<View>(R.id.textDeadline) as TextView
//            viewHolder.image = view.findViewById<View>(R.id.imageView) as ImageView
            viewHolder.priority = view.findViewById<View>(R.id.textPriority) as TextView
        } else {
            viewHolder = view.tag as ItemViewHolder
        }

        val items = getItem(position)
        viewHolder.text!!.text = items!!.text
        viewHolder.deadline!!.text = items.deadline
        viewHolder.priority!!.text = items.priority.toString()
//        viewHolder.image!!.setImageResource(items.image)

        //shows how to handle events of views of items
        viewHolder.text!!.setOnClickListener {
            Toast.makeText(
                context, "Clicked title of " + items.text,
                Toast.LENGTH_SHORT
            ).show()


        }
        view.tag = viewHolder

        return view
    }


    /**************/
//            val builder = AlertDialog.Builder(context!!)
////            val inflater = layoutInflater
//            builder.setTitle("EditText")
//            val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
//            val editText = dialogLayout.findViewById<EditText>(R.id.editText)
//            builder.setView(dialogLayout)
//            builder.setPositiveButton("OK") { dialogInterface, i ->
//
//                var string = editText.text.toString()
//                //println("STRING w editText = $string")
//                mainFragment.temporaryClass.pictures[nr].description = string
////                items[position]
//                viewHolder.text!!.text = items.text
//            }
//            builder.show()
    /*************/


}