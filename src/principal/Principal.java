package principal;

import calculos.CalculadoraDeTempo;
import calculos.FiltroRecomendacao;
import modelos.Episodio;
import modelos.Filme;
import modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        // tipo por referencia ao obj
        Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
        //criando o obj /guarda o obj

        //atribuindo valor aos atributos: / instanciando
//        meuFilme.setNome("O Poderoso Chefão");
//        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.getIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(9);
        meuFilme.avalia(7);
        meuFilme.avalia(5);

        //meuFilme.mostraAvaliacoes();
       // System.out.println("Total de avaliaçoes: " + meuFilme.getTotalDeAvaliacao());
        System.out.println("A media das avaliaçoes é: " + meuFilme.pegaMedia());

        Serie lost = new Serie("lost", 2000);
//        lost.setNome("lost");
//        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setMinutosPorEpsodios(40);
        lost.setEpsodiosPorTemporada(20);
        lost.setTemporadas(10);
        System.out.println("duraçao em min: " + lost.getDuracaoEmMinutos());


        Filme filme3 = new Filme("Avatar 2", 2023);
//        filme3.setNome("Avatar 2");
//        filme3.setAnoDeLancamento(2023);
        filme3.setDuracaoEmMinutos(200);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(filme3);
        calculadora.inclui(lost);
        System.out.println("o tempo total da sua lista de filmes é: " + calculadora.getTempoTotal());

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(episodio);

        // no lugar de escrever Filme filmeDoPaulo = new Filme();
        //tambem vale---> var .....
        var filmeDoPaulo = new Filme("dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(filmeDoPaulo);
        System.out.println("O tamanho da lista é: " + listaDeFilmes.size());
        System.out.println("O primeiro filme é: " + listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);
//       // System.out.println("toString " + listaDeFilmes.get(0).toString());


    }
}





