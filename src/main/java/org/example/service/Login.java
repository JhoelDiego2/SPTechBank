package org.example.service;

import org.example.model.DadosMock;
import org.example.util.Utils;

import java.util.Scanner;

public class Login {
    Integer menuLogin(){
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        DadosMock dadosMock = new DadosMock();
        String email = "";
        String conta = "";

        System.out.println("Olá seja bem-vindo(a) novamente!");
        System.out.println("Escolha a forma de entrar na sua conta: ");
        System.out.println("1 - E-mail");
        System.out.println("2 - Número da sua conta");
        System.out.println("3 - Voltar atrás");
        int opcao = leitorNumerico.nextInt();
        if (opcao == 1){
            System.out.print("E-mail: ");
            email = leitorTexto.nextLine();
            if (!Utils.validarEmail(email)) {
                System.out.println("Digite um e-mail válido ex: sptech@gmail.com");
                menuLogin();
            }
        } else if (opcao == 2) {
            System.out.print("Numero da Conta: ");
            conta = leitorTexto.nextLine();
        } else if (opcao == 3) {
            return -1;
        } else{
            menuLogin();
        }
        System.out.print("Senha: ");
        String senha = leitorTexto.nextLine();
        Integer resultado = dadosMock.validarUsuario(email, conta, senha);
        if (resultado >= 0){
            System.out.println("Conta verificada com sucesso!");
        }else{
            System.out.println("E-mail, conta ou senha incorretas!");
        }
        return resultado;
    }
}