package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import exceptions.BaralhoException;
import exceptions.JogadorException;
import models.Baralho;
import models.Carta;
import models.Jogador;
import models.ResultadoPartida;
import models.TipoResultado;

public class Main {
    private static List<ResultadoPartida> resultados = new ArrayList<>();

    public static void main(String[] args) throws JogadorException, BaralhoException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite seu nome: ");
            String nomeJogador = scanner.next();

            Baralho baralho = new Baralho();
            Jogador jogador = new Jogador(nomeJogador);
            Jogador dealer = new Jogador("Dealer");

            jogador.pegarCarta(baralho.pegarCarta());
            jogador.pegarCarta(baralho.pegarCarta());
            dealer.pegarCarta(baralho.pegarCarta());
            dealer.pegarCarta(baralho.pegarCarta());

            System.out.println("=== Blackjack ===");
            System.out.println("Sua mão:");
            jogador.desenharMao().forEach(Carta::desenharCarta);
            System.out.println("\nCarta visível do Dealer:");
            dealer.desenharMao().get(0).desenharCarta();

            if (jogador.temBlackjack()) {
                System.out.println("Parabéns, " + nomeJogador + "! Você tem um Blackjack!");
            } else {

                jogarTurno(jogador, baralho, scanner);

                jogarTurno(dealer, baralho, scanner);

                determinarVencedor(jogador, dealer);
            }

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("s")) {
                exibirResultadoGeral(resultados);
                System.out.println("Obrigado por jogar, " + nomeJogador + "! Adeus.");
                break;
            }
        }
    }

    private static void jogarTurno(Jogador jogador, Baralho baralho, Scanner scanner)
            throws BaralhoException, JogadorException {
        boolean continuarJogando = true;

        while (continuarJogando) {
            System.out.println("\n=== Vez de " + jogador.getNome() + " ===");
            jogador.desenharMao().forEach(Carta::desenharCarta);
            System.out.println("Pontuação atual: " + jogador.calcularPontuacao());

            System.out.print("Deseja pegar mais uma carta? (s/n): ");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("s")) {
                Carta novaCarta = baralho.pegarCarta();
                jogador.pegarCarta(novaCarta);
                System.out.println("Você pegou a carta: ");
                novaCarta.desenharCarta();

                if (jogador.calcularPontuacao() > 21) {
                    System.out.println("Você estourou! Sua pontuação é maior que 21.");
                    continuarJogando = false;
                }
            } else if (resposta.equalsIgnoreCase("n")) {
                continuarJogando = false;
            } else {
                System.out.println("Resposta inválida. Por favor, digite 's' para sim ou 'n' para não.");
            }
        }
    }

    private static void determinarVencedor(Jogador jogador1, Jogador jogador2) {
        int pontuacaoJogador1 = jogador1.calcularPontuacao();
        int pontuacaoJogador2 = jogador2.calcularPontuacao();
        String vencedor;
        TipoResultado tipoResultado;
        String detalhesPartida = "Detalhes da Partida";

        if (pontuacaoJogador1 > 21 && pontuacaoJogador2 > 21) {
            System.out.println("Empate! Ambos os jogadores pontuaram mais que 21.");
            vencedor = "Empate";
            tipoResultado = TipoResultado.EMPATE;
        } else if (pontuacaoJogador1 > 21) {
            System.out.println(jogador2.getNome() + " vence! " + jogador1.getNome() + " pontuou mais que 21.");
            vencedor = jogador2.getNome();
            tipoResultado = TipoResultado.VITORIA;
        } else if (pontuacaoJogador2 > 21) {
            System.out.println(jogador1.getNome() + " vence! " + jogador2.getNome() + " pontuou mais que 21.");
            vencedor = jogador1.getNome();
            tipoResultado = TipoResultado.VITORIA;
        } else if (pontuacaoJogador1 > pontuacaoJogador2) {
            System.out.println(jogador1.getNome() + " vence com " + pontuacaoJogador1 + " pontos!");
            vencedor = jogador1.getNome();
            tipoResultado = TipoResultado.VITORIA;
        } else if (pontuacaoJogador2 > pontuacaoJogador1) {
            System.out.println(jogador2.getNome() + " vence com " + pontuacaoJogador2 + " pontos!");
            vencedor = jogador2.getNome();
            tipoResultado = TipoResultado.VITORIA;
        } else {
            System.out.println("Empate! Ambos os jogadores pontuaram " + pontuacaoJogador1 + ".");
            vencedor = "Empate";
            tipoResultado = TipoResultado.EMPATE;
        }

        resultados.add(new ResultadoPartida(tipoResultado, jogador1.getNome(), jogador2.getNome(),
                pontuacaoJogador1, pontuacaoJogador2, Collections.singletonList(vencedor), detalhesPartida));
    }

    private static void exibirResultadoGeral(List<ResultadoPartida> resultados) {
        System.out.println("\n=== Resultado Geral ===");

        for (ResultadoPartida resultado : resultados) {
            System.out.println("Partida: " + resultado.getNomeJogador1() + " vs " + resultado.getNomeJogador2());

            if (resultado.getTipoResultado() == TipoResultado.EMPATE) {
                System.out.println("Empate!");
            } else {
                System.out.println("Vencedor(es): " + resultado.getNomesVencedores().get(0));
            }

            System.out.println(
                    "Pontuações: " + resultado.getNomeJogador1() + " (" + resultado.getPontuacaoJogador1() + "), "
                            + resultado.getNomeJogador2() + " (" + resultado.getPontuacaoJogador2() + ")\n");
        }
    }
}