package com.example.juegomemorama


import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttons: List<Button>
    private lateinit var content: List<String>
    private var currentPlayer = 1
    private var pairsFoundPlayer1 = 0
    private var pairsFoundPlayer2 = 0
    private var firstSelectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6)
        )

        // Contenido para las cartas
        content = listOf("A", "B", "C", "A", "B", "C") // Pares de contenido para las cartas

        // Asignar el color de fondo inicial a los botones
        buttons.forEach { button ->
            button.setBackgroundColor(Color.LTGRAY)
            button.setOnClickListener {
                handleCardSelection(button)
            }
        }
    }

    private fun handleCardSelection(button: Button) {
        // Si la carta ya está revelada o ya se encontró un par con este contenido, no hacer nada
        if (button.text != "" || button.currentTextColor == Color.WHITE) {
            return
        }

        // Mostrar contenido de la carta
        val index = buttons.indexOf(button)
        button.text = content[index]
        button.setBackgroundColor(Color.WHITE) // Cambiar el color de fondo para indicar que está revelada

        if (firstSelectedButton == null) {
            // Esta es la primera carta seleccionada
            firstSelectedButton = button
        } else {
            // Esta es la segunda carta seleccionada
            val firstContent = firstSelectedButton!!.text.toString()
            val secondContent = button.text.toString()

            if (firstContent == secondContent) {
                // Se encontró un par
                if (currentPlayer == 1) {
                    pairsFoundPlayer1++
                } else {
                    pairsFoundPlayer2++
                }
                if (pairsFoundPlayer1 + pairsFoundPlayer2 == 3) {
                    val winner = if (pairsFoundPlayer1 > pairsFoundPlayer2) "Jugador 1" else "Jugador 2"
                    Toast.makeText(this, "¡Felicidades, $winner, has ganado!", Toast.LENGTH_SHORT).show()
                }
            } else {
                // No coincide, ocultar las cartas nuevamente después de un breve retraso
                Handler().postDelayed({
                    firstSelectedButton!!.text = ""
                    button.text = ""
                    firstSelectedButton!!.setBackgroundColor(Color.LTGRAY)
                    button.setBackgroundColor(Color.LTGRAY)

                    // Cambiar de jugador
                    currentPlayer = if (currentPlayer == 1) 2 else 1
                }, 1000)
            }

            // Limpiar la selección
            firstSelectedButton = null
        }
    }
}
























