import calculos.CalculadoraDeTempo;
import modelos.Filme;
import modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        // tipo por referencia ao obj
        Filme meuFilme = new Filme();
        //criando o obj /guarda o obj

        //atribuindo valor aos atributos: / instanciando
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.getIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(9);
        meuFilme.avalia(7);
        meuFilme.avalia(5);

        //meuFilme.mostraAvaliacoes();
       // System.out.println("Total de avaliaçoes: " + meuFilme.getTotalDeAvaliacao());
        System.out.println("A media das avaliaçoes é: " + meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setMinutosPorEpsodios(40);
        lost.setEpsodiosPorTemporada(20);
        lost.setTemporadas(10);
        System.out.println("duraçao em min: " + lost.getDuracaoEmMinutos());


        Filme filme3 = new Filme();
        filme3.setNome("Avatar 2");
        filme3.setAnoDeLancamento(2023);
        filme3.setDuracaoEmMinutos(200);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(filme3);
        calculadora.inclui(lost);
        System.out.println("o tempo total da sua lista de filmes é: " + calculadora.getTempoTotal());


    }
}





