# Fórum ODS - Web App de Discussão Sustentável


Um web app mobile-first estilo fórum, dedicado à discussão, colaboração e divulgação de projetos relacionados aos 17 Objetivos de Desenvolvimento Sustentável (ODS) da ONU.

## 🎯 Visão do Projeto

Criar uma comunidade online engajada onde estudantes, ativistas, profissionais e entusiastas possam aprender, debater e agir em prol de um futuro mais sustentável, com cada ODS servindo como uma categoria central de discussão.

## ✨ Funcionalidades Essenciais (MVP)

-   **Autenticação de Usuários:** Cadastro, Login e Logout seguros.
-   **Navegação por Categorias:** A página inicial exibirá os 17 ODS como categorias clicáveis.
-   **Criação de Tópicos:** Usuários autenticados podem criar novos posts (tópicos) dentro de uma categoria de ODS.
-   **Sistema de Respostas:** Usuários podem responder a tópicos existentes para criar uma discussão.
-   **Visualização de Conteúdo:** Leitura de tópicos e suas respectivas respostas.
-   **Design Responsivo:** A interface será totalmente funcional e agradável em dispositivos móveis.

## 🛠️ Stack de Tecnologias Sugerida

-   **Frontend:** **React.js** (com Vite) para uma interface rápida e moderna.
-   **Estilização:** **Tailwind CSS** para um design responsivo e customizável.
-   **Backend:** **Node.js** com **Express.js** para construir uma API RESTful robusta.
-   **Banco de Dados:** **PostgreSQL** para armazenar dados de forma relacional e segura.
-   **Autenticação:** **JWT (JSON Web Tokens)** para proteger as rotas da API.

---

## 🚀 Roteiro de Desenvolvimento (4 Semanas)

Este projeto será desenvolvido em sprints semanais, focando em entregar valor a cada etapa.

### **Semana 1: A Fundação - Backend e Banco de Dados**

**Objetivo:** Construir a base da API, com modelagem de dados e sistema de autenticação funcional.

#### Tarefas:
1.  **Modelagem do Banco de Dados:**
    -   Definir e criar as tabelas principais: `usuarios`, `topicos` e `respostas`.
    -   **Código SQL de Exemplo (`schema.sql`):**
        ```sql
        CREATE TABLE usuarios (
            id SERIAL PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) UNIQUE NOT NULL,
            senha_hash VARCHAR(255) NOT NULL,
            criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE topicos (
            id SERIAL PRIMARY KEY,
            titulo VARCHAR(255) NOT NULL,
            conteudo TEXT NOT NULL,
            ods_numero INTEGER NOT NULL, -- De 1 a 17
            usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
            criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE respostas (
            id SERIAL PRIMARY KEY,
            conteudo TEXT NOT NULL,
            topico_id INTEGER REFERENCES topicos(id) ON DELETE CASCADE,
            usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
            criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
        );
        ```

2.  **Configurar o Projeto Backend (Node.js/Express):**
    -   Inicializar o projeto (`npm init -y`).
    -   Instalar dependências: `express`, `pg`, `bcryptjs`, `jsonwebtoken`, `dotenv`, `cors`.
    -   Estruturar o projeto em pastas (controllers, routes, models).

3.  **Criar Endpoints de Autenticação:**
    -   `POST /api/auth/register`: Para cadastrar um novo usuário (com hash de senha usando `bcrypt`).
    -   `POST /api/auth/login`: Para autenticar um usuário e retornar um token JWT.

---


### **Semana 3: Construindo a Experiência do Fórum (UI)**

**Objetivo:** Focar totalmente no frontend para criar a interface principal de navegação e interação do fórum.

#### Tarefas:
1.  **Página Principal (Home):**
    -   Criar um grid ou lista visualmente atraente com os 17 ODS.
    -   Cada ODS será um link para a página de tópicos correspondente (ex: `/ods/13`).

2.  **Página de Tópicos por ODS:**
    -   Ao clicar em um ODS, esta página buscará (`GET /api/topicos/ods/:numero`) e listará todos os tópicos daquela categoria.
    -   Incluir um botão "Criar Novo Tópico" visível para usuários logados.

3.  **Página de Visualização de Tópico:**
    -   Exibir o conteúdo do tópico principal e, abaixo, a lista de todas as respostas.
    -   Adicionar um formulário no final da página para que usuários logados possam adicionar novas respostas.
    -   **Código de Exemplo (Componente React Simples):**
        ```jsx
        // Em /components/CardTopico.jsx
        import React from 'react';
        import { Link } from 'react-router-dom';

        function CardTopico({ topico }) {
          return (
            <div className="border p-4 rounded-lg shadow-md hover:shadow-xl transition-shadow">
              <h3 className="text-xl font-bold mb-2">
                <Link to={`/topico/${topico.id}`}>{topico.titulo}</Link>
              </h3>
              <p className="text-gray-600">Postado por: Usuário {topico.usuario_id}</p>
            </div>
          );
        }

        export default CardTopico;
        ```
4.  **Estilização com Tailwind CSS:**
    -   Aplicar classes do Tailwind para garantir que todas as páginas sejam responsivas e tenham uma aparência limpa e moderna.

---

### **Semana 4: Refinamento, Testes e Deploy**

**Objetivo:** Finalizar os detalhes, garantir que tudo funcione corretamente e colocar o projeto no ar.

#### Tarefas:
1.  **Funcionalidades Adicionais Simples:**
    -   Criar uma página de "Meu Perfil" básica onde o usuário possa ver seu nome e email.
    -   Adicionar feedback visual para o usuário (ex: mensagens de "carregando..." ou "post criado com sucesso!").

2.  **Testes Manuais do Fluxo Completo:**
    -   Realizar o fluxo completo: Cadastro -> Login -> Navegar até um ODS -> Criar um tópico -> Responder ao tópico de outro usuário -> Logout.
    -   Testar em diferentes tamanhos de tela (usando o modo de desenvolvedor do navegador).

3.  **Correção de Bugs:**
    -   Resolver quaisquer problemas encontrados durante os testes.

4.  **Deploy (Publicação):**
    -   **Backend:** Fazer o deploy da API em um serviço como **Render** ou **Heroku**.
    -   **Frontend:** Fazer o deploy do app React em uma plataforma como **Vercel** ou **Netlify**.
    -   Configurar as variáveis de ambiente nos serviços de deploy (URL do banco de dados, segredo do JWT, URL da API no frontend).

---

## 🚀 Como Executar o Projeto Localmente

1.  **Clone o repositório:**
    ```bash
    git clone [URL-DO-SEU-REPOSITORIO]
    cd [NOME-DO-PROJETO]
    ```

2.  **Configure o Backend:**
    ```bash
    cd server
    npm install
    cp .env.example .env # Edite o .env com suas chaves do banco de dados
    npm run dev
    ```

3.  **Configure o Frontend:**
    ```bash
    cd client
    npm install
    npm run dev
    ```

O frontend estará rodando em `http://localhost:5173` e o backend em `http://localhost:3001` (ou as portas que você configurar).
