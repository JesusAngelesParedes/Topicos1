package com.example.holamundoventanas
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.holamundoventanas.R

class Saludo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        val name = intent.getStringExtra("name")

        val textViewSaludo = findViewById<TextView>(R.id.textViewSaludo)
        textViewSaludo.text = "Hello, $name!"
    }
}
