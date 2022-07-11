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
     * Constructor de DobbleGame para el controlador.
     */
    public Controlador() {
        Game = new DobbleGame();
    }

    /**
     *
     * 
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

    /**
     * esPrimo verifica que un número n sea primo.
     * 
     * @param n Entero a evaluar
     * @return true o false
     */
    public boolean esPrimo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * crear_juego construye un juego de Dobble con Mazo, Jugadores, Modo de juego
     * y sus atributos.
     * @param cantidad Entero, representa la cantidad de jugadores.
     * @param maxC Entero, total de cartas del mazo.
     * @param numE Entero, número de elementos por carta.
     * @param modo Entero, representa el modo de juego que se desea jugar.
     */
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

    /**
     * addplayer Agrega un jugador a la lista de jugadores del juego. Retorna 0
     * y -1 frente a salidas fallidas.
     * @param nombre String, nombre del jugador a ingresar.
     * @return String
     */
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
    
    /**
     * visualizar_Elementos muestra los elementos de un juego de Dobble.
     * @return String output
     */
    public String visualizar_Elementos(){
        String output = "";
        for (String elemento : Game.getCardsSet().getElements()){
            output = output.concat(elemento);
        }
        return output;
    }
    
    /**
     * visualizar_Jugadores muestra los jugadores de un juego de Dobble.
     * @return String output
     */
    public String visualizar_Jugadores(){
        String output = "";
        for (Player jugador : Game.getJugadores()){
            output = output.concat(jugador.getNombre() + " Score: " + jugador.getScore() + "\n");
        }
        return output;
    }
    
    /**
     * visualizar_Mazo muestra las cartas del mazo de un juego de Dobble.
     * @return String output
     */
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

    /**
     * dobbleCheck llama al método dobbleCheck para verificar que un mazo
     * sea apto para jugar Dobble.
     * @return true o false
     */
    public boolean dobbleCheck() {
        return Game.dobbleCheck();
    }
}
