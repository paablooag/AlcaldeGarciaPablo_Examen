package com.example.alcaldegarciapablo_examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ListadoPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_pokemon)
    }

    fun atras(view: View) {
        var newintent = Intent(this, MainActivity::class.java)
        startActivity(newintent)
    }
}