//a class especifica o conteudo de um objeto
public class Filme {
    //quando declara a variavel sem o metodo main é q td "filme" tem
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    int duracaoEmMinutos;


    //criando o metodo q nn recebe nada
    void exibeFichaTecnica(){
        System.out.println("Nome do flme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void  avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao++;

    }
    //retorna um decimal
    double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacao;
    }

// com esse metodo mostra avaliaçoes eu nn preciso fazer um get para total de avaliaçoes
//    void  mostraAvaliacoes(){
//        System.out.println("Soma das avaliaçoes do flme: " + somaDasAvaliacoes);
//        System.out.println("Total de avaliaçoes: " + totalDeAvaliacao);
//        System.out.println("A media das avaliaçoes é: " + pegaMedia());
//
//    }
// mas se nn tivesse precisaria ex
    int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }




}
