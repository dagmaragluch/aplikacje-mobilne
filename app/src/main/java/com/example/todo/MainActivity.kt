package com.example.todo

import android.arch.persistence.room.Room
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    val itemsArray = ArrayList<Task>()
    lateinit var myadapter: MyArrayAdapter

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
            val t = Task("zadanie1", "2019-05-06", 1, 1)
            database.taskDao().insertAll(t)

            itemsArray.addAll(database.taskDao().getAll())
        }

        myadapter = MyArrayAdapter(this, itemsArray)
        listView1.adapter = myadapter


        listView1.onItemLongClickListener = OnItemLongClickListener { _, _, index, _ ->
            Toast.makeText(this, "$index", Toast.LENGTH_SHORT).show()
            database.taskDao().deleteTask(itemsArray[index])
            refrash()
            true
        }


    }


    fun addItem(view: View) {
        var t = Task("zadanie2", "2019-04-16", 4, 3)
        database.taskDao().insertTask(t)
        refrash()
    }


    fun refrash() {
        itemsArray.removeAll(itemsArray)
        itemsArray.addAll(database.taskDao().getAll())
        myadapter.notifyDataSetChanged()
    }

//    fun createTask() {
//
//        val builder = AlertDialog.Builder(this)
//        val inflater = layoutInflater
//        builder.setTitle("EditText")
//        val dialogLayout = inflater.inflate(R.layout.item_layout, null)
//        val textView = dialogLayout.findViewById<TextView>(R.id.textTitle)
//        builder.setView(dialogLayout)
//        builder.setPositiveButton("OK") { dialogInterface, i ->
//
//            var string = textView.text.toString()
////            mainFragment.temporaryClass.pictures[nr].description = string
//        }
//        builder.show()
//
//    }

}
