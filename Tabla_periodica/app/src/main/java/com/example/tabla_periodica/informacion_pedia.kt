package com.example.tabla_periodica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call

class informacion_pedia : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_informacion_pedia)
        val nombre_elemento2 = findViewById<TextView>(R.id.textView_nombre_elemento)
        val simbolo_quimico = findViewById<TextView>(R.id.textView_sq)
        val numero_atomico = findViewById<TextView>(R.id.textView_na)
        val peso_atomico = findViewById<TextView>(R.id.textView_pa)
        val estado_agregacion = findViewById<TextView>(R.id.textView_ea)
        val descubridos = findViewById<TextView>(R.id.textView_d)
        val ano_descubierto = findViewById<TextView>(R.id.textView_ad)
        val grupo_periodo = findViewById<TextView>(R.id.textView_gp)
        val propiedades_quimicas = findViewById<TextView>(R.id.textView_pq)
        val configuracion_electronica = findViewById<TextView>(R.id.textView_ce)
        val punto_fusion = findViewById<TextView>(R.id.textView_pfusion)
        val punto_ebullicion = findViewById<TextView>(R.id.textView_pebullicion)
        val densidad = findViewById<TextView>(R.id.textView_densidad)
        val valencia = findViewById<TextView>(R.id.textView_valencia)
        val electronegatividad = findViewById<TextView>(R.id.textView_electronegatividad)
        val radio_atomico = findViewById<TextView>(R.id.textView_radio_atomico)
        val enegia_ionizacion = findViewById<TextView>(R.id.textView_eionizacion)
        val isotopos = findViewById<TextView>(R.id.textView_isotopos)
        val propiedades_fisicas = findViewById<TextView>(R.id.textView_pf)
        val aplicaciones_principales = findViewById<TextView>(R.id.textView_ap)

        // resibo los datos de la actividad anterior
        val nombre_elemento = intent.getStringExtra("nombre") ?: "Desconocido"
        val simbolo = intent.getStringExtra("simbolo") ?: "N/A"
        val numero = intent.getStringExtra("numero") ?: "0"
        println("Nombre: $nombre_elemento")
        println("Símbolo Químico: $simbolo")
        println("Número Atómico: $numero")
        // Ejecuta la solicitud y maneja la respuesta
        apiService.buscarElemento(nombre_elemento).enqueue(object : retrofit2.Callback<List<ElementoQuimico>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<ElementoQuimico>>,
                response: retrofit2.Response<List<ElementoQuimico>>
            ) {
                if (response.isSuccessful) {
                    val elementos = response.body()
                    // Ahora puedes acceder a los campos de cada elemento químico
                    elementos?.forEach { elemento ->
                        nombre_elemento2.text = elemento.nombre
                        simbolo_quimico.text = elemento.simbolo_quimico
                        numero_atomico.text = elemento.numero_atomico.toString()
                        peso_atomico.text = elemento.peso_atomico
                        estado_agregacion.text = elemento.estado_agregacion
                        descubridos.text = elemento.descubridor
                        ano_descubierto.text = elemento.anio_descubrimiento.toString()
                        grupo_periodo.text = elemento.grupo_periodo
                        propiedades_quimicas.text = elemento.propiedades_quimicas
                        configuracion_electronica.text = elemento.configuracion_electronica
                        punto_fusion.text = elemento.punto_fusion
                        punto_ebullicion.text = elemento.punto_ebullicion
                        densidad.text = elemento.densidad
                        valencia.text = elemento.valencia
                        electronegatividad.text = elemento.electronegatividad
                        radio_atomico.text = elemento.radio_atomico
                        enegia_ionizacion.text = elemento.energia_ionizacion
                        isotopos.text = elemento.isotopos
                        propiedades_fisicas.text = elemento.propiedades_fisicas
                        aplicaciones_principales.text = elemento.aplicaciones_principales
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