package service;

import builder.EmprestimoBuilder;
import builder.LivroBuilder;
import builder.UsuarioBuilder;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        assertEquals(emprestimo.getDataEmprestimo(), LocalDate.now());
        assertEquals(emprestimo.getDataPrevista(), LocalDate.now().plusDays(7));
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

    @Test
    void realizarEmprestimoComDataPrevistaCorreta(){
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Emprestimo emprestimo = emprestimoService.emprestarLivro(usuario, livro);
        assertEquals(emprestimo.getDataPrevista(),emprestimo.getDataEmprestimo().plusDays(7));
    }

    @Test
    void usuarioSemEmprestimo(){
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Usuario usuario1 = new Usuario("Vinicius","1234",false);
        assertTrue(livro.consultarEmprestimosPorUsuario(usuario1).isEmpty());
    }

    @Test
    void usuarioComUmEmprestimo(){
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Emprestimo emprestimo = emprestimoService.emprestarLivro(usuario, livro);
        assertEquals(emprestimo.getUsuario(), usuario);
    }

    @Test
    void usuarioComUTresEmprestimos(){
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Livro livro1 = new Livro("A moça", "A revolução dos bichos", false, false);
        Livro livro2 = new Livro("O moço", "A revolução dos insetos", false, false);
        Livro[] livros = {livro,livro1,livro2};
        Emprestimo emprestimo = emprestimoService.emprestarLivro(usuario, livros);
        assertEquals(emprestimo.getUsuario(), usuario);
    }

    @Test
    void usuarioComQuatroEmprestimos(){
        Livro livro = LivroBuilder
                .umLivro()
                .construi();
        Livro livro1 = new Livro("A moça", "A revolução dos bichos", false, false);
        Livro livro2 = new Livro("O moço", "A revolução dos insetos", false, false);
        Livro livro3 = new Livro("O menino", "A cabana", false, false);
        Livro[] livros = {livro,livro1,livro2,livro3};

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> emprestimoService.emprestarLivro(usuario, livros),
                        "Deveria ter lançado um IllegalArgumentException");

        assertTrue(exception.getMessage().contains("A lista precisa de no máximo três livros"));
    }

}