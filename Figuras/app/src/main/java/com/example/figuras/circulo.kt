package com.example.figuras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class circulo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circulo)
        val imageViewTriangulo: ImageView = findViewById(R.id.circulo)

        // Configura la visualización de la imagen del triángulo
        imageViewTriangulo.setImageResource(R.drawable.circulo)
        val regresar: Button = findViewById(R.id.boton2)
        regresar.setOnClickListener {
            finish()
        }

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularAreaCirculo()
        }
    }

    private fun calcularAreaCirculo() {
        val etRadio: EditText = findViewById(R.id.etRadio)

        val radio = etRadio.text.toString().toDoubleOrNull()

        if (radio != null && radio > 0) {
            val area = Math.PI * radio * radio
            val mensaje = "El área del círculo es: $area"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, ingresa un valor válido y positivo para el radio del círculo.", Toast.LENGTH_SHORT).show()
        }
    }
}
