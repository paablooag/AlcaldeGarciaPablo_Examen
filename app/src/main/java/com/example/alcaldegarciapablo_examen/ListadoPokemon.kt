package com.example.alcaldegarciapablo_examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
class ListadoPokemon : AppCompatActivity() {
    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_pokemon)

        texto = findViewById(R.id.listado)

        var fecha = intent.getStringExtra("FECHA")
        var tipo = intent.getStringExtra("TIPO")
        var nombre = intent.getStringExtra("NOMBRE")
        var estatura = intent.getIntExtra("ESTATURA", 0).toString()

        val informacion = "Nombre: $nombre\nTipo: $tipo\nFecha: $fecha\nEstatura: $estatura"
        texto.text = informacion
    }

    fun atras(view: View) {
        var newintent = Intent(this, MainActivity::class.java)
        startActivity(newintent)
    }
}
