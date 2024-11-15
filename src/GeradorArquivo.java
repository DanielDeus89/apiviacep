import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void gerarArquivo(Endereco endereco) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try (FileWriter escrita = new FileWriter(endereco.cep() + ".json")) { // try-with-resources
            escrita.write(gson.toJson(endereco));
            System.out.println("Arquivo gerado com sucesso: " + endereco.cep() + ".json");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}