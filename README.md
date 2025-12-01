# 🐾 Sistema de Cadastro de Animais - Clínica Veterinária

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![MVC](https://img.shields.io/badge/Architecture-MVC-green?style=for-the-badge)

> Um sistema modular de gerenciamento para clínicas veterinárias desenvolvido em Java Swing, aplicando rigorosamente a arquitetura MVC.

---

## 📖 Sobre o Projeto

Este projeto foi desenvolvido como parte de um trabalho acadêmico com o objetivo de implementar um sistema de gerenciamento de animais, focando na organização do código e na separação de responsabilidades.

A aplicação oferece um fluxo completo de autenticação e cadastro, permitindo o registro de informações essenciais dos pacientes (animais) e seus tutores. O diferencial do projeto é sua estrutura **MVC (Model-View-Controller)**, que garante que as regras de negócio, a interface visual e o controle de fluxo operem de forma independente e coordenada.

---

## ⚙️ Funcionalidades

### 🔐 1. Autenticação (Login)
A primeira tela apresentada é a de segurança. O acesso ao sistema é restrito e validado pelo Controller.
- **Login:** `user`
- **Senha:** `2025`

### 📝 2. Cadastro de Pacientes
Após a autenticação, o usuário acessa o formulário principal onde pode registrar:
- **Nome do Animal**
- **Raça**
- **Nome do Tutor**

*Nota: Os dados são armazenados temporariamente em memória durante a execução.*

---

## 🏗️ Arquitetura MVC

O projeto organiza o fluxo da aplicação como uma "pequena orquestra": cada camada toca seu instrumento, sem invadir o território da outra.

| Camada | Responsabilidade |
| :--- | :--- |
| **Model** | Representa os dados da aplicação (classe `Animal`) e a lógica de negócios. |
| **View** | Interfaces visuais construídas com **Java Swing** (Telas de Login e Cadastro). É onde o usuário interage. |
| **Controller** | A ponte entre View e Model. Processa eventos, valida credenciais e coordena a navegação. |

### 📂 Estrutura de Pastas

```text
src/
├── controller/
│   ├── LoginController.java
│   └── AnimalController.java
├── model/
│   └── Animal.java
└── view/
    ├── LoginView.java
    └── AnimalView.java
