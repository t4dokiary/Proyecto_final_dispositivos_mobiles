package com.example.tabla_periodica

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://192.168.1.85/")  // Cambia esto por la URL base de tu API
    .addConverterFactory(GsonConverterFactory.create())  // Esto convierte el JSON a objetos Kotlin/Java
    .build()

// Crea la instancia de ApiService
val apiService: ApiService = retrofit.create(ApiService::class.java)

// Define una data class para el elemento químico
data class ElementoQuimico(
    val id: Int,
    val nombre: String,
    val simbolo_quimico: String,
    val numero_atomico: Int,
    val peso_atomico: String,
    val configuracion_electronica: String,
    val estado_agregacion: String,
    val punto_fusion: String,
    val punto_ebullicion: String,
    val densidad: String,
    val valencia: String,
    val energia_ionizacion: String,
    val electronegatividad: String,
    val radio_atomico: String,
    val isotopos: String,
    val anio_descubrimiento: Int,
    val descubridor: String,
    val grupo_periodo: String,
    val propiedades_quimicas: String,
    val propiedades_fisicas: String,
    val aplicaciones_principales: String
)

// Esta parte es la interfaz que define los métodos para hacer las solicitudes a la API
interface ApiService {
    // Este metodo hace una solicitud GET a la URL "aplicaciones_mobiles/php/busqueda.php"
    @GET("aplicaciones_mobiles/php/busqueda.php")
    // La función buscarElemento recibe un parámetro "nombre" y retorna una lista de ElementoQuimico
    fun buscarElemento(@Query("nombre") nombre: String): Call<List<ElementoQuimico>>
}

