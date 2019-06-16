package com.example.kamien_papier

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var punkty = 0
    private var wybor_komputera = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun graj(i: Int) {
        val r = Random()
        wybor_komputera = r.nextInt(3) + 1

        //użytkownik wygrał
        if ((i == 1 && wybor_komputera == 3) ||
            (i == 2 && wybor_komputera == 1) ||
            (i == 3 && wybor_komputera == 2)
        ) {
            punkty++
            Toast.makeText(this, "Wygrałeś!", Toast.LENGTH_SHORT).show()
        }
        //użytkownik przegrał
        else if ((i == 1 && wybor_komputera == 2) ||
            (i == 2 && wybor_komputera == 3) ||
            (i == 3 && wybor_komputera == 1)
        ) {
            punkty--
            Toast.makeText(this, "Przegrałeś", Toast.LENGTH_SHORT).show()
        }
        //remis
        else if ((i == 1 && wybor_komputera == 1) ||
            (i == 2 && wybor_komputera == 2) ||
            (i == 3 && wybor_komputera == 3)
        ) {
            Toast.makeText(this, "Remis", Toast.LENGTH_SHORT).show()
        }


        if(wybor_komputera==1){
            findViewById<TextView>(R.id.textView4).text = "Komputer wybrał: kamień"
        }else if(wybor_komputera==2){
            findViewById<TextView>(R.id.textView4).text = "Komputer wybrał: papier"
        }else if(wybor_komputera==3){
            findViewById<TextView>(R.id.textView4).text = "Komputer wybrał: nożyce"
        }

        findViewById<TextView>(R.id.textView5).text = "Punkty: $punkty"

    }


    fun kamienClick(view: View) {
        graj(1)
    }

    fun papierClick(view: View) {
        graj(2)
    }

    fun nozyceClick(view: View) {
        graj(3)
    }


}
