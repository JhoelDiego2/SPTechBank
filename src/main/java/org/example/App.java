package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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