package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excecao.ErroDeConversaoDeAnoException;
import modelos.Titulo;
import modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/*
 * ctrl + alt + i
 * arruma a identaçao
 * */



public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {
        //deixando a busca dinamica
        Scanner leitura = new Scanner(System.in);
        System.out.println("Busca: ");
        var busca = leitura.nextLine();
        String endereco =  "http://www.omdbapi.com/?t=" + busca.replace(" " , "+") + "&apikey=b01f14d8";

        //busca fixa do filme:  http://www.omdbapi.com/?t=matrix&apikey=b01f14d8
        //requisiçao
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request  = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        //resposta
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        //mostra dados do filme sem formataçao daqui
        String json = response.body();
        System.out.println(json);
        // até aqui

        //serializaçao
        Gson gson =  new GsonBuilder()//alterando o padrao de nome para nn dar erro,
                // pois no jason veio leitra maiuscula e na class nn
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Desserialização                        //tranforma json em tituloomdb.class
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);
        //tratando erros
            //formatando print bonitinho
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);
            //escreve um arquivo
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro!");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }
//        finally {     //vai aparecer independente de dar erro ou nn
//            System.out.println("Finalizou!!!");
//        }

        System.out.println("finalizou corretamente");




    }
}
