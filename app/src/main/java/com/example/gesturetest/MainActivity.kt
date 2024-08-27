package com.example.gesturetest

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null
    lateinit var getGestureText: TextView
    lateinit var currentImage: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)

        getGestureText = this.findViewById(R.id.getGestureText)
        currentImage = this.findViewById(R.id.imageView)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event!!)
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
        getGestureText.text = "Oh?"
//        getGestureText.setTextColor(ContextCompat.getColor(this, R.color.blue))
        return true
    }

    override fun onShowPress(e: MotionEvent) {
        getGestureText.text = "Trapinch has evolved into Vibrava!"
        currentImage.setImageResource(R.drawable.vibrava)
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        getGestureText.setTextColor(ContextCompat.getColor(this, R.color.white))
        getGestureText.text = "Color is restored"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
//        getGestureText.text = "onScroll"
//        Was meant to hide text to focus on pokemon images but couldn't separate from fling
//        getGestureText.setTextColor(Color.argb(128,0,0,0))
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        getGestureText.text = "Vibrava has evolved into Flygon!"
        currentImage.setImageResource(R.drawable.flygon)
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        getGestureText.text = "The Previous Pokemon Has Left, A new Trapinch Appears!"
        currentImage.setImageResource(R.drawable.trapinch)
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
//        getGestureText.text = "onSingleTap"
        Toast.makeText(this, "A bug, a Dragonfly and a Dragon", Toast.LENGTH_LONG).show()
        return true
    }

    override fun onDoubleTap(e: MotionEvent): Boolean {
//        Couldn't find reliable use
//        getGestureText.text = "onDoubleTapFirst"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
//        getGestureText.text = "onDoubleTap"
        getGestureText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28f)
        return true
    }
}