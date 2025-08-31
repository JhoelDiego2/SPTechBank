package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DadosMock {
    static List<String> nomes = new ArrayList<>();
    static List<String> emails = new ArrayList<>();
    static List<String> contas = new ArrayList<>();
    static List<String> senhas = new ArrayList<>();
    static List<Double> saldos = new ArrayList<>();

    public DadosMock() {
        if (nomes.size() > 0){
            return;
        }
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
        System.out.println(emails);
        System.out.println(senhas);
        return ("Conta Criada com sucesso seja bem-vindo(a)");
    }
    Integer validarUsuario(String email, String conta, String senha){
        Integer indice = -1;
        System.out.println(emails);
        System.out.println(senhas);
        if (email != null){
            indice = emails.indexOf(email);
        } else if ( conta != null) {
            System.out.println(conta);
            indice = contas.indexOf(conta);
        }

        if ( indice >=0 && senha.equals(senhas.get(indice))){
            return indice;
        }else {
            return -1;
        }
    }
}
