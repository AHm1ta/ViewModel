package com.example.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    var counter=0
    val TAG= this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button)

        val model: ActivityViewModel= ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        val myRandomNumber:LiveData<String> = model.getUsers()
        model.getUsers().observe(this, Observer<String>{ s -> textView.text = s})

        button.setOnClickListener {
            counter++
            model.createUsers()
            Log.i(TAG, counter.toString())


        }


    }

}