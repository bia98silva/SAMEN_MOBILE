# Monitoramento de Usinas - Sistema de Controle e Cadastro

## 📍 Visão Geral

Este é um projeto desenvolvido para o **monitoramento de usinas**, com o objetivo de acompanhar em tempo real variáveis críticas como **temperatura**, **pressão** e **nível de radiação**. O sistema foi projetado para fornecer uma interface fácil de usar para o monitoramento desses parâmetros e, ao mesmo tempo, permitir o gerenciamento de informações de cadastro dos usuários.

O projeto inclui funcionalidades de **cadastro de usuários**, **autenticação**, **alteração de dados cadastrais**, e a **validação de credenciais (email e senha)**. Além disso, utiliza **Firebase** para o armazenamento e autenticação de dados, garantindo a segurança e integridade das informações dos usuários.

## ⚙️ Funcionalidades

- **Monitoramento em tempo real**: Exibição de dados importantes de sensores de temperatura, pressão e radiação de usinas.
- **Cadastro de usuários**: Possibilidade de criação de novos usuários com **validação de email e senha**.
- **Alteração de dados cadastrais**: Permite que os usuários alterem suas informações de cadastro, como nome, email, cargo e telefone.
- **Autenticação via Firebase**: Utiliza o Firebase Authentication para garantir a segurança no login e garantir que apenas usuários registrados possam acessar o sistema.
- **Validação de dados**: O sistema valida se o email e a senha informados estão corretos durante o processo de login e atualização de cadastro.

 ## **🔑 Funcionalidades de Cadastro e Login**
Cadastro de Usuário
O sistema permite que novos usuários se cadastrem, informando os seguintes dados:

-Nome
-Cargo
-Email
-Telefone
-Senha (que será criptografada)
-Login e Validação de Credenciais
-A autenticação é feita com Firebase Authentication, e a senha e o email do usuário são validados para garantir que estão corretos. Caso o usuário informe dados errados, uma mensagem de erro será exibida, garantindo uma experiência de uso amigável.

## **Alteração de Dados de Cadastro**
Após o login, o usuário tem a possibilidade de alterar os seguintes dados:

-Nome
-Cargo
-Telefone
-senha
Essas alterações são feitas de forma segura no banco de dados do Firebase, permitindo que o usuário mantenha suas informações sempre atualizadas.

📜 Exemplo de Arquitetura
Activity Principal: Tela de login onde o usuário pode se autenticar.
Activity de Cadastro: Tela para inserir dados do usuário e criar um novo cadastro.
Activity de Alteração de Cadastro: Permite editar as informações de cadastro do usuário.
Firebase: Utilizado para armazenamento e autenticação.

## 🚀 Tecnologias Utilizadas

- **Android Studio**: Ambiente de desenvolvimento para a aplicação Android.
- **Firebase**:
- **Firebase Authentication**: Para gerenciar a autenticação dos usuários.
- **Firebase Firestore**: Para armazenar os dados de cadastro dos usuários.
- **Kotlin**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **ConstraintLayout**: Layout utilizado para criar interfaces responsivas.

Link do video: https://youtu.be/fBuWEtuVZ18

Link do Figma: https://www.figma.com/design/3HaTKU1Igz2mImtEcHLMFt/Untitled?node-id=0-1&t=MD64P40u8zpe74om-1

## Integrantes
**Turma 2TSDSPS:**
- **Vitor Onofre Ramos** | RM553241
- **Pedro Henrique** | RM553801
- **Beatriz Silva** | RM552600
