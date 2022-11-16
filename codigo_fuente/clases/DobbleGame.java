/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

/**
 * DobbleGame corresponde a la clase que representa un juego
 * de Dobble.
 * 
 * Sus atributos son:
 * cantJugadores: Entero representando el numero de jugadores actuales en el juego.
 * jugadorActual: Variable de tipo Player, que representa al jugador actuando en el turno actual.
 * modoJuego: Valor correspondiente al modo de juego que se esta jugando.
 * jugadores: Lista de jugadores dentro de la partida.
 * cardsSet: Mazo de Dobble con el que se juega.
 * tablero: Lista de Cartas que abstrae el tablero de juego.
 */
public class DobbleGame {
    private int cantJugadores;
    private Player jugadorActual;
    private int modoJuego;
    private ArrayList<Player> jugadores;
    private Dobble cardsSet;
    private ArrayList<Card> tablero;

    @Override
    public String toString() {
        return "DobbleGame{" + "cantJugadores=" + cantJugadores + ", jugadorActual=" + jugadorActual + ", modoJuego=" + modoJuego + ", jugadores=" + jugadores + ", cardsSet=" + cardsSet + '}';
    }

    public void setTablero(ArrayList<Card> tablero){
        this.tablero = tablero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DobbleGame other = (DobbleGame) obj;
        if (this.cantJugadores != other.cantJugadores) {
            return false;
        }
        if (this.modoJuego != other.modoJuego) {
            return false;
        }
        if (!Objects.equals(this.jugadorActual, other.jugadorActual)) {
            return false;
        }
        if (!Objects.equals(this.jugadores, other.jugadores)) {
            return false;
        }
        return Objects.equals(this.cardsSet, other.cardsSet);
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public void setjugadorActual(Player jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void setModoJuego(int modoJuego) {
        this.modoJuego = modoJuego;
    }

    public void setJugadores(ArrayList<Player> jugadores) {
        this.jugadores = jugadores;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public Player getjugadorActual() {
        return jugadorActual;
    }

    public String getjugadorActualString(){
        return jugadorActual.getNombre();
    }

    public int getModoJuego() {
        return modoJuego;
    }

    public ArrayList<Player> getJugadores() {
        return jugadores;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    /**
     * dobbleCheck llama a la funcion dobbleCheck del mazo.
     * @return true o false
     */
    public boolean dobbleCheck(){
        return cardsSet.dobbleCheck();
    }

    public DobbleGame(int cantJugadores, Player jugadorActual, int modoJuego, ArrayList<Player> jugadores, Dobble cardsSet, ArrayList<Card> tablero) {
        this.cantJugadores = cantJugadores;
        this.jugadorActual = jugadorActual;
        this.modoJuego = modoJuego;
        this.jugadores = jugadores;
        this.cardsSet = cardsSet;
        this.tablero = tablero;
    }
    
    public DobbleGame() {
        this.cantJugadores = 0;
        this.jugadorActual = new Player();
        this.modoJuego = 0;
        this.jugadores = new ArrayList<Player>();
        this.cardsSet = new Dobble();
        this.tablero = new ArrayList<Card>();
    }

    /**
     * ElementFound verifica si respuesta (String) es el único elemento entre las cartas a disposición en el tablero.
     * @param respuesta String con el nombre de un elemento.
     * @return true o false
     */
    public boolean ElementFound(String respuesta){
        int cont = 0;
        for (Card carta : this.tablero){
            for(String elemento : carta.getElements()){
                if(respuesta.equalsIgnoreCase(elemento)){
                    cont++;
                }
            }
        }
        if(cont == 2){
            return true;
        }
        return false;
    }

    /**
     * obtenerGanadores retorna una lista con los ganadores de una partida comparando el puntaje máximo entre ellos
     * @return ganadores (lista de jugadores)
     */
    public ArrayList<Player> obtenerGanadores(){
        int score_ganador = 0;
        ArrayList<Player> ganadores = new ArrayList<Player>();
        Player ganador = new Player();
        for(Player jugador : this.jugadores){
            if(jugador.getScore() > score_ganador){
                score_ganador = jugador.getScore();
                ganador = jugador;
            }
        }
        for(Player jugador : this.jugadores){
            if(jugador.getScore() == score_ganador){
                ganadores.add(jugador);
            }
        }
        return ganadores;
    }

    /**
     * play metodo que otorga puntaje por una jugada en algun modo de juego.
     * Para modo de juego 1 "Stack", otorga 2 puntos al jugador que encontro
     * el elemento en comun entre dos cartas y le entrega 2 puntos al jugador.
     * @param respuesta
     * @return 1 cuando el jugador acierta su respuesta, 0 cuando no y 2 cuando ya no quedan cartas en el mazo.
     */
    
    public int play(String respuesta){
        if(this.modoJuego == 1){
            this.jugadores.remove(0);
            this.jugadores.add(this.jugadorActual);
            if(respuesta.equalsIgnoreCase("paso")){
                setjugadorActual(getJugadores().get(0));
                return 3;
            }
            else if (ElementFound(respuesta) == true){
                this.jugadorActual.setScore(this.jugadorActual.getScore() + 2);
                this.jugadorActual.setStack(this.tablero);
                setjugadorActual(getJugadores().get(0));
                return 1;
            }
            else{
                setjugadorActual(getJugadores().get(0));
                return 0;
            }
        }
        return 2;
    }

    /**
     * nextJugador cambia el jugadorActual al siguiente jugador
     */
    public void nextJugador(){
        this.jugadorActual = this.jugadores.get(0);
    }

    /**
     * sig2Cartas mueve las dos primeras cartas del mazo al tablero de juego
     */
    public void sig2Cartas(){
        this.tablero = cardsSet.getTopTwoCards();
    }

    /**
     * sacar2Cartas elimina las 2 primeras cartas del mazo
     */
    public void sacar2Cartas(){
        this.cardsSet.removeTopTwoCards();
    }

    /**
     * deckSize devuelve el tamaño del mazo 
     * @return maxC
     */
    public int deckSize(){
        return this.cardsSet.getmaxC();
    }

    /**
     * mostrarTablero metodo que imprime las dos cartas del tablero.
     */
    public void mostrarTablero(){
        System.out.println("Carta 1: " + this.tablero.get(0).mostrarCarta());
        System.out.println("Carta 2: "+ this.tablero.get(1).mostrarCarta());
    }
}
