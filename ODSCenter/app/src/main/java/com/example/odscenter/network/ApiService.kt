package com.example.odscenter.network

import com.example.odscenter.model.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Interface que define os endpoints da nossa API.
interface ApiService {

    // @POST("auth/login") indica que esta função fará uma requisição HTTP POST
    // para o endereço "auth/login" da nossa API.
    @POST("auth/login")
    // A anotação @Body indica que o mapa de dados será enviado no corpo da requisição.
    // suspend é uma palavra-chave do Kotlin Coroutines, indicando que esta função
    // pode ser pausada e retomada, ideal para operações de rede que demoram.
    suspend fun login(@Body request: Map<String, String>): Response<LoginResponse>

    // Endpoint para registrar um novo usuário
    @POST("auth/register")
    suspend fun register(@Body request: Map<String, String>): Response<Void> // Void porque o registro não precisa retornar dados, apenas sucesso.
}