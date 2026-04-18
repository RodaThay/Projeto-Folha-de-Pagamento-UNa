# 💰 Sistema de Folha de Pagamento - Java

Este é um sistema de gerenciamento e cálculo de folha de pagamento desenvolvido como projeto acadêmico para o curso de **Ciência da Computação**. O software permite automatizar o registro de colaboradores e o cálculo de proventos com base em diferentes modelos de contratação.

---

## O que o projeto exercita?

O objetivo principal foi consolidar os fundamentos da programação orientada a objetos e lógica estruturada em Java, explorando:

* **Lógica de Negócio:** Cálculos variados conforme o cargo (Comissionado, Produção, Padrão).
* **Estruturas de Dados:** Uso de `ArrayList` para armazenamento dinâmico em memória.
* **Modularização:** Organização do código em métodos para facilitar a manutenção.
* **Interação com Usuário:** Fluxo de navegação via terminal com tratamento de entradas.

---

## 📋 Funcionalidades Principais

O sistema conta com um menu interativo que oferece as seguintes operações:

### 1️⃣ Cadastrar Funcionário
Ao cadastrar, o sistema solicita:
* Nome completo
* Identificação (Matrícula ou CPF)
* Seleção de Cargo (conforme tabela abaixo):

| Categoria | Regra de Cálculo |
| :--- | :--- |
| **Padrão** | Recebe o salário base fixo. |
| **Comissionado** | Salário base + bônus de 10% sobre o total de vendas. |
| **Produção** | Salário base + gratificação de R$ 16,00 por item produzido. |

### 2️⃣ Listar Funcionários
Exibição simplificada de todos os colaboradores registrados no sistema para conferência rápida.

### 3️⃣ Gerar Folha de Pagamento
Geração detalhada de contracheque individual contendo:
* Dados cadastrais (Nome e Matrícula).
* Discriminação de valores (Salário base, bônus/adicionais).
* **Salário Total Bruto.**
* 📊 Ao final, o sistema apresenta o **Custo Total da Folha** para a empresa.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Entrada de Dados:** `java.util.Scanner`
* **Armazenamento:** `java.util.ArrayList`

---

## 👥 Autores (Grupo)
* **[Thayssa]** 
* **[Julia]** 
* **[Mayara]** 
* **[Frederico]** 
* **[Leonardo]**

---
