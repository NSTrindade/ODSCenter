package com.example.odscenter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    // Declaramos aqui para poder acessar em qualquer lugar da classe
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProjetoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. Boas-vindas
        val nomeUsuario = intent.getStringExtra("NOME_USUARIO") ?: "Usuário"
        val txtBoasVindas = findViewById<TextView>(R.id.txtBoasVindas)
        txtBoasVindas.text = "Olá, $nomeUsuario!"

        // 2. Configuração inicial da Lista
        recyclerView = findViewById(R.id.recyclerViewProjetos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // O Adapter será carregado no onResume

        // 3. Botão Novo Projeto
        val btnNovoProjeto = findViewById<Button>(R.id.btnNovoProjeto)
        btnNovoProjeto.setOnClickListener {
            val intent = Intent(this, CriarProjetoActivity::class.java)
            startActivity(intent)
        }

        // 4. Botão Sair
        val btnSair = findViewById<Button>(R.id.btnSair)
        btnSair.setOnClickListener {
            finish()
        }
    }

    // Essa função é chamada toda vez que a tela aparece (inclusive quando volta de outra tela)
    override fun onResume() {
        super.onResume()
        // Recarrega a lista do banco para pegar os projetos novos
        adapter = ProjetoAdapter(BancoDeDados.listaDeProjetos)
        recyclerView.adapter = adapter
    }
}