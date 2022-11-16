/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import clases.*;

/**
 *
 * @author cleme
 * Controlador corresponde a la clase responsable de interactuar los
 * metodos de las otras clases con la interfaz gráfica.
 * 
 * Sus atributos son:
 * Game: Juego de Dobble.
 */
public class Controlador {

    private DobbleGame Game;

    public Controlador() {
        Game = new DobbleGame();
    }

    public DobbleGame getGame() {
        return Game;
    }

    public void setGame(DobbleGame Game) {
        this.Game = Game;
    }

    /**
     * esPrimo verifica que un numero n sea primo.
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
     * @param numE Entero, numero de elementos por carta.
     * @param modo Entero, representa el modo de juego que se desea jugar.
     */
    public void crear_juego(int cantidad, int maxC, int numE, int modo, ArrayList<String> Elements) {
        if (cantidad <= 1 || cantidad > 8) {
            System.out.println("Un juego debe tener entre 2 y 8 jugadores.");
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
        if (numE <= 1){
            System.out.println("No se pueden crear cartas con menos de 2 elementos");
            return;
        }
        Dobble dobble = new Dobble(numE, maxC, Elements);
        Game.setCantJugadores(cantidad);
        Game.setCardsSet(dobble);
        Game.setModoJuego(modo);
        return;
    }

    /**
     * addplayer Agrega un jugador a la lista de jugadores del juego.
     * @param nombre String, nombre del jugador a ingresar.
     */
    public void addplayer(String nombre) {
        if (Game.getCantJugadores() != Game.getJugadores().size()) {
            ArrayList<Player> jugadores = Game.getJugadores();
            for (Player jugador : jugadores) {
                if (jugador.getNombre().equals(nombre)){
                    System.out.println("Jugador ya se encuentra dentro del juego!\n");
                    return;
                }
            }
            Player player = new Player(nombre, 0, new ArrayList<Card>());
            if (Game.getJugadores().size() == 0){
                Game.setjugadorActual(player);
                System.out.println(player.getNombre()+" sera el primer jugador!\n");
            }
            Game.getJugadores().add(player);
            System.out.println("Jugador ingresado!\n");
        }
        else {
            System.out.println("No se pueden agregar mas jugadores a esta partida!\n");
        }
    }

    /**
     * visualizar_Elementos imprime los elementos de un cardsSet.
     */
    public void visualizar_Elementos(){
        String output = "";
        for (String elemento : Game.getCardsSet().getElements()){
            output = output.concat(elemento+" ");
        }
        System.out.println(output);
    }

    /**
     * visualizar_Jugadores imprime los jugadores del juego.
     */
    public void visualizar_Jugadores(){
        String output = "";
        for (int i= 0; i< Game.getJugadores().size(); i++){
            output = output.concat(Game.getJugadores().get(i).getNombre()+ " ("+(i+1)+") "+" Score: "+Game.getJugadores().get(i).getScore()+"\n");
        }
        System.out.println(output+")\n");
    }

    /**
     * visualizar_Mazo muestra las cartas del mazo de un juego de Dobble.
     */
    public void visualizar_Mazo(){
        String output = "";
        output = output.concat("Mazo: " + Game.getCardsSet().getmaxC() +" cartas restantes.\n");
        for (Card carta : Game.getCardsSet().getCards()){
            output = output.concat("Carta: (");
            for (String elemento : carta.getElements()){
                output = output.concat(elemento + " ");
            }
            output = output.concat(")\n");
        }
        System.out.println(output);
    }

    /**
     * visualizar_estado Imprime el estado del juego.
     */
    public void visualizar_estado(){
        System.out.println("Juego actual:\n Jugadores: (");
        visualizar_Jugadores();
        visualizar_Mazo();
        System.out.println("Elementos posibles del juego:");
        visualizar_Elementos();
    }

    public void visualizar_JugadorActual(){
        System.out.println("####Es el turno de: "+Game.getjugadorActualString()+"####\n");
    }

    /**
     * jugar llama al metodo play de la clase Game.
     * @param input entero pasado por pantalla. Representa al jugador que recibe puntaje.
     */
    public int jugar(String input){
        int flag2;
        flag2 = Game.play(input);
        if(flag2 == 1){
            System.out.println("Elemento encontrado! Ganaste 2 puntos!\n");
        }
        else if(flag2 == 0){
            Game.nextJugador();
            System.out.println("Elemento incorrecto! Siguiente turno!\n");
        }
        else if(flag2 == 3){
            Game.nextJugador();
            System.out.println("Turno saltado!\n");
        }
        return flag2;
    
    }

    /**
     * DosCartasAlTablero llama a la funcion sig2Cartas
     */
    public void DosCartasAlTablero(){
        Game.sig2Cartas();
    }

    /**
     * tablero llama al metodo mostrarTablero de la clase Game.
     */
    public void tablero(){
        Game.mostrarTablero();
    }

    /**
     * sacar2Cartas llama a la funcion sacar2Cartas
     */
    public void sacar2Cartas(){
        Game.sacar2Cartas();
    }

    /**
     * deckSize llama a la funcion deckSize
     * @return maxC tamaño del mazo
     */
    public int deckSize(){
        return Game.deckSize();
    }

    /**
     * ganadores imprime los ganadores calculados en obtenerGanadores
     * @return output String con los ganadores del juego
     */
    public String ganadores(){
        String output = "";
        for(Player ganador : Game.obtenerGanadores()){
            output = output.concat(ganador.getNombre()+" ");
        }
        return output;
    }

    /**
     * dobbleCheck llama al metodo dobbleCheck para verificar que un mazo
     * sea apto para jugar Dobble.
     * @return true o false
     */
    public boolean dobbleCheck() {
        return Game.dobbleCheck();
    }
}
