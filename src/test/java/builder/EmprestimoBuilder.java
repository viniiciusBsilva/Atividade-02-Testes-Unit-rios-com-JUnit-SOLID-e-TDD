package builder;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

import java.time.LocalDate;

public class EmprestimoBuilder {
    private Emprestimo emprestimo;

    private EmprestimoBuilder() {}

    public static EmprestimoBuilder umEmprestimo() {
        EmprestimoBuilder builder = new EmprestimoBuilder();

        builder.emprestimo = new Emprestimo();
        builder.emprestimo.setDataEmprestimo(LocalDate.now());
        builder.emprestimo.setDataPrevista(LocalDate.now().plusDays(7));

        return builder;
    }

    public EmprestimoBuilder emDevolucao() {
        this.emprestimo.setDataDevolucao(LocalDate.now());
        return this;
    }

    public EmprestimoBuilder emUsuario(Usuario usuario) {
        this.emprestimo.setUsuario(usuario);
        return this;
    }

    public EmprestimoBuilder emEmprestimoLivro(Livro livroBuilder) {
        this.emprestimo.addLivros(livroBuilder);
        return this;
    }

    public Emprestimo construi() {
        return this.emprestimo;
    }
}
