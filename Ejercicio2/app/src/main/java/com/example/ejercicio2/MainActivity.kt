package com.example.ejercicio2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var valorEditText: EditText
    private lateinit var calcularButton: Button
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valorEditText = findViewById(R.id.valorEditText)
        calcularButton = findViewById(R.id.calcularButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)

        calcularButton.setOnClickListener {
            calcularIVA()
        }
    }

    private fun calcularIVA() {
        val valorStr = valorEditText.text.toString()

        if (valorStr.isNotEmpty()) {
            val valor = valorStr.toDouble()

            // Asumiendo que aquí se calcula el IVA con una tasa fija del 21%
            val iva = calcularIVA(valor)

            resultadoTextView.text = "El IVA es: $iva"
        } else {
            resultadoTextView.text = "Por favor ingresa un valor válido."
        }
    }

    private fun calcularIVA(valor: Double): Double {
        // Calculamos el IVA multiplicando el valor por la tasa de IVA (0.21 para el 21%)
        return valor * 0.21
    }
}
