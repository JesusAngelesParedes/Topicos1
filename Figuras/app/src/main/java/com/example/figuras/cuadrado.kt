package com.example.figuras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class cuadrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuadrado)
        val imageViewTriangulo: ImageView = findViewById(R.id.cuadrado)

        // Configura la visualización de la imagen del triángulo
        imageViewTriangulo.setImageResource(R.drawable.cuadrado)
        val regresar: Button = findViewById(R.id.boton2)
        regresar.setOnClickListener {
            finish()
        }

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularAreaCuadrado()
        }
    }

    private fun calcularAreaCuadrado() {
        val etLado: EditText = findViewById(R.id.etLado)

        val lado = etLado.text.toString().toDoubleOrNull()

        if (lado != null) {
            val area = lado * lado
            val mensaje = "El área del cuadrado es: $area"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, ingresa un valor válido para el lado del cuadrado.", Toast.LENGTH_SHORT).show()
        }
    }
}
