package org.example;

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

            switch(opcao) {
                case 1:
                    indiceUsuario = login.menuLogin();
                    return indiceUsuario;
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
}

