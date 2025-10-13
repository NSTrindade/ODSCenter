package com.example.odscenter.model.model

// A resposta da API geralmente contém um token para autenticação e os dados do usuário.
data class LoginResponse(
    val token: String,
    val user: User
)