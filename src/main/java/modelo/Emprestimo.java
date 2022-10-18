package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emprestimo {
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private List<Livro> livros = new ArrayList<>();

    public Emprestimo(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivros(Livro... livros) {
        try{
            if (livros.length<1 || livros.length>3)throw new IllegalArgumentException();
            else this.livros.addAll(Arrays.asList(livros));
        }catch (IllegalArgumentException e) {
            System.out.println("a lista precisa de pelo menos um livro e no máximo 3 livros");
        }
    }
}
