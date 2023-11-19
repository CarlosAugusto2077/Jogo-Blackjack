package models;

import java.util.*;

import exceptions.BaralhoException;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] naipes = { "O", "E", "P", "C" };
        for (String valor : valores) {
            for (String naipe : naipes) {
                cartas.add(new Carta(valor, naipe));
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() throws BaralhoException {
        if (cartas.isEmpty()) {
            throw new BaralhoException("Não há mais cartas no baralho");
        }
        return cartas.remove(cartas.size() - 1);
    }
}