package modelo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Reserva {
    private Usuario usuario;
    private LocalDate dataDeReserva;
    private LocalDate dataPrevistaParaEmprestimo;
    private List<Livro> livros;

    public Reserva(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataDeReserva() {
        return dataDeReserva;
    }

    public void setDataDeReserva(LocalDate dataDeReserva) {
        this.dataDeReserva = dataDeReserva;
    }

    public LocalDate getDataPrevistaParaEmprestimo() {
        return dataPrevistaParaEmprestimo;
    }

    public void setDataPrevistaParaEmprestimo(LocalDate dataPrevistaParaEmprestimo) {
        this.dataPrevistaParaEmprestimo = dataPrevistaParaEmprestimo;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivros(Livro... livros) {
        if (livros.length < 1 || livros.length > 1) throw new IllegalArgumentException("A reserva aceita apenas um livro");
        else this.livros.addAll(Arrays.asList(livros));
    }
}
