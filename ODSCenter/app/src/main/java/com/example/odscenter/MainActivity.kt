package com.example.odscenter

import android.content.Intent // Importante: Adicionado para navegar entre telas
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Garante que está carregando o layout de login
        setContentView(R.layout.activity_login)

        // 1. Inicializa um usuário de teste no nosso banco de memória
        BancoDeDados.criarUsuarioTeste()
        BancoDeDados.criarProjetosTeste()

        // 2. Encontra os componentes da tela
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        // 3. Configura a ação do botão ENTRAR
        btnLogin.setOnClickListener {
            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            // Chama a função de login do nosso banco em memória
            val usuarioLogado = BancoDeDados.fazerLogin(email, senha)

            if (usuarioLogado != null) {
                // Se o usuário foi encontrado:
                Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show()

                // --- INÍCIO DA MUDANÇA (ETAPA 4) ---
                // Prepara a navegação para a próxima tela (HomeActivity)
                val intent = Intent(this, HomeActivity::class.java)

                // Envia o nome do usuário para a próxima tela
                intent.putExtra("NOME_USUARIO", usuarioLogado.nome)

                // Inicia a nova tela
                startActivity(intent)

                // Opcional: fecha a tela de login para o botão "Voltar" não retornar nela
                // finish()
                // --- FIM DA MUDANÇA ---

            } else {
                // Se errou a senha ou email:
                Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        }

        // 4. Configura a ação do botão CADASTRAR
        btnCadastrar.setOnClickListener {
            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                // Tenta cadastrar no banco de memória
                val sucesso = BancoDeDados.cadastrarUsuario("Novo Usuário", email, senha)

                if (sucesso) {
                    Toast.makeText(this, "Usuário cadastrado! Tente logar agora.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Este e-mail já está em uso.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha e-mail e senha para cadastrar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}