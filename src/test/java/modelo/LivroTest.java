package modelo;

import builder.EmprestimoBuilder;
import builder.LivroBuilder;
import builder.UsuarioBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class LivroTest {

    @Test
    void estaReservado() {
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        assertFalse(livro.reservar());
    }

    @Test
    void estaEmprestado() {
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        assertFalse(livro.emprestar());
    }

    @Test
    void emprestimoPorUsuario() {
        Usuario usuario = UsuarioBuilder
                .umUsuario()
                .construi();

        Livro livro = LivroBuilder
                .umLivro()
                .construi();

        Emprestimo emprestimo = EmprestimoBuilder
                .umEmprestimo()
                .emUsuario(usuario)
                .emEmprestimoLivro(livro)
                .construi();

        List<Emprestimo> historico = LivroBuilder.umLivro().buscarHistoricoPorUsuario(usuario);
        int resulSize = historico.size();
        assertEquals(1,resulSize);
    }

}
