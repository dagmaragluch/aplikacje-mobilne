package com.example.wisielec

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

     lateinit var wordList: Array<String>


    val lettersToButtons = mapOf(
        'A' to R.id.buttonA,
        'B' to R.id.buttonB,
        'C' to R.id.buttonC,
        'D' to R.id.buttonD,
        'E' to R.id.buttonE,
        'F' to R.id.buttonF,
        'G' to R.id.buttonG,
        'H' to R.id.buttonH,
        'I' to R.id.buttonI,
        'J' to R.id.buttonJ,
        'K' to R.id.buttonK,
        'L' to R.id.buttonL,
        'M' to R.id.buttonM,
        'N' to R.id.buttonN,
        'O' to R.id.buttonO,
        'P' to R.id.buttonP,
        'R' to R.id.buttonR,
        'Q' to R.id.buttonQ,
        'S' to R.id.buttonS,
        'T' to R.id.buttonT,
        'U' to R.id.buttonU,
        'W' to R.id.buttonW,
        'X' to R.id.buttonX,
        'Y' to R.id.buttonY,
        'Z' to R.id.buttonZ
    )

    lateinit var word: String
    var WordLenght = 0
    lateinit var wordWithQuestionMark: String
    var fails = 0

    lateinit var lettersInWord: HashSet<Char>
    var correctInputLetters = mutableSetOf<Char>()

    val failsMax = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordList = resources.getStringArray(R.array.words)
        newGame()
    }




    fun bClick(v: View) {

        val bSelected = v as Button
        val bLetter = when (bSelected.id) {
            R.id.buttonA -> 'A'
            R.id.buttonB -> 'B'
            R.id.buttonC -> 'C'
            R.id.buttonD -> 'D'
            R.id.buttonE -> 'E'
            R.id.buttonF -> 'F'
            R.id.buttonG -> 'G'
            R.id.buttonH -> 'H'
            R.id.buttonI -> 'I'
            R.id.buttonJ -> 'J'
            R.id.buttonK -> 'K'
            R.id.buttonL -> 'L'
            R.id.buttonM -> 'M'
            R.id.buttonN -> 'N'
            R.id.buttonO -> 'O'
            R.id.buttonP -> 'P'
            R.id.buttonR -> 'R'
            R.id.buttonQ -> 'Q'
            R.id.buttonS -> 'S'
            R.id.buttonT -> 'T'
            R.id.buttonU -> 'U'
            R.id.buttonW -> 'W'
            R.id.buttonX -> 'X'
            R.id.buttonY -> 'Y'
            R.id.buttonZ -> 'Z'
            else -> '?'
        }

        play(bLetter, bSelected)

    }


    fun newGame() {

        lettersToButtons.forEach { (_, v) -> findViewById<Button>(v).isEnabled = true }

        val imageHangman = findViewById<ImageView>(R.id.imageView).imageView
        var imgResId = R.drawable.wisielec0
        imageHangman.setImageResource(imgResId)



        val rand = (0 until wordList.size).random()       //losowanie
        word = wordList.get(rand)


        WordLenght = word.length
        wordWithQuestionMark = ""
        fails = 0
        correctInputLetters.removeAll(correctInputLetters)

        lettersInWord = word.toUpperCase().toCharArray().toHashSet()


        for (x in 0 until WordLenght) {
            wordWithQuestionMark += "? "
        }
        findViewById<TextView>(R.id.textView).text = wordWithQuestionMark
    }


    fun play(bLetter: Char, bSelected: Button) {

        bSelected.isEnabled = false
        checkLetter(bLetter)
        exploreWord()
        showHangman()

        checkEndGame()
    }


    fun checkLetter(bLetter: Char) {

        if (lettersInWord.contains(bLetter)) {
            correctInputLetters.add(bLetter)
        } else {
            fails++
        }
    }


    fun exploreWord() {

        wordWithQuestionMark = ""

        for (character in word.toUpperCase()) {   //drukowanie stopniowe
            if (correctInputLetters.contains(character)) {
                wordWithQuestionMark += "$character "

            } else {
                wordWithQuestionMark += "? "
            }
        }
        findViewById<TextView>(R.id.textView).text = wordWithQuestionMark
    }

    fun checkEndGame() {
        if (fails == failsMax) {
            Toast.makeText(this, "YOU LOST; correct word: $word", Toast.LENGTH_LONG).show()
            newGame()
        }
        if (!wordWithQuestionMark.contains('?')) {
            Toast.makeText(this, "YOU WON", Toast.LENGTH_LONG).show()
            newGame()
        }
    }


    fun showHangman() {
        val imageHangman = findViewById<ImageView>(R.id.imageView).imageView
        var imgResId = 0

        when (fails) {
            0 -> imgResId = R.drawable.wisielec0
            1 -> imgResId = R.drawable.wisielec1
            2 -> imgResId = R.drawable.wisielec2
            3 -> imgResId = R.drawable.wisielec3
            4 -> imgResId = R.drawable.wisielec4
            5 -> imgResId = R.drawable.wisielec5
            6 -> imgResId = R.drawable.wisielec6
            7 -> imgResId = R.drawable.wisielec7
            8 -> imgResId = R.drawable.wisielec8
            9 -> imgResId = R.drawable.wisielec9
            10 -> imgResId = R.drawable.wisielec10
        }

        imageHangman.setImageResource(imgResId)
    }

}

