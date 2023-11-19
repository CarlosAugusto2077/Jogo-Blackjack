package models;

import java.util.*;

import exceptions.JogadorException;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        mao = new ArrayList<>();
    }

    public void pegarCarta(Carta carta) throws JogadorException {
        if (carta == null) {
            throw new JogadorException("Carta inválida recebida");
        }
        mao.add(carta);
    }

    public int calcularPontuacao() {
        int pontuacao = 0;
        int numAces = 0;

        for (Carta carta : mao) {
            String valor = carta.getValor();
            if (valor.equals("A")) {
                numAces++;
                pontuacao += 11;
            } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) {
                pontuacao += 10;
            } else {
                pontuacao += Integer.parseInt(valor);
            }
        }

        while (numAces > 0 && pontuacao > 21) {
            pontuacao -= 10;
            numAces--;
        }

        return pontuacao;
    }

    public boolean temBlackjack() {
        return (mao.size() == 2 && calcularPontuacao() == 21);
    }

    public List<Carta> desenharMao() {
        return mao;
    }

    public String getNome() {
        return nome;
    }
}