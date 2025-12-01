package com.example.odscenter

data class Projeto(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val autor: String, // Nome do usuário que criou
    val ods: Int // Número da ODS (ex: 4 para Educação de Qualidade)
)