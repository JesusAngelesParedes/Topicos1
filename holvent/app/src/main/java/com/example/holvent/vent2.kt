package com.example.holvent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class vent2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vent2)

        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)

        val name = intent.getStringExtra("name")
        textViewGreeting.text = "¡Bienvenido, $name!"
    }
}
