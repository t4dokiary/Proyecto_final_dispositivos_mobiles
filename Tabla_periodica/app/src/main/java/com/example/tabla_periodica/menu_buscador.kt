package com.example.tabla_periodica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class menu_buscador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_buscador)
        // asignamos el valor del edittext a la variable
        val nombre = findViewById<EditText>(R.id.editTextText)
        val simbolo_q = findViewById<EditText>(R.id.editTextText2)
        val numero_a = findViewById<EditText>(R.id.editTextNumber)
        // al darle click al boton se envia el valor del nombre a la variable
        // Encuentra el botón en el layout
        val botonBuscar = findViewById<Button>(R.id.button_buscar_elemento)
        botonBuscar.setOnClickListener {
            val intent = Intent(this, informacion_pedia::class.java)

            // Obtener los valores de los campos de entrada
            val nombreText = nombre.text.toString().trim()
            val simboloText = simbolo_q.text.toString().trim()
            val numeroText = numero_a.text.toString().trim()

            // Convertir el número atómico a entero si es válido
            val numeroAtomico = numeroText.toIntOrNull() ?: 0

            // Validar si los campos son inválidos
            if ((nombreText.isEmpty() || nombreText.equals("null", true)) &&
                (simboloText.isEmpty() || simboloText.equals("null", true)) &&
                (numeroText.isEmpty() || numeroText.equals("null", true) || numeroAtomico == 0)
            ) {
                // Mostrar un mensaje emergente si todos los campos son inválidos
                Toast.makeText(this, "Debe llenar por lo menos un campo", Toast.LENGTH_LONG).show()
            } else {
                // Enviar los datos válidos a la siguiente actividad
                intent.putExtra("nombre", nombreText)
                intent.putExtra("simbolo", simboloText)
                intent.putExtra("numero", numeroText)

                // Iniciar la actividad
                startActivity(intent)
            }
        }
    }
}