# Desafio Técnico - Java | Spring Backend Developer
<div align="center"><img alt="lastcommit" src="https://img.shields.io/github/last-commit/matheushbmelo/rest-spring-api-challenge?color=blue&label=Ultimo commit"/></div><br>

**Objetivo:** Desenvolver uma API RESTFUL para gerenciar uma lista de tarefas e seus usuários.

## Funcionalidades:

### Tarefa
1.  Criar tarefa
2.  Recuperar uma tarefa
3.  Recuperar todas as tarefas
4.  Atualizar uma tarefa
5.  Excluir uma tarefa

### Usuário
1.  Criar usuário.
2.  Recuperar um usuário
3.  Recuperar todos os usuários
4.  Atualizar um usuário
5.  Excluir um usuário

## Regras de Negócio:

-   Cada usuário contém ID único, nome, email e uma lista de tarefas criadas.
-   Cada tarefa contém um ID único, título, status (pendente ou concluída), usuário agregado e o momento em que foi criada.
-   Tanto usuários quanto tarefas devem ser armazenados em memória (não é necessário um banco de dados).
-   Quando uma tarefa for marcada como concluída, seu status não poderá ser alterado para pendente.
-   O sistema deve fornecer feedback apropriado em caso de erros, como tarefa não encontrada ou ação inválida.

## Diferenciais (opcionais):

-   Adicionar autenticação básica para proteger a API (por exemplo, autenticação de token simples).
-   Documentar a API usando o Swagger ou outra ferramenta de documentação.
-   Escrever testes unitários para as principais funcionalidades.

## O que será avaliado no código:

-   Estrutura e organização do projeto.
-   Uso adequado do Spring Boot para criar a API REST.
-   Manipulação correta de erros e validação de entrada.
-   Implementação das histórias de usuário.
-   Uso de boas práticas de programação em Java.
-   Qualidade do código e legibilidade.
-   Uso de convenções de nomenclatura.
-   Lidar com exceções de forma apropriada.
-   Se você optar por implementar os diferenciais, eles serão considerados como um bônus.

## Instruções gerais:

-   Você pode usar qualquer framework ou biblioteca Java que desejar, desde que a aplicação seja baseada em Spring Boot.
-   Forneça instruções claras sobre como executar e testar a API.
-   O código deve ser enviado em um repositório Git público (por exemplo, GitHub) para revisão.

## Padrão organizacional:

Para o desafio de desenvolver uma API REST em Java com Spring Boot, é altamente recomendável seguir o padrão de projeto conhecido como Padrão MVC (Model-View-Controller). O Padrão MVC é uma escolha sólida para a construção de aplicativos web e APIs REST, pois ajuda a manter a separação de responsabilidades e a organização do código.

Além disso, considere a organização do projeto em pacotes, como controller, service, repository, model, etc., para manter o código bem estruturado e modular.

## Objetivo final:

Este desafio tem como objetivo avaliar suas habilidades técnicas e sua capacidade de criar uma API REST funcional usando Java e Spring Boot.

***

# Datalhes do projeto

## Pré requisitos:

-   Sistema operacional (Windows, Linux ou  Mac);

-   IDE com suporte a Java e Spring Boot (IntelliJ, Eclipse, NetBeans, VScode);

-   Conta no GitHub;

## Informações sobre o código:

- Desenvolvido utilizando o **IntelliJ IDEA**;
- O código aborda os padrões atuais de arquitetura, organização e recursos de otimização de código;
- O projeto aborda aspectos avançados da linguagem Java e seus frameworks.

## Diagrama UML:

<div align="center"><img src="https://raw.githubusercontent.com/MatheusHBMelo/restafulapi-usertask-challenge/main/img/class-diagram.jpeg" alt="Diagram class"></div>

## Estrutura de commits:

Existe um padrão para a forma de escrita dos commits, com proposito de criar **mensagens mais legíveis** e que não afetem o histórico do projeto.


* Ser sucinto, é melhor sobrar do que faltar.
* Escrever um título e uma mensagem explicando o que foi desenvolvido.
* Idioma padronizado: **Inglês**.

### Tags utilizadas:

* `Initial`: O primeiro commit do projeto, geralmente com a estrutura básica e as dependências iniciais;
* `Feat`: Uma nova funcionalidade desenvolvida;
* `Fix`: Correção de bugs e erros;
* `Style`: Mudanças que não alteram o significado do código (white-space, ponto-e-virgula, correções de texto);
* `Refactor`: Refatoração do código que não corrige ou adiciona nada, apenas legibilidade e otimização;
* `Build`:  Alterações nas dependências, tarefas de manutenção e limpeza de código;
* `test`: Adição ou modificação de testes;
* `Docs`: Alterações na documentação do projeto;

### Escopo do Commit:
Normalmente, a utilização do escopo acontece em commits específicos e pontuais, os quais necessitam especificar o contexto imediato da mudança executada pelo commit, como em um módulo de login, middleware ou profile. Nesses casos são necessários especificar a classe e o objeto/métodos em que a modificação ocorre.

### Formato da mensagem do commit:

````
[Tag]: Título Relevante do Commit
````

## Tecnologias:

-   `Java - 17.0.9 2023-10-17 LTS`
-   `Spring - 3.2.0`
-   `H2 Database`
-   `Git`

## Dependências:

-   `Spring Web`
-   `Spring Boot DevTools`
-   `Spring Data JPA`
-   `H2 Database`