/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.clases;
import java.util.ArrayList;
import java.util.Objects;

/**
 * DobbleGame corresponde a la clase que representa un juego
 * de Dobble.
 * 
 * Sus atributos son:
 * cantJugadores: n�mero de jugadores actuales en el juego
 * jugadorActual: nombre del jugador actuando en el turno actual
 * modoJuego: valor correspondiente al modo de juego que se est� jugando
 */
public class DobbleGame {
    private int cantJugadores;
    private String jugadorActual;
    private int modoJuego;
    private ArrayList<Player> jugadores;
    private Dobble cardsSet;

    @Override
    public String toString() {
        return "DobbleGame{" + "cantJugadores=" + cantJugadores + ", jugadorActual=" + jugadorActual + ", modoJuego=" + modoJuego + ", jugadores=" + jugadores + ", cardsSet=" + cardsSet + '}';
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

    public void setjugadorActual(String jugadorActual) {
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

    public String getjugadorActual() {
        return jugadorActual;
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

    public boolean dobbleCheck(){
        return cardsSet.dobbleCheck();
    }

    public DobbleGame(int cantJugadores, String jugadorActual, int modoJuego, ArrayList<Player> jugadores, Dobble cardsSet) {
        this.cantJugadores = cantJugadores;
        this.jugadorActual = jugadorActual;
        this.modoJuego = modoJuego;
        this.jugadores = jugadores;
        this.cardsSet = cardsSet;
    }
    
    public DobbleGame() {
        this.cantJugadores = 0;
        this.jugadorActual = "";
        this.modoJuego = 0;
        this.jugadores = new ArrayList<Player>();
        this.cardsSet = new Dobble();
    }
    
}
