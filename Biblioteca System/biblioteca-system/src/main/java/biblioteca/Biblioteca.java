package biblioteca;

import autor.Autor;
import cliente.Cliente;
import emprestimo.Emprestimo;
import livro.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }

    public void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registrarEmprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    public List<Livro> listarLivrosDisponiveis(){
        return livros.stream().filter(Livro::isDisponivel).collect(Collectors.toList());
    }

    public List<Autor> listarAutores(){
        return new ArrayList<>(autores);
    }

    public List<Cliente> listarCliente() {
        return new ArrayList<>(clientes);
    }

    public boolean emprestarLivro(int livroId, int clienteId) {
        Livro livro = livros.stream().filter(l -> l.getId() == livroId && l.isDisponivel())
                .findFirst().orElse(null);
        Cliente cliente = clientes.stream().filter(c -> c.getId() == clienteId)
                .findFirst().orElse(null);

        if(livro != null && cliente != null){
            livro.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(livro, cliente, java.time.LocalDate.now());
            registrarEmprestimo(emprestimo);
            System.out.printf("Livro %s emprestado com sucesso para %s%n", livro.getTitulo(), cliente.getNome());
            return true;
        }
        System.out.println("Livro não disponível ou cliente não cadastrado");
        return false;
    }

    public List<Emprestimo> consultarEmprestimosPorCliente(int clienteId){
        return emprestimos.stream().filter(e -> e.getCliente().getId() == clienteId).collect(Collectors.toList());
    }

    public List<Emprestimo> consultarEmprestimosPorLivro(int livroId){
        return emprestimos.stream().filter(e -> e.getLivro().getId() == livroId).collect(Collectors.toList());
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo){
        return livros.stream().filter(l -> l.getTitulo().contains(titulo)).collect(Collectors.toList());
    }

    public List<Livro> buscarLivrosPorAutor(String autorNome){
        return livros.stream().filter(l -> l.getAutor().getNome().contains(autorNome.toLowerCase())).collect(Collectors.toList());
    }

    public List<Livro> listarLivrosRecentes(){
        return livros.stream().filter(l -> l.getDataCadastro().isAfter(LocalDate.now().minusMonths(1))).collect(Collectors.toList());
    }



}
