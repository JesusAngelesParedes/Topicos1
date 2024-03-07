package com.example.holamundoventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val editTextName = findViewById<EditText>(R.id.editTextName)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                val intent = Intent(this, Saludo::class.java).apply {
                    putExtra("name", name)
                }
                startActivity(intent)
            }
        }
    }
}
