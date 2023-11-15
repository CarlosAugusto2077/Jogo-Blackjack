package models;

public class Carta {
    private String valor;
    private String naipe;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public void desenharCarta() {
        String naipeSimbolo;
        switch (naipe) {
            case "O":
                naipeSimbolo = "O";
                break;
            case "E":
                naipeSimbolo = "E";
                break;
            case "P":
                naipeSimbolo = "P";
                break;
            case "C":
                naipeSimbolo = "C";
                break;
            default:
                naipeSimbolo = "?";
        }

        System.out.println(" _________ ");
        System.out.println("|" + valor + "        |");
        System.out.println("|         |");
        System.out.println("|    " + naipeSimbolo + "    |");
        System.out.println("|         |");
        System.out.println("|________" + valor + "|");
    }
}