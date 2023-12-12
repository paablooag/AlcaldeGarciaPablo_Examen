package com.example.alcaldegarciapablo_examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AnadirPokemon : AppCompatActivity() {
    lateinit var nombre:TextInputEditText
    lateinit var entrenador:TextInputEditText
    lateinit var estatura:TextInputEditText
    lateinit var fecha:TextInputEditText
    lateinit var spinner:AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_pokemon)



        spinner = findViewById<AutoCompleteTextView>(R.id.spinner)

        val tipos = arrayOf("Agua", "Fuego", "Tierra", "Aire", "Bosque", "Gamer", "Fumador", "Reggaetonero", "Trapero", "Homosexual")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipos)

        spinner.setAdapter(adapter)




        fecha = findViewById(R.id.fecha_atrapado)
        nombre = findViewById(R.id.nombre)
        entrenador=findViewById(R.id.entrenador)
        estatura=findViewById(R.id.estatura)

        nombre.addTextChangedListener{
            if(it.isNullOrBlank() || it.length<3 ){
                nombre.error="Escriba un nombre correcto"

            }
        }
        entrenador.addTextChangedListener {
            if(it.isNullOrBlank() || it.length>25){
                entrenador.error="Escribe correcto"
            }
        }
        estatura.addTextChangedListener {
            if (it.isNullOrBlank()) {
                estatura.error = "Escriba una estatura"
            } else {
                val estaturaValue = it.toString().toIntOrNull()

                if (estaturaValue == null || estaturaValue <= 0) {
                    estatura.error = "Ingrese un número entero positivo para la estatura en cm"
                } else {
                    estatura.error = null
                }
            }
        }
        fecha.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener { selection ->
                val selectedDate = Calendar.getInstance()
                selectedDate.timeInMillis = selection

                val currentDate = Calendar.getInstance()

                if (selectedDate.after(currentDate)) {
                    // Muestra un Toast indicando que no se puede seleccionar una fecha futura
                    Toast.makeText(this, "No puedes seleccionar una fecha futura", Toast.LENGTH_SHORT).show()
                } else {
                    fecha.setText(picker.headerText)
                }
            }

            picker.show(supportFragmentManager, picker.toString())
        }
    }

    fun botonEnviar(view: View) {
            val nombreText = nombre.text.toString()
            val estaturaText = estatura.text.toString().toIntOrNull() ?: 0
            val fechaText = fecha.text.toString()
            val tipoText = spinner.text.toString()

            if (nombreText.isNotBlank() && estaturaText > 0 && fechaText.isNotBlank() && tipoText.isNotBlank()) {
                val intent = Intent(this, ListadoPokemon::class.java)
                intent.putExtra("NOMBRE", nombreText)
                intent.putExtra("ESTATURA", estaturaText)
                intent.putExtra("FECHA", fechaText)
                intent.putExtra("TIPO", tipoText)
                Toast.makeText(this, "Añadido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()

        }
    }

    fun atras(view: View) {
        var newintent = Intent(this, MainActivity::class.java)
        startActivity(newintent)
    }
}

