package com.example.odscenter.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Usamos um 'object' para criar um Singleton, garantindo que teremos apenas
// uma instância do Retrofit em todo o app, o que economiza recursos.
object RetrofitClient {

    // O endereço base da nossa futura API.
    // IMPORTANTE: Para testes locais no emulador do Android, use 10.0.2.2 em vez de localhost.
    private const val BASE_URL = "http://10.0.2.2:3000/api/"

    // lazy garante que o objeto Retrofit só será criado na primeira vez que for usado.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Usa o Gson para converter JSON
            .build()
    }

    // Acessador público para o nosso ApiService
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}