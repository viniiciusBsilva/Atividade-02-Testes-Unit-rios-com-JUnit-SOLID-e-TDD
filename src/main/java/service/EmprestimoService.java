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
                    if (livro.isEmprestado())
                        throw new IllegalArgumentException("Livro não disponível: " + livro.getTitulo());
                });

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.addLivros(livros);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now() );
        for (Livro l:livros) {
            l.emprestar();
        }

        emprestimo.setDataPrevista(LocalDate.now().plusDays(7) );

        return emprestimo;
    }

    private double calculaValorLocacao(int dias, Livro... livros) {

        double valorLivro = 5.00;
        for (Livro l: livros) {
            valorLivro+=5.00;
        }
        if (dias == 0){
            return valorLivro;
        }else {
            double acrescimo = dias * 0.40;
            if (acrescimo>(0.6*valorLivro)){
               acrescimo = 0.6*valorLivro;
            }
            return acrescimo+valorLivro;
        }
    }


    public double devolucaoLivro(Usuario usuario,Livro... livros){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.addLivros(livros);

        if(emprestarLivro(usuario, livros).equals(emprestimo)){
            emprestimo.setDataDevolucao(LocalDate.now());
            if(emprestimo.getDataDevolucao().isAfter(emprestimo.getDataPrevista())){
                int dias = emprestimo.getDataDevolucao().getDayOfYear() - emprestimo.getDataPrevista().getDayOfYear();
                for (Livro l: livros) {
                    l.setHistorico(emprestimo);
                }
                emprestimo.getLivros().remove(livros);
                return calculaValorLocacao(dias, livros);
            }else {
                for (Livro l: livros) {
                    l.setHistorico(emprestimo);
                }
                emprestimo.getLivros().remove(livros);
                return calculaValorLocacao(0, livros);
            }
        }
        return 0;

    }



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
