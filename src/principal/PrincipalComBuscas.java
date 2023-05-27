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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ctrl + alt + i
 * arruma a identaçao
 * */



public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {

       String busca = "";

        //deixando a busca dinamica
        Scanner leitura = new Scanner(System.in);

        List<Titulo> titulos = new ArrayList<>();

        //serializaçao
        Gson gson = new GsonBuilder()//alterando o padrao de nome para nn dar erro,
                // pois no jason veio leitra maiuscula e na class nn
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()//deixa o Jsom bonino
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }


            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=b01f14d8";

            try {
                //busca fixa do filme:  http://www.omdbapi.com/?t=matrix&apikey=b01f14d8
                //requisiçao
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                //resposta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                //mostra dados do filme sem formataçao daqui
                String json = response.body();
                System.out.println(json);
                // até aqui


                //Desserialização                        //tranforma json em tituloomdb.class
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //tratando erros
                //formatando print bonitinho
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);


                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro!");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
//        finally {     //vai aparecer independente de dar erro ou nn
//            System.out.println("Finalizou!!!");
//        }

        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");//escreve um arquivo
        escrita.write(gson.toJson(titulos)); //converte as Strings em json
        escrita.close();
        System.out.println("finalizou corretamente");




    }
}

