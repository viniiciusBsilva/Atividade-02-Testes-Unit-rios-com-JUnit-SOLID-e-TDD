package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Livro {
    private String autor;
    private String titulo;
    private boolean emprestado;
    private boolean reservado;
    private List<Emprestimo> historico;

    public Livro(){}

    public Livro(String autor, String titulo, boolean emprestado, boolean reservado) {
        this.autor = autor;
        this.titulo = titulo;
        this.emprestado = emprestado;
        this.reservado = reservado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public List<Emprestimo> getHistorico() {
        return historico;
    }

    public void setHistorico(Emprestimo... historico) {
        this.historico.addAll(Arrays.asList(historico));
    }

    public boolean emprestar() {
        if (!this.isEmprestado()) {
            this.setEmprestado(true);
            System.out.println("Livro emprestado com sucesso");
        }
        return this.isEmprestado();
    }

    public List<Emprestimo> consultarEmprestimosPorUsuario(Usuario usuario) {
        List<Emprestimo> emprestismosPorUsuario = new ArrayList<Emprestimo>();
        for (Emprestimo emprestismoUsuario : emprestismosPorUsuario) {
            if (emprestismoUsuario.getUsuario().equals(usuario)) {
                emprestismosPorUsuario.add(emprestismoUsuario);
            }
        }
        return emprestismosPorUsuario;
    }
}