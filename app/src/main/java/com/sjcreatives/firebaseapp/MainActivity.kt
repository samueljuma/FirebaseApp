package com.sjcreatives.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

        val displayText: TextView = findViewById(R.id.txtView)

        //Firebase RealTime database reference
        database = Firebase.database.reference

        //write to database
        database.child("bio").setValue("Hi, Samuel Juma here. Good to see you")

        //Read data from db
        val postListener = object : ValueEventListener{
            override fun onDataChange(snapshot: com.google.firebase.database.DataSnapshot) {
                val myData = snapshot.value
                displayText.text = myData.toString()

            }
            override fun onCancelled(error: com.google.firebase.database.DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.child("bio").addValueEventListener(postListener)


    }
}