package org.example;

import org.example.service.Menu;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Integer indiceUsuario = menu.MenuInicial();
        if (indiceUsuario >= 0){
            System.out.println("usuario");
            System.out.println( indiceUsuario);
        }else{
            System.out.println("nada");
        }
    }
}