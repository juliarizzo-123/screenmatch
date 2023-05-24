package modelos;


////A PARTIR DO JAVA 17
public record TituloOmdb(String title, String year, String runtime) { // no json vem letra maiuscula

}

//EXEMPLO USANDO RECORD
//public record Telefone(String ddd, String numero){}
//
//EXEMPLO SEM USAR RECORD
//
//public final class Telefone {
//

//      declara variaveis

//    private final String ddd;
//    private final String numero;
//

//      construtor

//    public Telefone(String ddd, String numero) {
//        this.ddd = ddd;
//        this.numero = numero;
//    }
//
//
//    @Override
//    public int hashCode() { referenciaçao do obj
//        return Objects.hash(ddd, numero);
//    }
//

//    comparando o obj
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (!(obj instanceof Telefone)) {
//            return false;
//        } else {
//            Telefone other = (Telefone) obj;
//            return Objects.equals(ddd, other.ddd)
//                    && Objects.equals(numero, other.numero);
//        }
//    }
//

//     getters

//    public String getDdd() {
//        return this.ddd;
//    }
//
//    public String getNumero() {
//        return this.numero;
//    }
//}