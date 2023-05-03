package principal;

import modelos.Filme;
import modelos.Serie;
import modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix" , 1999);
        favorito.avalia(10);

        Filme outro = new Filme("Jhon which" , 2014);
        outro.avalia(10);

        Serie serie = new Serie("la casa de papel", 2017);
        serie.avalia(8);

        ArrayList <Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        lista.add(serie);

        for (Titulo item: lista) {
            System.out.println("nome: " + item.getNome());

            //da certo só para filmes e qnd "aparece" da erro
//            Filme filme = (Filme) item;
//            System.out.println("avaliaçao: " + filme.getClassificacao());

            //nao é interessante fazer porem para mostrar a avaliaçao sem dar erro pode se fazer:
            if (item instanceof Filme filme && filme.getClassificacao() > 2 ){
                System.out.println("Classificaçao: " + filme.getClassificacao());

            }

            ArrayList<String> buscaPorArtista = new ArrayList<>();
            buscaPorArtista.add("alex");
            buscaPorArtista.add("julia");
            buscaPorArtista.add("elaine");

            System.out.println(buscaPorArtista);

            //para mostrar a lista em ordem alfabetica
            System.out.println("organizado");
            Collections.sort(buscaPorArtista);
            // so da certo depois de implementar implements Comparable<Titulo> na classe titulo
            Collections.sort(lista);

            
        }
        
        
        
    }
}
