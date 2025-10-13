# ODS CENTER - Fórum Mobile


*Repositório do projeto de desenvolvimento de um aplicativo mobile nativo para Android, focado na divulgação e colaboração em projetos sobre os Objetivos de Desenvolvimento Sustentável (ODS) da ONU.*

---

## 📜 Sobre o Projeto

[cite_start]ODS CENTER é um projeto acadêmico que consiste no desenvolvimento de uma plataforma mobile, que funcionará como um fórum ou rede social. [cite: 6] [cite_start]O objetivo é criar um ambiente dinâmico para conectar e incentivar a colaboração entre estudantes, professores, especialistas e entusiastas em torno das ODS. [cite: 7] [cite_start]A plataforma visa facilitar a busca, a visualização e a interação com projetos que buscam um impacto positivo na sociedade e no meio ambiente. [cite: 9]

### 🎯 Objetivo Geral

[cite_start]Desenvolver uma plataforma mobile que centralize e dê visibilidade a projetos e iniciativas relacionados às 17 ODS, fomentando a educação, a inovação e a colaboração entre a comunidade acadêmica e a sociedade em geral. [cite: 11]

## ✨ Funcionalidades Planejadas (MVP)

-   [cite_start]**✅ Autenticação de Usuários:** Sistema seguro de login e cadastro de perfis individuais. [cite: 13]
-   [cite_start]**✅ Feed de Projetos:** Interface intuitiva para postar, visualizar e interagir com os projetos. [cite: 14]
-   [cite_start]**✅ Pesquisa e Filtros:** Funcionalidades para encontrar projetos por ODS, palavra-chave ou autor. [cite: 15]
-   [cite_start]**✅ Interação Social:** Recursos como curtidas, comentários e compartilhamento para fomentar a comunidade. [cite: 17]
-   [cite_start]**✅ Banco de Dados Robusto:** Estrutura de dados para armazenar informações de usuários, projetos, imagens e interações. [cite: 16]

## 🛠️ Arquitetura e Tecnologias Utilizadas

Este projeto foi construído seguindo as práticas modernas de desenvolvimento Android, garantindo um código limpo, seguro e escalável.

### **📱 Frontend (Aplicativo Android)**

-   **Linguagem:** **Kotlin** - A linguagem oficial e moderna para desenvolvimento Android.
-   **Arquitetura:** **MVC (Model-View-Controller)** - Separação clara das responsabilidades:
    -   **Model:** Classes de dados (ex: `User.kt`), e a camada de rede (`RetrofitClient`, `ApiService`) que lida com a comunicação com o backend.
    -   **View:** Layouts em **XML**, responsáveis pela apresentação visual da interface. Utilizamos **ViewBinding** para uma conexão segura e eficiente entre o layout e o código.
    -   **Controller:** `Activities` (ex: `LoginActivity.kt`), que gerenciam a lógica da interface, processam as entradas do usuário e coordenam a comunicação entre a View e o Model.
-   **Comunicação com API:** **Retrofit** e **Gson** - Para realizar chamadas de rede (HTTP) à API de forma declarativa e converter os dados (JSON) em objetos Kotlin.
-   **Programação Assíncrona:** **Kotlin Coroutines** - Para executar operações de rede e de banco de dados em segundo plano, sem travar a interface do usuário.

### **⚙️ Backend (API e Banco de Dados)**

-   **API:** A comunicação com o banco de dados é feita através de uma **API RESTful**. O aplicativo **não se conecta diretamente ao banco de dados** por razões de segurança.
-   [cite_start]**Banco de Dados:** **MySQL** - Utilizado para armazenar todas as informações da aplicação de forma robusta e segura. [cite: 8, 16]

## 📂 Estrutura do Projeto Android

O código-fonte do aplicativo está organizado nos seguintes pacotes para manter a clareza e a manutenibilidade:
