package testes;

import models.ResultadoPartida;
import models.TipoResultado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ResultadoPartidaTest {
    @Test
    public void testCriarResultadoPartida() {
        ResultadoPartida resultado = new ResultadoPartida(TipoResultado.VITORIA, "Jogador 1", "Jogador 2", 21, 20,
                Arrays.asList("Jogador 1"));
        assertEquals(TipoResultado.VITORIA, resultado.getTipoResultado());
        assertEquals("Jogador 1", resultado.getNomeJogador1());
        assertEquals("Jogador 2", resultado.getNomeJogador2());
        assertEquals(21, resultado.getPontuacaoJogador1());
        assertEquals(20, resultado.getPontuacaoJogador2());
        assertEquals(Arrays.asList("Jogador 1"), resultado.getNomesVencedores());
    }

    @Test
    public void testToString() {
        ResultadoPartida resultado = new ResultadoPartida(TipoResultado.VITORIA, "Jogador 1", "Jogador 2", 21, 20,
                Arrays.asList("Jogador 1"));
        String resultadoStr = resultado.toString();
        assertTrue(resultadoStr.contains("Partida: Jogador 1 vs Jogador 2"));
        assertTrue(resultadoStr.contains("Vencedor(es): Jogador 1"));
        assertTrue(resultadoStr.contains("Pontuações: Jogador 1 (21), Jogador 2 (20)"));
    }
}