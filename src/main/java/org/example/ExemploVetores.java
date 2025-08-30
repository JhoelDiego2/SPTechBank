package org.example;

import java.util.Arrays;

public class ExemploVetores {
    public static void main(String[] args) {

        int[] numeros = new int[5]; // quantidade de numeros do vertor
        int[] numerosValores = { 10,20,30,5, }; // vetores com numeros ou seja informações
        int[] numerosValores2forma = new int[] { 10,20,30,5, }; // vetores com numeros ou seja informações

        // objetos aceitam jull entao qual cciado com intereger aparecera null

        //System.out.println(numeros); esse sout mostra a identificação do objeto
        System.out.println(Arrays.toString(numeros));
        System.out.println(Arrays.toString(numerosValores));

        numeros[0] = 99;
        System.out.println(Arrays.toString(numeros));
        System.out.println(numerosValores[1]);
        System.out.println(numeros.length);


        for (int i = 0; i < numerosValores.length; i++) {
            System.out.println(numerosValores[i]);
        }


    }
}
