package testes;

import models.Carta;
import models.Baralho;
import exceptions.BaralhoException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaralhoTest {
    @Test
    public void testCriarBaralho() {
        Baralho baralho = new Baralho();

        for (int i = 0; i < 52; i++) {
            try {
                Carta carta = baralho.pegarCarta();
                assertNotNull(carta);
            } catch (BaralhoException e) {
                fail("Exceção inesperada: " + e.getMessage());
            }
        }
    }

    @Test
    public void testPegarCartaComBaralhoVazio() {
        Baralho baralho = new Baralho();

        for (int i = 0; i < 52; i++) {
            try {
                baralho.pegarCarta();
            } catch (BaralhoException e) {
                fail("Exceção inesperada: " + e.getMessage());
            }
        }

        assertThrows(BaralhoException.class, baralho::pegarCarta);
    }
}