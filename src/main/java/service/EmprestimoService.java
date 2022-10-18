package service;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

import java.time.LocalDate;
import java.util.Arrays;

public class EmprestimoService {

    public Emprestimo emprestarLivro(Usuario usuario, Livro... livros){
        Arrays.stream(livros).
                forEach(livro -> {
                    if (!livro.emprestar())
                        throw new IllegalArgumentException("Livro não disponível: " + livro.getTitulo());
                });

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.addLivros(livros);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now() );

        emprestimo.setDataPrevista(LocalDate.now().plusDays(7) );

        return emprestimo;
    }

    private double calculaValorLocacao(Livro... livros) {
        double valorTotal = 0, valorLivro = 5;

        for(int i = 1; i <= livros.length; i++){
            valorTotal = valorLivro;
            if(valorTotal <= (valorLivro * 0.6)){
                valorTotal += 0.4;
            }
        }
        return valorTotal;
    }

    /*
    public Emprestimo devolucaoLivro(Usuario usuario,Livro... livros){
        Emprestimo emprestimo = new Emprestimo();

        Arrays.stream(livros).
                forEach(livro -> {
                if(emprestimo.getUsuario().equals(usuario)&&emprestimo.getLivros().equals(livros)){

                }
                });
        return null;
    }*/



/*    public Reserva reservarLivro(Usuario usuario, Livro... livros){
        Arrays.stream(livros).
                forEach(livro -> {
                    if (!livro.reservar())
                        throw new IllegalArgumentException("Livro já reservado: " + livro.getTitulo());
                });

        Reserva reserva = new Reserva();
        reserva.addLivros(livros);
        reserva.setUsuario(usuario);
        reserva.setDataDeReserva(LocalDate.now() );

        reserva.setDataPrevistaParaEmprestimo(LocalDate.now().plusDays(7) );

        return reserva;
    }*/

}
