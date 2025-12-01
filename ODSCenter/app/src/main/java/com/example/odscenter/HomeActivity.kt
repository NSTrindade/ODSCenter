package com.example.odscenter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Recupera o nome que foi enviado pela tela de Login
        val nomeUsuario = intent.getStringExtra("NOME_USUARIO")

        // Atualiza o texto da tela
        val txtBoasVindas = findViewById<TextView>(R.id.txtBoasVindas)
        if (nomeUsuario != null) {
            txtBoasVindas.text = "Olá, $nomeUsuario!\nBem-vindo ao ODS Center"
        }

        // Botão de Sair (apenas fecha essa tela e volta pro login)
        val btnSair = findViewById<Button>(R.id.btnSair)
        btnSair.setOnClickListener {
            finish() // Encerra a HomeActivity
        }
    }
}