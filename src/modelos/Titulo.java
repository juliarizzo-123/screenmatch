package modelos;

import calculos.Classificavel;
import com.google.gson.annotations.SerializedName;
import excecao.ErroDeConversaoDeAnoException;

public class Titulo  implements Comparable<Titulo> {
    //quando declara a variavel sem o metodo main é q td "filme" tem
    @SerializedName("Title") //corre o risco de se mudar o nome vai dar erro
    private String nome;
    @SerializedName("Yaer")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meutituloOmdb){
        this.nome = meutituloOmdb.title();

        if (meutituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("não consegui converter o ano pois tem mais de 4 caracteres");
        }


        this.anoDeLancamento = Integer.valueOf(meutituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meutituloOmdb.runtime().substring(0, 2));
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public boolean getIncluidoNoPlano(boolean b) {
        return incluidoNoPlano;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    //criando o metodo q nn recebe nada
    public void exibeFichaTecnica(){
        System.out.println("Nome do flme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void  avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao++;

    }
    //retorna um decimal
    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacao;
    }
    // com esse metodo mostra avaliaçoes eu nn preciso fazer um get para total de avaliaçoes
//   public void  mostraAvaliacoes(){
//        System.out.println("Soma das avaliaçoes do flme: " + somaDasAvaliacoes);
//        System.out.println("Total de avaliaçoes: " + totalDeAvaliacao);
//        System.out.println("A media das avaliaçoes é: " + pegaMedia());
//
//    }
// mas se nn tivesse precisaria ex
    public int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
//    poderia fazer o toString so aqui porem nao iria imprimir "bonitinho" e separado para serie e filme


    @Override
    public String toString() {
        return  "nome = " + nome +
                ", anoDeLancamento = " + anoDeLancamento +
                ", duracaoEmMinutos = " + duracaoEmMinutos + " min ";
    }
}




