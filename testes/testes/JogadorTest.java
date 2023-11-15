package testes;

import models.Carta;
import models.Jogador;
import exceptions.JogadorException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogadorTest {
    @Test
    public void testPegarCarta() {
        Jogador jogador = new Jogador("Teste");
        Carta carta = new Carta("A", "Espadas");
        try {
            jogador.pegarCarta(carta);
        } catch (JogadorException e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
        assertEquals(1, jogador.desenharMao().size());
    }

    @Test
    public void testCalcularPontuacao() {
        Jogador jogador = new Jogador("Teste");
        Carta carta1 = new Carta("A", "Espadas");
        Carta carta2 = new Carta("K", "Copas");
        try {
            jogador.pegarCarta(carta1);
            jogador.pegarCarta(carta2);
        } catch (JogadorException e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
        assertEquals(21, jogador.calcularPontuacao());
    }

    @Test
    public void testTemBlackjack() {
        Jogador jogador = new Jogador("Teste");
        Carta carta1 = new Carta("A", "Espadas");
        Carta carta2 = new Carta("K", "Copas");
        try {
            jogador.pegarCarta(carta1);
            jogador.pegarCarta(carta2);
        } catch (JogadorException e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
        assertTrue(jogador.temBlackjack());
    }
}