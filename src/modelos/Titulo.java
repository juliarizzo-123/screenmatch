package modelos;

public class Titulo {
    //quando declara a variavel sem o metodo main é q td "filme" tem
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public String getNome() {
        return nome;
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
    public int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }

// com esse metodo mostra avaliaçoes eu nn preciso fazer um get para total de avaliaçoes
//   public void  mostraAvaliacoes(){
//        System.out.println("Soma das avaliaçoes do flme: " + somaDasAvaliacoes);
//        System.out.println("Total de avaliaçoes: " + totalDeAvaliacao);
//        System.out.println("A media das avaliaçoes é: " + pegaMedia());
//
//    }
// mas se nn tivesse precisaria ex
}
