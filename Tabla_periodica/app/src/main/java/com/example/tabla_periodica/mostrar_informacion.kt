package com.example.tabla_periodica

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        // llamamos a la función que realiza la petición a la API y procesa la respuesta

        val call = apiService.getEjemplo()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Procesar la respuesta exitosa
                    val data = response.body()?.string()
                    Log.d("MainActivity", "Respuesta: $data")
                    // Actualizar los TextViews con la información obtenida
                    textElemento.text = data

                } else {
                    Log.e("MainActivity", "Error en la respuesta: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("MainActivity", "Error en la llamada: ${t.message}")
            }
        })
    }
}