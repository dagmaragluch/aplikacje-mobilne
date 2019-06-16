package com.example.tictactoe2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var playerX = ArrayList<Int>()
    var playerO = ArrayList<Int>()
    var turn = 0


    val buttons = mapOf(
        1 to R.id.button,
        2 to R.id.button2,
        3 to R.id.button3,
        4 to R.id.button4,
        5 to R.id.button5,
        6 to R.id.button6,
        7 to R.id.button7,
        8 to R.id.button8,
        9 to R.id.button9,
        10 to R.id.button10,
        11 to R.id.button11,
        12 to R.id.button12,
        13 to R.id.button13,
        14 to R.id.button14,
        15 to R.id.button15,
        16 to R.id.button16,
        17 to R.id.button17,
        18 to R.id.button18,
        19 to R.id.button19,
        20 to R.id.button20,
        21 to R.id.button21,
        22 to R.id.button22,
        23 to R.id.button23,
        24 to R.id.button24,
        25 to R.id.button25
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun bClick(v: View) {

        val bSelected = v as Button
        var bID = 0

        when (bSelected.id) {

            R.id.button -> bID = 1
            R.id.button2 -> bID = 2
            R.id.button3 -> bID = 3
            R.id.button4 -> bID = 4
            R.id.button5 -> bID = 5
            R.id.button6 -> bID = 6
            R.id.button7 -> bID = 7
            R.id.button8 -> bID = 8
            R.id.button9 -> bID = 9
            R.id.button10 -> bID = 10
            R.id.button11 -> bID = 11
            R.id.button12 -> bID = 12
            R.id.button13 -> bID = 13
            R.id.button14 -> bID = 14
            R.id.button15 -> bID = 15
            R.id.button16 -> bID = 16
            R.id.button17 -> bID = 17
            R.id.button18 -> bID = 18
            R.id.button19 -> bID = 19
            R.id.button20 -> bID = 20
            R.id.button21 -> bID = 21
            R.id.button22 -> bID = 22
            R.id.button23 -> bID = 23
            R.id.button24 -> bID = 24
            R.id.button25 -> bID = 25
        }

        play(bID, bSelected)

    }


    fun play(bID: Int, bSelected: Button) {

        if (turn % 2 == 0) {  //turn playerX
            bSelected.text = "X"
            playerX.add(bID)
            turn++
        }
        else {      //turn playerO
            bSelected.text = "O"
            playerO.add(bID)
            turn++
        }

        bSelected.isEnabled = false
        checkWinner()
    }


    fun newGame() {
        buttons.forEach { (_, v) -> findViewById<Button>(v).isEnabled = true }
        buttons.forEach { (_, v) -> findViewById<Button>(v).text = " "}

        playerX.removeAll(playerX)
        playerO.removeAll(playerO)
        turn = 0
    }


    fun checkWinner(){

        if(turn>=25){
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
            newGame()
        }
        else {
            if(
            (playerX.contains(1) && playerX.contains(2) && playerX.contains(3) && playerX.contains(4) && playerX.contains(5)) ||
            (playerX.contains(6) && playerX.contains(7) && playerX.contains(8) && playerX.contains(9) && playerX.contains(10)) ||
            (playerX.contains(11) && playerX.contains(12) && playerX.contains(13) && playerX.contains(14) && playerX.contains(15)) ||
            (playerX.contains(16) && playerX.contains(17) && playerX.contains(18) && playerX.contains(19) && playerX.contains(20)) ||
            (playerX.contains(21) && playerX.contains(22) && playerX.contains(23) && playerX.contains(24) && playerX.contains(25)) ||
            (playerX.contains(1) && playerX.contains(6) && playerX.contains(11) && playerX.contains(16) && playerX.contains(21)) ||
            (playerX.contains(2) && playerX.contains(7) && playerX.contains(12) && playerX.contains(17) && playerX.contains(22)) ||
            (playerX.contains(3) && playerX.contains(8) && playerX.contains(13) && playerX.contains(18) && playerX.contains(23)) ||
            (playerX.contains(4) && playerX.contains(9) && playerX.contains(14) && playerX.contains(19) && playerX.contains(24)) ||
            (playerX.contains(5) && playerX.contains(10) && playerX.contains(15) && playerX.contains(20) && playerX.contains(25)) ||
            (playerX.contains(1) && playerX.contains(7) && playerX.contains(13) && playerX.contains(19) && playerX.contains(25)) ||
            (playerX.contains(5) && playerX.contains(9) && playerX.contains(13) && playerX.contains(17) && playerX.contains(21))
            ) {
                Toast.makeText(this, "Winner is player X", Toast.LENGTH_LONG).show()
                newGame()
            }
            if(
                (playerO.contains(1) && playerO.contains(2) && playerO.contains(3) && playerO.contains(4) && playerO.contains(5)) ||
                (playerO.contains(6) && playerO.contains(7) && playerO.contains(8) && playerO.contains(9) && playerO.contains(10)) ||
                (playerO.contains(11) && playerO.contains(12) && playerO.contains(13) && playerO.contains(14) && playerO.contains(15)) ||
                (playerO.contains(16) && playerO.contains(17) && playerO.contains(18) && playerO.contains(19) && playerO.contains(20)) ||
                (playerO.contains(21) && playerO.contains(22) && playerO.contains(23) && playerO.contains(24) && playerO.contains(25)) ||
                (playerO.contains(1) && playerO.contains(6) && playerO.contains(11) && playerO.contains(16) && playerO.contains(21)) ||
                (playerO.contains(2) && playerO.contains(7) && playerO.contains(12) && playerO.contains(17) && playerO.contains(22)) ||
                (playerO.contains(3) && playerO.contains(8) && playerO.contains(13) && playerO.contains(18) && playerO.contains(23)) ||
                (playerO.contains(4) && playerO.contains(9) && playerO.contains(14) && playerO.contains(19) && playerO.contains(24)) ||
                (playerO.contains(5) && playerO.contains(10) && playerO.contains(15) && playerO.contains(20) && playerO.contains(25)) ||
                (playerO.contains(1) && playerO.contains(7) && playerO.contains(13) && playerO.contains(19) && playerO.contains(25)) ||
                (playerO.contains(5) && playerO.contains(9) && playerO.contains(13) && playerO.contains(17) && playerO.contains(21))
            ) {
                Toast.makeText(this, "Winner is player O", Toast.LENGTH_LONG).show()
                newGame()
            }
        }

    }
}
