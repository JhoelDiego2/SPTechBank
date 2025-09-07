package org.example.service;

import org.example.model.DadosMock;

import java.util.Scanner;

public class Cadastro {
    void registrar() {
        DadosMock dadosMock = new DadosMock();
        Scanner leitorTexto = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = leitorTexto.nextLine();
        System.out.print("E-mail: ");
        String email = leitorTexto.nextLine();
        System.out.print("Senha: ");
        String senha = leitorTexto.nextLine();
        System.out.print("Confirmar Senha: ");
        String confSenha = leitorTexto.nextLine();

        if (nome.equals("") || email.equals("") || senha.equals("") || confSenha.equals("")){
            System.out.println("Digite todos os campos!");
            registrar();
        } else if (!senha.equals(confSenha)) {
            System.out.println("Senhas não coincidem");
        } else if (!email.contains("@gmail.com") || email.contains(" ")) {
            System.out.println("Digite um e-mail valido ex: sptech@gmail.com");
            registrar();
        } else{
            String resultado = dadosMock.cadastrarUsuario(nome, email, senha );
            System.out.println(resultado);
        }
    }
}
