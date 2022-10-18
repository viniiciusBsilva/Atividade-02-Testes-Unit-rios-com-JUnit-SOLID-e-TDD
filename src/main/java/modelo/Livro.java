package modelo;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String autor;
    private String titulo;
    private Boolean emprestado;
    private Boolean reservado;
    private List<Emprestimo> historico;

    public Livro(){}

    public Livro(String autor, String titulo, Boolean emprestado, Boolean reservado, List<Emprestimo> historico) {
        this.autor = autor;
        this.titulo = titulo;
        this.emprestado = emprestado;
        this.reservado = reservado;
        this.historico = historico;
    }

    public List<Emprestimo> consultarEmprestimosPorUsuario(Usuario usuario){
        List<Emprestimo> emprestimosPorUsuario = new ArrayList<>();
        for(Emprestimo emprestimoUsuario : emprestimosPorUsuario){
            if(emprestimoUsuario.getUsuario().equals(usuario)){
                emprestimosPorUsuario.add(emprestimoUsuario);
            }
        }
        return emprestimosPorUsuario;
    }

    public boolean emprestar(){
        if(!this.isEmprestado()){
            this.setEmprestado(true);
            System.out.println("Emprestado com sucesso!");
        }
        return this.isEmprestado();
    }

    private boolean isEmprestado() {
        if (this.getEmprestado()){
            return true;
        }else return false;
    }

    public boolean reservar(){
        if(!this.isReservado()&&this.isEmprestado()){
            this.setReservado(true);
            System.out.println("Reservado com sucesso!");
        }
        return this.isReservado();
    }

    private boolean isReservado(){
        if(this.isReservado()){
            return true;
        }else return false;
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

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public List<Emprestimo> getHistorico() {
        return historico;
    }

    public void addHistorico(Emprestimo historico) {
        this.historico.add(historico);
    }
}
