package com.example.figuras
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast 
import com.example.figuras.R

class triangulo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triangulo)

        // Obtén una referencia al ImageView
        val imageViewTriangulo: ImageView = findViewById(R.id.imageViewTriangulo)


        // Configura la visualización de la imagen del triángulo
        imageViewTriangulo.setImageResource(R.drawable.triangulo) // Reemplaza "triangulo_image" con el nombre de tu imagen de triángulo en res/drawable

        // Configura el botón de regreso
        val regresar: Button = findViewById(R.id.boton2)
        regresar.setOnClickListener {
            finish()
        }

        // Configura el botón de calcular área
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularAreaTriangulo()
        }
    }

    private fun calcularAreaTriangulo() {
        // Obtiene las dimensiones del triángulo desde los EditTexts
        val etBase: EditText = findViewById(R.id.etBase)
        val etAltura: EditText = findViewById(R.id.etAltura)

        // Convierte las dimensiones a números
        val base = etBase.text.toString().toDoubleOrNull()
        val altura = etAltura.text.toString().toDoubleOrNull()

        // Verifica si las dimensiones son válidas y calcula el área
        if (base != null && altura != null) {
            val area = (base * altura) / 2
            val mensaje = "El área del triángulo es: $area"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, ingresa valores válidos para la base y la altura.", Toast.LENGTH_SHORT).show()
        }
    }
}
