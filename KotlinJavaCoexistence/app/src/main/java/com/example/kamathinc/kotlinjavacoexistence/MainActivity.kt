package com.example.kamathinc.kotlinjavacoexistence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var myVehicle = Vehicle("Contessa", "Super Deluxe Engine")

    var myPerson = Person("Kams", 25)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
