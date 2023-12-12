package com.example.alcaldegarciapablo_examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun AnadirPokemon(view: View) {

        var newintent = Intent(this, AnadirPokemon::class.java)
        startActivity(newintent)
    }

    fun ListadoPokemon(view: View) {
        var newintent = Intent(this, ListadoPokemon()::class.java)
        startActivity(newintent)

    }

}