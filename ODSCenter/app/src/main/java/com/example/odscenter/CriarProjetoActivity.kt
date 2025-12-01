package com.example.odscenter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CriarProjetoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_projeto)

        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editDescricao = findViewById<EditText>(R.id.editDescricao)
        val editOds = findViewById<EditText>(R.id.editOds)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarProjeto)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnSalvar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val descricao = editDescricao.text.toString()
            val odsTexto = editOds.text.toString()

            if (titulo.isNotEmpty() && descricao.isNotEmpty() && odsTexto.isNotEmpty()) {
                // Salva no banco de memória
                // Obs: Estamos colocando um autor fixo "Eu" por enquanto,
                // mas poderíamos passar o nome do usuário logado via Intent
                BancoDeDados.adicionarProjeto(
                    titulo,
                    descricao,
                    "Usuário Logado",
                    odsTexto.toInt()
                )

                Toast.makeText(this, "Projeto publicado!", Toast.LENGTH_SHORT).show()
                finish() // Fecha essa tela e volta para a anterior (Home)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }
}