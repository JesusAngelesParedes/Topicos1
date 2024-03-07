package com.example.cuestionario_jesusangeles

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias a los Spinners
        val spinnerGeneroPelicula = findViewById<Spinner>(R.id.spinnerPeliculaGenero)
        val spinnerGeneroMusica = findViewById<Spinner>(R.id.spinnerMusicaGenero)
        val spinnerNivelIngles = findViewById<Spinner>(R.id.spinnerNivelIngles)

        // Crear un ArrayAdapter con las opciones para los Spinners
        val generosPelicula = arrayOf("Acción", "Comedia", "Drama", "Ciencia ficción")
        val generosMusica = arrayOf("Rock", "Pop", "Electrónica", "Reggae")
        val nivelesIngles = arrayOf("Básico", "Intermedio", "Avanzado")

        val adapterPelicula = ArrayAdapter(this, android.R.layout.simple_spinner_item, generosPelicula)
        val adapterMusica = ArrayAdapter(this, android.R.layout.simple_spinner_item, generosMusica)
        val adapterIngles = ArrayAdapter(this, android.R.layout.simple_spinner_item, nivelesIngles)

        // Establecer el adaptador en los Spinners
        spinnerGeneroPelicula.adapter = adapterPelicula
        spinnerGeneroMusica.adapter = adapterMusica
        spinnerNivelIngles.adapter = adapterIngles

        // Resto del código de la actividad MainActivity
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val checkBoxCasado = findViewById<CheckBox>(R.id.checkBoxCasado)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBarEncuesta)
        val switchBoletin = findViewById<Switch>(R.id.switchNewsletter)
        val seekBarEdad = findViewById<SeekBar>(R.id.seekBarEdad)
        val buttonGuardar = findViewById<Button>(R.id.buttonGuardar)
        val buttonCerrar = findViewById<Button>(R.id.buttonCerrar)

        buttonGuardar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val fechaNacimiento = "${datePicker.year}-${datePicker.month + 1}-${datePicker.dayOfMonth}"
            val estaCasado = checkBoxCasado.isChecked
            val rating = ratingBar.rating
            val suscribirBoletin = switchBoletin.isChecked
            val edad = seekBarEdad.progress

            // Aquí puedes guardar los datos como desees
            println("Nombre: $nombre")
            println("Fecha de nacimiento: $fechaNacimiento")
            println("¿Está casado/a?: $estaCasado")
            println("Rating: $rating")
            println("¿Desea suscribirse al boletín?: $suscribirBoletin")
            println("Edad: $edad")
        }

        buttonCerrar.setOnClickListener {
            finish()
        }
    }
}

