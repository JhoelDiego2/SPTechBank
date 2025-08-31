package org.example;
import java.util.Scanner;

public class Cadastro {
    void registrar() {
        DadosMock dadosMock = new DadosMock();
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);


        System.out.print("Nome: ");
        String nome = leitorTexto.nextLine();
        System.out.print("E-mail: ");
        String email = leitorTexto.nextLine();
        System.out.print("Senha: ");
        String senha = leitorTexto.nextLine();
        System.out.println("Confirmar Senha");
        String confSenha = leitorTexto.nextLine();

        if (!senha.equals(confSenha)){
            System.out.println("Senhas não coincidem");
        }else{
            String resultado = dadosMock.cadastrarUsuario(nome, email, senha );
            System.out.println(resultado);
        }
    }
}
