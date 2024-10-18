package com.example.tabla_periodica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        botonBuscar.setOnClickListener{
            // Enviar el nombre del elemento a la actividad mostrar_informacion
            val intent = Intent(this, informacion_pedia::class.java)
            // Enviar el nombre del elemento a la actividad mostrar_informacion
            intent.putExtra("nombre", nombre.text.toString())
            intent.putExtra("simbolo", simbolo_q.text.toString())
            intent.putExtra("numero", numero_a.text.toString())
            // Iniciar la actividad
            startActivity(intent)
        }
    }
}