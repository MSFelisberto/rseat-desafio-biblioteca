package emprestimo;

import cliente.Cliente;
import livro.Livro;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
