package com.example.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ActivityViewModel : ViewModel() {
    val TAG= this.javaClass.simpleName

    private var myRandomNumber: MutableLiveData<String>? = null

    fun getUsers(): MutableLiveData<String> {
        if (myRandomNumber == null){
            myRandomNumber = MutableLiveData()
            createUsers()
        }
        return myRandomNumber!!
    }

    fun createUsers() {
        // Do an asynchronous operation to fetch users.
        val random= Random()
        myRandomNumber!!.value="Number: " + random.nextInt(1000)

    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "ViewModel Destroyed")
    }
}