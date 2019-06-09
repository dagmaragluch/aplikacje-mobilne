package com.example.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import android.widget.AdapterView.OnItemLongClickListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    val itemsArray = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItems(itemsArray)

        val myadapter = MyArrayAdapter(this, itemsArray)
        listView1.adapter = myadapter



        listView1.onItemLongClickListener = OnItemLongClickListener { _, _, index, _ ->
            Toast.makeText(this, "$index", Toast.LENGTH_SHORT).show()
            itemsArray.removeAt(index)
            myadapter.notifyDataSetChanged()
            true
        }


    }


    fun addTask(view: View) {
//        val i = Intent()
//        i.setClass(this, ItemActivity::class.java)
//        startActivity(i)
    }


    fun addItems(tasksList: ArrayList<Task>) {
        var task1 = Task("zadanie1", "2019-05-06", 1, 1)
        var task2 = Task("zadanie2", "2019-04-16", 4, 3)
        var task3 = Task("zadanie3", "2019-06-29", 2, 2)

        tasksList.add(task1)
        tasksList.add(task2)
        tasksList.add(task3)
    }

}
