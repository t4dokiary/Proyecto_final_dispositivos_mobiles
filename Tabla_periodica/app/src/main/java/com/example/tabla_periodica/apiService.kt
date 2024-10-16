package com.example.tabla_periodica

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("http://172.31.0.103/")  // Cambia esto por la URL base de tu API
    .addConverterFactory(GsonConverterFactory.create())  // Esto convierte el JSON a objetos Kotlin/Java
    .build()

// Crea la instancia de ApiService
val apiService = retrofit.create(ApiService::class.java)

interface ApiService {

    // Método que obtiene datos de un endpoint
    @GET("aplicaciones_mobiles/php/busqueda.php?nombre=Hidrógeno")
    fun getEjemplo():
            Call<ResponseBody>

    // Método con un parámetro dinámico en la URL
    @GET("ruta/{id}")
    fun getItemPorId(@Path("id") id: Int): Call<ResponseBody>

    // Método con parámetros de consulta
    @GET("ruta/filtrar")
    fun getItemsFiltrados(@Query("filtro") filtro: String): Call<ResponseBody>
}
