package com.example.pong1

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.support.v4.view.MotionEventCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.actionToString
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs), SurfaceHolder.Callback {

    private val thread: GameThread

    private var ballX = width.toFloat() / 2
    private var ballY = height.toFloat() / 2
    private var dx = 5f
    private var dy = 5f
    private val ballSize = 30f

    private val rectWidth = 300f
    private val rectHeight = 30f
    private var positionRect1 = width.toFloat() / 2
    private var positionRect2 = width.toFloat() / 2

    private var borderBottom: Float = 0f
    private val borderTop = rectHeight
    private var pointsPlayer1 = 0
    private var pointsPlayer2 = 0

    private var PREFS_NAME = "pong"
    lateinit var sharedPreferences: SharedPreferences


    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {

        resetParameters()   //set start parameters
        borderBottom = height.toFloat() - rectHeight

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        pointsPlayer1 = sharedPreferences.getInt("pointsPlayer1", 0)
        pointsPlayer2 = sharedPreferences.getInt("pointsPlayer2", 0)

        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i1: Int, i2: Int, i3: Int) {}

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        thread.setRunning(false)
        thread.join()
    }

    fun update() {
        ballX += dx
        ballY += dy

        if (ballX <= 0 || ballX + ballSize >= width) {  //ball move
            dx = -dx
        }
        if (ballY <= borderTop || ballY + ballSize >= borderBottom) {
            dy = -dy
        }

        if (ballY + ballSize >= borderBottom && (ballX + ballSize <= positionRect2 - rectWidth / 2 || ballX + ballSize >= positionRect2 + rectWidth / 2)) { //point for player1
            resetParameters()
            pointsPlayer1++
        }
        if (ballY - ballSize <= borderTop && (ballX + ballSize <= positionRect1 - rectWidth / 2 || ballX + ballSize >= positionRect1 + rectWidth / 2)) {    //point for player1
            resetParameters()
            pointsPlayer2++
        }

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("pointsPlayer1", pointsPlayer1)
        editor.putInt("pointsPlayer2", pointsPlayer2)
        editor!!.commit()
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        if (canvas == null) return

        val red = Paint()
        red.setARGB(255, 255, 0, 0)
        canvas.drawOval(RectF(ballX, ballY, ballX + ballSize, ballY + ballSize), red)

        val blue = Paint()
        blue.setARGB(255, 0, 0, 255)
        canvas.drawRect(
            RectF(
                positionRect2 - rectWidth / 2,
                height.toFloat(),
                positionRect2 + rectWidth / 2,
                height.toFloat() - rectHeight
            ), blue
        )

        canvas.drawRect(
            RectF(
                positionRect1 - rectWidth / 2,
                0f,
                positionRect1 + rectWidth / 2,
                borderTop
            ), blue
        )

        canvas.drawRect(
            RectF(
                200f, 400f,
                500f, 500f
            ), blue
        )

        val green = Paint()
        green.textSize = 50f
        green.setARGB(255, 0, 205, 0)
        canvas.drawText("Player 1 : $pointsPlayer1", 200f, 300f, green)
        canvas.drawText("Player 2 : $pointsPlayer2", 200f, 360f, green)
        canvas.drawText("New game", 230f, 470f, green)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        for (i in 0 until event.pointerCount) {
            if (event.actionIndex == i && event.actionMasked == ACTION_DOWN && RectF(       //if click on new game "button"
                    200f, 400f,
                    500f, 500f
                ).contains(event.getX(i), event.getY(i))
            ) {
                resetParameters()
                pointsPlayer1 = 0
                pointsPlayer2 = 0
            }

            if (event.getY(i) < height / 2) {   //check, which part of screen
                positionRect1 = event.getX(i)
            }
            if (event.getY(i) > height / 2) {
                positionRect2 = event.getX(i)
            }
        }
        return true
    }


    private fun resetParameters() {
        ballX = width.toFloat() / 2
        ballY = height.toFloat() / 2
        positionRect1 = width.toFloat() / 2
        positionRect2 = width.toFloat() / 2
    }


}