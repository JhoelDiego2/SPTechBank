package org.example.service;
import org.example.model.DadosMock;
import org.example.util.Utils;
import org.example.transacao.Transacao;

import java.util.Scanner;
public class Menu {
    Integer MenuInicial(){
        String linha = "-=====================================================================-";
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        Integer indiceUsuario = -1;

        System.out.println("""
                ┌=====================================================================┐
                │                                                                     │
                │  █████ █████ ██████ █████ █████ ██ ██    █████ █████ ██  ██ ██  █   │
                │  ██    ██ ██   ██   ██    ██    ██ ██    ██ ██ ██ ██ ███ ██ ██ █    │
                │  █████ █████   ██   █████ ██    █████ ██ ████  █████ ██████ ███     │
                │     ██ ██      ██   ██    ██    ██ ██    ██ ██ ██ ██ ██ ███ ██ █    │
                │  █████ ██      ██   █████ █████ ██ ██    █████ ██ ██ ██  ██ ██  █   │
                │                                                                     │
                └=====================================================================┘
                """);
        int opcao = 0;

        while(opcao !=3){
            System.out.println(linha);
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("3 - Sair");
            System.out.println(linha);
            opcao = leitorNumerico.nextInt();
            leitorNumerico.nextLine();

            switch(opcao) {
                case 1:
                    indiceUsuario = login.menuLogin();
                    if (indiceUsuario >= 0) {
                        menuPrincipal(indiceUsuario);
                    }
                    break;
                case 2:
                    cadastro.registrar();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digíte um valor válido!");
            }
        }
        return -1;
    }

    public void menuPrincipal(Integer indiceUsuario) {
        String linha = "-=====================================================================-";
        Scanner leitorNumerico = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);
        DadosMock dadosMock = new DadosMock();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println(linha);
            System.out.println("Olá " + dadosMock.getNome(indiceUsuario) + "!");
            System.out.println("Escolha a opção que deseja realizar:");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Ver histórico de transferências");
            System.out.println("3 - Fazer uma transferência");
            System.out.println("4 - Aposta");
            System.out.println("5 - Sair da conta");
            System.out.println(linha);
            opcao = leitorNumerico.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Seu saldo atual é: R$ " + dadosMock.getSaldo(indiceUsuario));
                    break;
                case 2:
                    System.out.println("Histórico de transferências:");
                    if (dadosMock.getHistorico(indiceUsuario).isEmpty()) {
                        System.out.println("Nenhuma transação encontrada.");
                    } else {
                        for (Transacao t : dadosMock.getHistorico(indiceUsuario)) {
                            System.out.println(t.formatarTexto());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o número da conta de destino:");
                    leitorNumerico.nextLine(); // Limpa o buffer do scanner numérico
                    String contaDestino = leitorTexto.nextLine();
                    System.out.println("Digite o valor que deseja transferir:");
                    Double valorTransferencia = leitorNumerico.nextDouble();
                    if (dadosMock.fazerTransferencia(indiceUsuario, contaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Falha na transferência. Verifique a conta de destino e o seu saldo.");
                    }
                    break;
                case 4:
                    System.out.println("aposta....");
                    break;
                case 5:
                    System.out.println("Saindo da conta...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}