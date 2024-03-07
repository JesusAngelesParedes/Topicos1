package com.example.figuras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class trapecio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapecio)
        val imageViewTriangulo: ImageView = findViewById(R.id.trapecio)

        // Configura la visualización de la imagen del triángulo
        imageViewTriangulo.setImageResource(R.drawable.trapecio)
        val regresar: Button = findViewById(R.id.boton2)
        regresar.setOnClickListener {
            finish()
        }

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularAreaTrapecio()
        }
    }

    private fun calcularAreaTrapecio() {
        val etBaseMayor: EditText = findViewById(R.id.etBaseMayor)
        val etBaseMenor: EditText = findViewById(R.id.etBaseMenor)
        val etAltura: EditText = findViewById(R.id.etAltura)

        val baseMayor = etBaseMayor.text.toString().toDoubleOrNull()
        val baseMenor = etBaseMenor.text.toString().toDoubleOrNull()
        val altura = etAltura.text.toString().toDoubleOrNull()

        if (baseMayor != null && baseMenor != null && altura != null && baseMayor > 0 && baseMenor > 0 && altura > 0) {
            val area = (baseMayor + baseMenor) * altura / 2
            val mensaje = "El área del trapecio es: $area"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, ingresa valores válidos y positivos para las bases y la altura del trapecio.", Toast.LENGTH_SHORT).show()
        }
    }
}
