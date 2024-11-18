# Gerenciadora de Emprestimos de Livros (Desafio Rocket Seat)

## Visão geral

* Este projeto é uma aplicação em Java para gerenciamento de uma biblioteca. Ele permite adicionar e listar livros, autores e clientes, além de realizar empréstimos de livros. O programa oferece um menu interativo para facilitar a navegação e operações.

## Funcionalidades

- **Cadastro de Livros:** Permite o cadastro de novos livros com informações detalhadas como título, autor e data de registro.
- **Cadastro de Autores:** Permite o cadastro de autores, incluindo nome e data de nascimento.
- **Cadastro de Clientes:** Permite o cadastro de clientes, com informações como nome, data de nascimento e email.
- **Empréstimos de Livros:** Permite a associação de empréstimos a clientes, incluindo a data de empréstimo e de devolução.
- **Consulta de Empréstimos:** Permite a consulta do histórico de empréstimos por livro e por cliente.
- **Busca de Livros:** Permite a busca de livros por título ou autor.
- **Listagem de Livros:** Permite filtrar e listar livros disponíveis, livros de determinados gêneros ou livros adicionados recentemente.

## Como Usar

1. **Clonar o repositório:**
   git clone https://github.com/MSFelisberto/rseat-desafio-biblioteca.git
   cd rseat-desafio-biblioteca

2. **Compilar o projeto:**
   javac -d bin src/**/*.java

3. **Executar a aplicação:**
   java -cp bin biblioteca.Main


4. **Seguir o menu interativo:**
O menu oferece várias opções como ver livros disponíveis, emprestar um livro, ver clientes cadastrados, adicionar um novo livro, buscar livros por título ou autor, e consultar o histórico de empréstimos.


## Estrutura do Projeto
- **Classes:**
    - `Main`: A classe principal que executa o menu interativo e organiza a interação com o usuário.
    - `Biblioteca`: Gerencia a lógica de negócios, incluindo a lista de livros, autores, clientes e empréstimos.
    - `Livro`: Representa um livro com atributos como título, autor e disponibilidade.
    - `Autor`: Representa um autor com atributos como nome e data de nascimento.
    - `Cliente`: Representa um cliente com atributos como nome, data de nascimento e email.
    - `Emprestimo`: Representa um empréstimo de livro com atributos como livro, cliente, data de empréstimo e data de devolução.

## Conceitos Utilizados
- **Encapsulamento:** Preservado ao restringir o acesso direto às listas de livros, autores e clientes na classe `Biblioteca`. Métodos públicos são fornecidos para acessar e modificar esses dados de forma controlada.
- **Composição:** Utilizada para associar livros a autores e empréstimos a clientes dentro da aplicação.
- **Iteração com Coleções:** Métodos `stream()` e `filter()` da API de Streams do Java são utilizados para buscar, filtrar e listar itens em coleções.
- **Data e Hora:** A classe `LocalDate` da biblioteca `java.time` é utilizada para gerenciar datas de cadastro, empréstimo e devolução.
- **Interação com o Usuário:** O uso da classe `Scanner` permite capturar a entrada do usuário no console, facilitando a interação com a aplicação.

## Lições Aprendidas
- **Gerenciamento de Dados em Memória:** A prática de manipular listas em memória ajudou a entender melhor como gerenciar e operar dados sem um banco de dados persistente.
- **Modularidade e Separação de Responsabilidades:** Criar classes distintas para diferentes entidades (`Livro`, `Autor`, `Cliente`, `Emprestimo`) reforçou a importância da separação de responsabilidades para facilitar a manutenção e expansão futura do código.
- **Uso de Streams e Lambdas do Java:** A implementação de buscas e filtros utilizando Streams e Lambdas proporcionou uma abordagem funcional e mais concisa para operações complexas em coleções.
- **Encapsulamento e Segurança de Dados:** Restrição de acesso direto a dados sensíveis via modificadores de acesso (private) e exposição controlada através de métodos públicos ajudou a aplicar os princípios de encapsulamento de forma prática.

## Desenvolvimento Futuro
Algumas ideias para desenvolvimento futuro incluem:
- Implementação de uma interface gráfica para melhorar a interação do usuário.
- Persistência de dados em um banco de dados relacional ou NoSQL.
- Implementação de autenticação e autorização para clientes da biblioteca.
- Geração de relatórios e estatísticas sobre empréstimos e popularidade dos livros.
