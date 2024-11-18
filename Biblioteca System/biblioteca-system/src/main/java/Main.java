import autor.Autor;
import biblioteca.Biblioteca;
import cliente.Cliente;
import emprestimo.Emprestimo;
import livro.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        //Adicionamos os dois autores como exemplo
        Autor jKRowling = new Autor(1, "J.K.Rowling", java.time.LocalDate.of(1965, 7, 31));
        Autor tolkien = new Autor(2, "J.R.R.Tolkien", java.time.LocalDate.of(1892, 1, 3));
        Autor martin = new Autor(3, "G.R.R.Martin", java.time.LocalDate.of(1948, 9, 20));
        biblioteca.adicionarAutor(jKRowling);
        biblioteca.adicionarAutor(tolkien);
        biblioteca.adicionarAutor(martin);

        // Adionando os livros de exemplo
        Livro harryPotter = new Livro(1, "Harry Potter e o Prisioneiro de Azkaban", jKRowling, java.time.LocalDate.now());
        Livro senhorAneis = new Livro(2, "Senhor dos Aneis", tolkien,  java.time.LocalDate.now());
        Livro gameOfThrones = new Livro(3, "Game of Thrones", martin,  java.time.LocalDate.now());
        biblioteca.adicionarLivro(harryPotter);
        biblioteca.adicionarLivro(senhorAneis);
        biblioteca.adicionarLivro(gameOfThrones);

        //Adicionando clientes
        Cliente marcos = new Cliente(1, "Marcos", LocalDate.of(1997, 4, 24), "marcos@cliente.com.br");
        Cliente alice = new Cliente(2, "Alice", LocalDate.of(1990, 4, 15), "alice@cliente.com");
        Cliente bob = new Cliente(3, "Roberto", LocalDate.of(1995, 10, 10), "roberto@cliente.com.br");
        biblioteca.adicionarCliente(marcos);
        biblioteca.adicionarCliente(alice);
        biblioteca.adicionarCliente(bob);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Bem vindo ao sistema de biblioteca!");
            System.out.println("Por favor escolha uma das opções abaixo: ");
            System.out.println("1. Ver livros disponiveis");
            System.out.println("2. Emprestar um livro");
            System.out.println("3. Ver clientes cadastrados");
            System.out.println("4. Adicionar um novo Livro");
            System.out.println("5. Buscar livro por titulo");
            System.out.println("6. Buscar livro por autor");
            System.out.println("7. Ver emprestimos de cliente");
            System.out.println("8. Ver emprestimos de livro");
            System.out.println("9. Listar livros recentes");
            System.out.println("10. Sair");
            int opcao = Integer.parseInt(scanner.nextLine().trim());

            switch (opcao){
                case 1:
                    List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
                    if (livrosDisponiveis.isEmpty()){
                        System.out.println("Não há livros disponíveis no momento.");
                    } else {
                        System.out.println("Livros disponiveis: ");
                        for (Livro livro : livrosDisponiveis) {
                            System.out.printf("ID: %d | Titulo: %s | Autor: %s%n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Digite o ID do livro que deseja emprestar: ");
                    int livroId = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Digite o ID do cliente: ");
                    int clienteId = Integer.parseInt(scanner.nextLine().trim());
                    break;

                case 3:
                    List<Cliente> clientes = biblioteca.listarCliente();
                    if (clientes.isEmpty()){
                        System.out.println("Não há clientes cadastrados");

                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.printf("ID: %d | Nome: %s | Email: %s%n", cliente.getId(), cliente.getNome(), cliente.getEmail());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = scanner.nextLine().trim();
                    System.out.println("Digite o Id do autor: ");
                    int autorId = Integer.parseInt(scanner.nextLine().trim());
                    Autor autor = biblioteca.listarAutores().stream().filter(a -> a.getId() == autorId).findFirst().orElse(null);
                    if (autor == null){
                        System.out.println("Autor não encontrado.");
                    } else {
                        Livro novoLivro = new Livro(biblioteca.listarLivrosDisponiveis().size() + 1, titulo, autor, java.time.LocalDate.now());
                        biblioteca.adicionarLivro(novoLivro);
                        System.out.println("Livro adicionado com sucesso.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o título do livro:");
                    String buscaTitulo = scanner.nextLine().trim();
                    List<Livro> livrosEncontradosTitulo = biblioteca.buscarLivrosPorTitulo(buscaTitulo);
                    if (livrosEncontradosTitulo.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com esse título.");
                    } else {
                        for (Livro livro : livrosEncontradosTitulo) {
                            System.out.printf("ID: %d | Título: %s | Autor: %s%n",
                                    livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do autor:");
                    String buscaAutor = scanner.nextLine().trim();
                    List<Livro> livrosEncontradosAutor = biblioteca.buscarLivrosPorAutor(buscaAutor);
                    if (livrosEncontradosAutor.isEmpty()) {
                        System.out.println("Nenhum livro encontrado para esse autor.");
                    } else {
                        for (Livro livro : livrosEncontradosAutor) {
                            System.out.printf("ID: %d | Título: %s | Autor: %s%n",
                                    livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Digite o ID do cliente:");
                    int buscaClienteId = Integer.parseInt(scanner.nextLine().trim());
                    List<Emprestimo> emprestimosCliente = biblioteca.consultarEmprestimosPorCliente(buscaClienteId);
                    if (emprestimosCliente.isEmpty()) {
                        System.out.println("Nenhum empréstimo encontrado para esse cliente.");
                    } else {
                        for (Emprestimo emprestimo : emprestimosCliente) {
                            System.out.printf("Livro: %s | Data de Empréstimo: %s | Data de Devolução: %s%n",
                                    emprestimo.getLivro().getTitulo(),
                                    emprestimo.getDataEmprestimo(),
                                    emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao() : "Ainda não devolvido");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Digite o ID do livro:");
                    int buscaLivroId = Integer.parseInt(scanner.nextLine().trim());
                    List<Emprestimo> emprestimosLivro = biblioteca.consultarEmprestimosPorLivro(buscaLivroId);
                    if (emprestimosLivro.isEmpty()) {
                        System.out.println("Nenhum histórico encontrado para esse livro.");
                    } else {
                        for (Emprestimo emprestimo : emprestimosLivro) {
                            System.out.printf("Cliente: %s | Data de Empréstimo: %s | Data de Devolução: %s%n",
                                    emprestimo.getCliente().getNome(),
                                    emprestimo.getDataEmprestimo(),
                                    emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao() : "Ainda não devolvido");
                        }
                    }
                    break;
                case 9:
                    List<Livro> livrosRecentes = biblioteca.listarLivrosRecentes();
                    if (livrosRecentes.isEmpty()) {
                        System.out.println("Nenhum livro recente encontrado.");
                    } else {
                        for (Livro livro : livrosRecentes) {
                            System.out.printf("ID: %d | Título: %s | Autor: %s | Data de Cadastro: %s%n",
                                    livro.getId(), livro.getTitulo(), livro.getAutor().getNome(), livro.getDataCadastro());
                        }
                    }
                    break;
                case 10:
                    System.out.println("Obrigado por utilizar o sistema Bibliotecas.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");

            }

        }
    }
}
