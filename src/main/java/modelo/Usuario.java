package modelo;

import java.util.Objects;

public class Usuario {
    private String nome;
    private String matricula;
    private boolean emDebito;

    public Usuario(){};

    public Usuario(String nome, String matricula, boolean emDebito) {
        this.nome = nome;
        this.matricula = matricula;
        this.emDebito = emDebito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isEmDebito() {
        return emDebito;
    }

    public void setEmDebito(boolean emDebito) {
        this.emDebito = emDebito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return emDebito == usuario.emDebito && Objects.equals(nome, usuario.nome) && Objects.equals(matricula, usuario.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula, emDebito);
    }
}
