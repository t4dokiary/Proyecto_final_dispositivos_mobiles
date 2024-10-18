package com.example.tabla_periodica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call

class mostrar_informacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_informacion)

        // Obtener los TextViews desde el layout
        val textElemento = findViewById<TextView>(R.id.nombre_elemento)
        val textSimbolo = findViewById<TextView>(R.id.simbolo_quimico)
        val textNumero = findViewById<TextView>(R.id.numero_atomico)
        val textPeso = findViewById<TextView>(R.id.peso_atomico)
        // ... otros TextViews ...

        // Ejecuta la solicitud y maneja la respuesta
        apiService.buscarElemento("Litio").enqueue(object : retrofit2.Callback<List<ElementoQuimico>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<ElementoQuimico>>,
                response: retrofit2.Response<List<ElementoQuimico>>
            ) {
                if (response.isSuccessful) {
                    val elementos = response.body()
                    // Ahora puedes acceder a los campos de cada elemento químico
                    elementos?.forEach { elemento ->
                        println("Nombre: ${elemento.nombre}")
                        textElemento.text = elemento.nombre
                        println("Símbolo Químico: ${elemento.simbolo_quimico}")
                        textSimbolo.text = elemento.simbolo_quimico
                        println("Número Atómico: ${elemento.numero_atomico}")
                        textNumero.text = elemento.numero_atomico.toString()
                        println("Peso Atómico: ${elemento.peso_atomico}")
                        textPeso.text = elemento.peso_atomico
                    }
                }
            }

            override fun onFailure(call: Call<List<ElementoQuimico>>, t: Throwable) {
                // Maneja el error aquí
                println("Error al obtener datos: ${t.message}")
            }
        })
    }
}