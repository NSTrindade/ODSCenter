package com.example.odscenter

import com.example.odscenter.model.model.User // Mantenha o import do User se necessário

object BancoDeDados {
    // --- PARTE DOS USUÁRIOS (JÁ EXISTIA) ---
    private val listaDeUsuarios = mutableListOf<User>()
    private var idContadorUsuario = 1

    fun cadastrarUsuario(nome: String, email: String, senha: String): Boolean {
        if (listaDeUsuarios.any { it.email == email }) return false
        listaDeUsuarios.add(User(idContadorUsuario++, nome, email, senha))
        return true
    }

    fun fazerLogin(email: String, senha: String): User? {
        return listaDeUsuarios.find { it.email == email && it.senha == senha }
    }

    fun criarUsuarioTeste() {
        if (listaDeUsuarios.isEmpty()) {
            cadastrarUsuario("Pedro Veloso", "admin@email.com", "123456")
        }
    }

    // --- NOVIDADE: PARTE DOS PROJETOS ---
    val listaDeProjetos = mutableListOf<Projeto>() // 'val' pública para acessarmos na Home
    private var idContadorProjeto = 1

    // Função para adicionar um projeto novo
    fun adicionarProjeto(titulo: String, descricao: String, autor: String, ods: Int) {
        val novoProjeto = Projeto(idContadorProjeto++, titulo, descricao, autor, ods)
        listaDeProjetos.add(novoProjeto)
    }

    // Cria projetos falsos para o Feed não ficar vazio no início
    fun criarProjetosTeste() {
        if (listaDeProjetos.isEmpty()) {
            adicionarProjeto(
                "Horta Comunitária Escolar",
                "Projeto para ensinar alunos sobre agricultura sustentável e alimentação saudável.",
                "Maria Professora",
                2 // ODS 2: Fome Zero
            )
            adicionarProjeto(
                "Robô de Sumô com IR",
                "Um robô que detecta limites da arena usando sensores infravermelhos.",
                "Pedro Veloso",
                9 // ODS 9: Indústria, Inovação e Infraestrutura
            )
            adicionarProjeto(
                "Reciclagem de Bairro",
                "Coleta seletiva organizada pelos moradores do bairro Jardim Flores.",
                "Associação de Moradores",
                11 // ODS 11: Cidades Sustentáveis
            )
        }
    }
}