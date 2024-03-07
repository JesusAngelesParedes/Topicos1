package com.example.primer_hola_mundo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var nombre:EditText=findViewById(R.id.nombre)
    var ok: Button=findViewById(R.id.Okey)
    var saludo:TextView=findViewById(R.id.saludo)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nombre: EditText=findViewById(R.id.Ok)
        var ok: Button =findViewById(R.id.Okey)
        var saludo: TextView =findViewById(R.id.Saludo)

        ok.setOnClickListener {  }
    }
    fun construyeSaludo(view:View) {
    }
}

