package models;

import java.util.Collections;
import java.util.List;

public class ResultadoPartida {
    private TipoResultado tipoResultado;
    private String nomeJogador1;
    private String nomeJogador2;
    private int pontuacaoJogador1;
    private int pontuacaoJogador2;
    private List<String> nomesVencedores;

    public ResultadoPartida(TipoResultado tipoResultado, String nomeJogador1, String nomeJogador2,
            int pontuacaoJogador1, int pontuacaoJogador2, List<String> nomesVencedores) {
        this.tipoResultado = tipoResultado;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.pontuacaoJogador1 = pontuacaoJogador1;
        this.pontuacaoJogador2 = pontuacaoJogador2;
        this.nomesVencedores = nomesVencedores;
    }

    public ResultadoPartida(TipoResultado tipoResultado, String nomeJogador1, String nomeJogador2,
            int pontuacaoJogador1, int pontuacaoJogador2, String vencedor, String detalhesPartida) {
        this.tipoResultado = tipoResultado;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.pontuacaoJogador1 = pontuacaoJogador1;
        this.pontuacaoJogador2 = pontuacaoJogador2;
        nomeJogador1 = detalhesPartida;
        this.nomesVencedores = Collections.singletonList(vencedor);
    }

    public ResultadoPartida(TipoResultado tipoResultado, String nomeJogador1, String nomeJogador2,
            int pontuacaoJogador1, int pontuacaoJogador2, List<String> nomesVencedores, String detalhesPartida) {
        this.tipoResultado = tipoResultado;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.pontuacaoJogador1 = pontuacaoJogador1;
        this.pontuacaoJogador2 = pontuacaoJogador2;
        this.nomesVencedores = nomesVencedores;
        nomeJogador2 = detalhesPartida;
    }

    public TipoResultado getTipoResultado() {
        return tipoResultado;
    }

    public String getNomeJogador1() {
        return nomeJogador1;
    }

    public String getNomeJogador2() {
        return nomeJogador2;
    }

    public int getPontuacaoJogador1() {
        return pontuacaoJogador1;
    }

    public int getPontuacaoJogador2() {
        return pontuacaoJogador2;
    }

    public List<String> getNomesVencedores() {
        return nomesVencedores;
    }

    @Override
    public String toString() {
        StringBuilder resultadoStr = new StringBuilder();
        resultadoStr.append("Partida: ").append(nomeJogador1).append(" vs ").append(nomeJogador2).append(", ");

        if (tipoResultado == TipoResultado.VITORIA) {
            resultadoStr.append("Vencedor(es): ");
            for (String vencedor : nomesVencedores) {
                resultadoStr.append(vencedor).append(", ");
            }
            resultadoStr.setLength(resultadoStr.length() - 2);
        } else {
            resultadoStr.append("Empate");
        }

        resultadoStr.append(", Pontuações: ").append(nomeJogador1).append(" (").append(pontuacaoJogador1).append("), ")
                .append(nomeJogador2).append(" (").append(pontuacaoJogador2).append(")");

        return resultadoStr.toString();
    }
}