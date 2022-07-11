/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.controlador;

import java.util.ArrayList;
import lab3.clases.*;
import java.util.Arrays;

/**
 *
 * @author CLEMENTE
 * Controlador corresponde a la clase responsable de interactuar los
 * métodos de las otras clases con la interfaz gráfica.
 * 
 * Sus atributos son:
 * Game: Juego de Dobble.
 * elements1: Lista de strings que contiene los elementos a aparecer en una carta
 * de Dobble.
 */
public class Controlador {

    private DobbleGame Game;
    public ArrayList<String> elements1 = new ArrayList<>(
                        Arrays.asList("-", "Leon", "Conejo", "Leopardo", "Oso", "Aguila", "Serpiente",
                              "Zorro", "Loro", "Puma", "Tigre", "Escorpion", "Capibara",
                              "Jaguar", "Avestruz", "Jirafa", "Elefante", "Rinoceronte", "Ballena",
                              "Mono", "Chimpance", "Gorila", "Nandu", "Pudu", "Alce",
                              "Hipopotamo", "Coyote", "Venado", "Antilope", "Tucan", "Caballo",
                              "Pinguino", "imOp"));

    /**
     *
     */
    public Controlador() {
        Game = new DobbleGame();
    }

    /**
     *
     * @return
     */
    public DobbleGame getGame() {
        return Game;
    }

    /**
     *
     * @param Game
     */
    public void setGame(DobbleGame Game) {
        this.Game = Game;
    }

    public boolean esPrimo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void crear_juego(int cantidad, int maxC, int numE, int modo) {
        if (cantidad <= 0) {
            System.out.println("No se puede crear un juego con 0 jugadores");
            return;
        }
        if (maxC < -1) {
            System.out.println("El tamaño debe ser mayor o igual que -1.");
            return;
        }
        if (maxC > 31) {
            System.out.println("El tamaño sobrepasa el maximo de elementos.");
            return;
        }
        if (modo <= 0) {
            System.out.println("No se puede crear un juego sin su modo");
            return;
        }
        Dobble dobble = new Dobble(numE, maxC, elements1);
        Game.setCantJugadores(cantidad);
        Game.setCardsSet(dobble);
        Game.setModoJuego(modo);
        return;
    }

    public String addplayer(String nombre) {
        if (Game.getCantJugadores() != Game.getJugadores().size()) {
            ArrayList<Player> jugadores = Game.getJugadores();
            for (Player jugador : jugadores) {
                if (jugador.getNombre().equals(nombre)) {
                    return "-1";
                }
            }
            Player player = new Player(nombre, 0, new ArrayList<Card>());
            Game.getJugadores().add(player);
            return nombre;
        } else {
            System.out.println("No se pueden agregar mas jugadores a esta partida!");
            return "0";
        }
    }

    public void jugar(int respuesta) {
        return;
    }
    
    public String visualizar_Elementos(){
        String output = "";
        for (String elemento : Game.getCardsSet().getElements()){
            output = output.concat(elemento);
        }
        return output;
    }
    
    public String visualizar_Jugadores(){
        String output = "";
        for (Player jugador : Game.getJugadores()){
            output = output.concat(jugador.getNombre() + " Score: " + jugador.getScore() + "\n");
        }
        return output;
    }
    
    public String visualizar_Mazo(){
        String output = "";
        output = output.concat("Mazo: \n");
        for (Card carta : Game.getCardsSet().getCards()) {
            output = output.concat("Carta: (");
            for (String elemento : carta.getElements()) {
                output = output.concat(elemento + " ");
            }
            output = output.concat(")\n");
        }
        return output;
    }

    /*
    public void visualizar_estado() {
        String output = "";
        output = output.concat("Jugadores actuales: ");
        for (Player jugador : Game.getJugadores()) {
            output = output.concat(jugador.getNombre() + " Score: " + jugador.getScore() + "\n");
        }
        output = output.concat("\n");
        output = output.concat("Mazo: \n");
        for (Card carta : Game.getCardsSet().getCards()) {
            output = output.concat("Carta: (");
            for (String elemento : carta.getElements()) {
                output = output.concat(elemento + " ");
            }
            output = output.concat(")\n");
        }
        System.out.println(output);
    }
*/
    public boolean dobbleCheck() {
        return Game.dobbleCheck();
    }
}
