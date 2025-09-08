package org.example.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.example.transacao.Transacao;

public class DadosMock {
    static List<String> nomes = new ArrayList<>();
    static List<String> emails = new ArrayList<>();
    static List<String> contas = new ArrayList<>();
    static List<String> senhas = new ArrayList<>();
    static List<Double> saldos = new ArrayList<>();
    static List<List<Transacao>> historicoTransferencias = new ArrayList<>();

    public DadosMock() {
        if (nomes.size() > 0){
            return;
        }
        nomes.add("jhoel");
        emails.add("jhoel@gmail.com");
        contas.add("68081000000");
        senhas.add("12345");
        saldos.add(323.00);
        historicoTransferencias.add(new ArrayList<>());
    }
    String gerarNumeroConta(){
        int numeroSpechBank = 6808;
        boolean numeroValido = false;
        String numeroContaOficial = "";
        int numeroConta = 0;
        while (!numeroValido) {
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
    public String cadastrarUsuario(String nome, String email, String senha){
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
        historicoTransferencias.add(new ArrayList<>());
        System.out.println(emails);
        System.out.println(senhas);
        return ("Conta Criada com sucesso seja bem-vindo(a)");
    }
    public Integer validarUsuario(String email, String conta, String senha){
        Integer indice = -1;
        if (!email.isEmpty()){
            indice = emails.indexOf(email);
        } else if (!conta.isEmpty()) {
            indice = contas.indexOf(conta);
        }

        if ( indice >=0 && senha.equals(senhas.get(indice))){
            return indice;
        }else {
            return -1;
        }
    }
    public Double getSaldo(Integer indiceUsuario) {
        return saldos.get(indiceUsuario);
    }

    public boolean fazerTransferencia(Integer indiceUsuario, String contaDestino, Double valor) {
        if (saldos.get(indiceUsuario) < valor) {
            return false;
        }
        int indiceDestino = contas.indexOf(contaDestino);
        if (indiceDestino == -1) {
            return false;
        }
        saldos.set(indiceUsuario, saldos.get(indiceUsuario) - valor);
        saldos.set(indiceDestino, saldos.get(indiceDestino) + valor);

        historicoTransferencias.get(indiceUsuario).add(new Transacao("Transferência para " + nomes.get(indiceDestino), -valor));
        historicoTransferencias.get(indiceDestino).add(new Transacao("Recebido de " + nomes.get(indiceUsuario), valor));
        return true;
    }

    public void adicionarSaldo(Integer indiceUsuario, double valor) {
        saldos.set(indiceUsuario, saldos.get(indiceUsuario) + valor);
        historicoTransferencias.get(indiceUsuario).add(new Transacao("Crédito por aposta ganha", valor));
    }

    public void removerSaldo(Integer indiceUsuario, double valor) {
        saldos.set(indiceUsuario, saldos.get(indiceUsuario) - valor);
        historicoTransferencias.get(indiceUsuario).add(new Transacao("Débito por aposta perdida", -valor));
    }

    public List<Transacao> getHistorico(Integer indiceUsuario) {
        return historicoTransferencias.get(indiceUsuario);
    }

    public String getNome(Integer indiceUsuario) {
        return nomes.get(indiceUsuario);
    }
}