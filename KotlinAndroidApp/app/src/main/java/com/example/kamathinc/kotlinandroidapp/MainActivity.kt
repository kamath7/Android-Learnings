package com.example.kamathinc.kotlinandroidapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myNumber: Int = 0

    fun resetButtonOnClick(view: View){
        myNumber = 0
//        textView.setText(myNumber.toString())
        textView.text = myNumber.toString() //alternate to the above
    }

    fun plusButtonOnClick(view: View){
        myNumber += 69
        textView.setText(myNumber.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)

    }
}
