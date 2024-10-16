package com.example.tabla_periodica

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_configuracion = findViewById<Button>(R.id.button_configuracion)
        val button_ayuda = findViewById<Button>(R.id.button_ayuda)
        val button_imagen = findViewById<Button>(R.id.button_imagen)
        val button_buscar = findViewById<Button>(R.id.button_buscar)
        val test = findViewById<Button>(R.id.test)
        button_configuracion.setOnClickListener {
            val intent = Intent(this, Configuracion::class.java)
            startActivity(intent)
        }
        button_buscar.setOnClickListener {
            val intent = Intent(this, menu_buscador::class.java)
            startActivity(intent)
        }
        button_imagen.setOnClickListener {
            val intent = Intent(this, Imagen_periodica::class.java)
            startActivity(intent)
        }
        button_ayuda.setOnClickListener {
            val intent = Intent(this, ayuda::class.java)
            startActivity(intent)
        }
        test.setOnClickListener {
            val intent = Intent(this, mostrar_informacion::class.java)
            startActivity(intent)
        }
    }
}