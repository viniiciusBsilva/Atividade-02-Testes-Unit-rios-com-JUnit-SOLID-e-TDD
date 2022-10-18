package service;

import builder.EmprestimoBuilder;
import builder.LivroBuilder;
import builder.UsuarioBuilder;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmprestimoServiceTest {
    EmprestimoService emprestimoService;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        emprestimoService = new EmprestimoService();
        usuario = new Usuario("Vinicius", "20SI", false);
    }

    @Test
    void realizaEmprestimoValido() {
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Emprestimo emprestimo = emprestimoService.emprestarLivro(usuario, livro);
        assertEquals(emprestimo.getUsuario(), usuario);
    }

    @Test
    void realizaEmprestimoParaLivroReservado() {
        Livro livro = LivroBuilder
                .umLivro()
                .taReservado()
                .construi();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> emprestimoService.emprestarLivro(usuario, livro),
                        "Deveria ter lançado um IllegalArgumentException");
        assertTrue(exception.getMessage().contains("Livro não disponível:"));
    }
}