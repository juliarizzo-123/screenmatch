package calculos;

import modelos.Filme;
import modelos.Serie;
import modelos.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;


    public int getTempoTotal() {
        return tempoTotal;
    }
//    sobrecarga de metodos
//    public void inclui(Filme f){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie s){
//        tempoTotal += s.getDuracaoEmMinutos();
//    }
public void inclui(Titulo titulo) {
    tempoTotal += titulo.getDuracaoEmMinutos();
}


}
