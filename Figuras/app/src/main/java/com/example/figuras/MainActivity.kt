package com.example.figuras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageViewTriangulo: ImageView = findViewById(R.id.figuras)

        // Configura la visualización de la imagen del triángulo
        imageViewTriangulo.setImageResource(R.drawable.figuras)
        // Obtener referencia al RadioGroup
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        // Establecer el Listener para el RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.triangulo -> {
                    val intent = Intent(this, triangulo::class.java)
                    startActivity(intent)
                }
                R.id.cuadrado -> {
                    val intent1 = Intent(this,cuadrado::class.java)
                    startActivity(intent1)
                }
                R.id.trapecio -> {
                    val intent2 = Intent(this,trapecio::class.java)
                    startActivity(intent2)
                }
                R.id.circulo -> {
                    val intent3 = Intent(this,circulo::class.java)
                    startActivity(intent3)
                }
            }
        }
    }
}
