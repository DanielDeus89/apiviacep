import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o CEP: ");
        String cep = sc.nextLine();

        ConsultaCep consultaCep  = new ConsultaCep();
        try{
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);

            GeradorArquivo geradorArquivo = new GeradorArquivo();
            geradorArquivo.gerarArquivo(novoEndereco);

        }catch (RuntimeException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}