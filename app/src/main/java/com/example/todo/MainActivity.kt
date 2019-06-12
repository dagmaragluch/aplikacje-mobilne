package com.example.todo

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.AdapterView.OnItemLongClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.view.*
import java.lang.Exception


class MainActivity : AppCompatActivity(), MyArrayAdapter.MyListener {

    private lateinit var database: AppDatabase
    private val itemsArray = ArrayList<Task>()
    lateinit var myadapter: MyArrayAdapter
    private val requestCode = 0


    override fun onDelete(index: Int) {
        database.taskDao().deleteTask(itemsArray[index])
        refresh()
    }

    override fun onInteraction(index: Int) {
        val i = Intent()
        i.setClass(this, ItemActivity::class.java)
        i.putExtra("option", "edit$index")
        startActivityForResult(i, requestCode)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AsyncTask.execute {
            try {
                database = Room.databaseBuilder(
                    this,
                    AppDatabase::class.java,
                    "student.db"
                ).allowMainThreadQueries().build()
            } catch (e: Exception) {
                Log.i("am2019", e.message)
            }
            itemsArray.addAll(database.taskDao().getAll())
        }

        myadapter = MyArrayAdapter(this, itemsArray, this)
        listView1.adapter = myadapter

    }

    fun addItem(view: View) {
        val i = Intent()
        i.setClass(this, ItemActivity::class.java)
        i.putExtra("option", "add")
        startActivityForResult(i, requestCode)
    }

    private fun refresh() {
        itemsArray.removeAll(itemsArray)
        itemsArray.addAll(database.taskDao().getAll())
        myadapter.notifyDataSetChanged()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == this.requestCode) {

            val returnString = data?.getStringExtra(Intent.EXTRA_TEXT)
//            Log.d("add", "STRING = $returnString")
            val arguments: List<String>

            if (returnString != null) {
                arguments = returnString.split(";;")

                val t = Task(arguments[1], arguments[2], arguments[3].toInt(), arguments[4].toInt())

                if (arguments[0] == "add") {
                    database.taskDao().insertTask(t)
                } else if (arguments[0].contains("edit")) {

                    var index = arguments[0].substring(4).toInt()
//                    Log.d("edit", "index = $index")

                    database.taskDao().deleteTask(itemsArray[index])
                    database.taskDao().insertTask(t)
                }
                refresh()
            }
        }
    }


}
