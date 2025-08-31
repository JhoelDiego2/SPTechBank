package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DadosMock {
    List<String> nomes = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> contas = new ArrayList<>();
    List<String> senhas = new ArrayList<>();
    List<Double> saldos = new ArrayList<>();

    public DadosMock() {
        nomes.add("jhoel");
        emails.add("jhoel@gmail.com");
        contas.add("68081000000");
        senhas.add("12345");
        saldos.add(323.00);
    }
    String gerarNumeroConta(){
        int numeroSpechBank = 6808;
        boolean numeroValido = false;
        String numeroContaOficial = "";
        int numeroConta = 0;
        while (numeroValido == true) {
            numeroConta = numeroSpechBank + ThreadLocalRandom.current().nextInt(10000, 99999);
            int indiceConta = contas.indexOf(numeroConta + "");
            if (indiceConta != -1) {
                numeroValido = false;
            } else {
                numeroValido = true;
            }
        }
        numeroContaOficial = String.valueOf(numeroConta);
        return numeroContaOficial;
    }
    String cadastrarUsuario(String nome, String email,  String senha){
        int indice_email = emails.indexOf(email);
        if (indice_email != -1){
            return ("E-mail atualmente em uso faça o seu login.");
        }
        String conta = gerarNumeroConta();
        nomes.add(nome);
        emails.add(email);
        contas.add(conta);
        senhas.add(senha);
        saldos.add(0.00);

        return ("Conta Criada com sucesso seja bem-vindo(a)");
    }
}
