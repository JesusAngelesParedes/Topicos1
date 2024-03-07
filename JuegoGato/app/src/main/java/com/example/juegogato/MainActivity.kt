package com.example.juegogato

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var playerX = true // Variable para alternar entre los jugadores X y O
    private var board = Array(3) { IntArray(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBoard()
    }

    private fun initializeBoard() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                board[i][j] = 0
            }
        }
    }

    fun cellClicked(view: View) {
        val button = view as Button
        val row = button.tag.toString().toInt() / 3
        val col = button.tag.toString().toInt() % 3

        if (board[row][col] == 0) {
            if (playerX) {
                button.text = "X"
                board[row][col] = 1
            } else {
                button.text = "O"
                board[row][col] = 2
            }
            playerX = !playerX
            checkWinner()
        }
    }

    private fun checkWinner() {
        // Verificar filas y columnas
        for (i in 0 until 3) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                showWinner(board[i][0])
                return
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                showWinner(board[0][i])
                return
            }
        }

        // Verificar diagonales
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            showWinner(board[0][0])
            return
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            showWinner(board[0][2])
            return
        }

        // Verificar empate
        if (isBoardFull()) {
            showDraw()
        }
    }

    private fun isBoardFull(): Boolean {
        for (row in board) {
            for (cell in row) {
                if (cell == 0) {
                    return false
                }
            }
        }
        return true
    }

    private fun showWinner(winner: Int) {
        val winnerText = if (winner == 1) "X" else "O"
        Toast.makeText(this, "¡El jugador $winnerText gana!", Toast.LENGTH_SHORT).show()
        initializeBoard()
    }

    private fun showDraw() {
        Toast.makeText(this, "¡Empate!", Toast.LENGTH_SHORT).show()
        initializeBoard()
    }

    fun resetGame(view: View) {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val buttonId = resources.getIdentifier("button${i * 3 + j + 1}", "id", packageName)
                val button = findViewById<Button>(buttonId)
                button.text = " "
                board[i][j] = 0
            }
        }
        playerX = true
    }
}



