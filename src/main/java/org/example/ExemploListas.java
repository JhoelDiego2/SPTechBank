package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExemploListas {
    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();// padrao de 10posicoes
        frutas.add("Morango");

        List<String> frutasV =
                new ArrayList<>(List.of( "fdsaf", "fdas"));

        frutasV.addAll(List.of("Maca", "fdsa"));
        System.out.println(frutas);
        System.out.println(frutasV);


        frutasV.addFirst("Jfasdkljf");
        frutasV.add(3, "sfsssdds");

        frutasV.set(3, "fdsafdsakfjsajdfjjkj");
        System.out.println(frutasV);

        frutasV.remove("fdskjlal"); // exclui a primeira ocorrencia que ele encontrarar

        frutasV.removeAll(List.of("fdsalkf", "fdsaf")); // remove aparitr de umalista os texto que ele encontrar

        frutasV.remove(3);
        frutasV.clear(); // lilmpar a lista

        // sobrecarga no comando remove na qual tenho que veridica se eu quero remoser pelo indece ou pelo objeto

        frutasV.size();// tamanho da lista e para vertrooes seria lenght

        frutasV.get(2);// fruntasV[2]

        for (int i = 0; i < frutasV.size(); i++) {
            frutasV.get(i);
        }

        frutasV.isEmpty();


        frutasV.contains("fasda");



    }
}
