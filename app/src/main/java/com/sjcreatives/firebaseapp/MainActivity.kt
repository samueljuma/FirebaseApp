package com.sjcreatives.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {

    //To read or write data from the database, you need an instance of DatabaseReference
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Firebase RealTime database reference
        database = Firebase.database.reference

        //write to database
        database.child("Hey You").child("1").setValue("Hey")

    }
}