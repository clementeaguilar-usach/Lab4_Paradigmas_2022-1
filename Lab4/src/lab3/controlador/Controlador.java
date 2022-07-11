/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.controlador;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import lab3.clases.*;

/**
 *
 * @author CLEMENTE
 */
public class Controlador {

    private DobbleGame Game;

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

    public void crear_juego(int cantidad, int maxC, int numE, int modo, ArrayList<String> Elements) {
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
        Dobble dobble = new Dobble(numE, maxC, Elements);
        Game.setCantJugadores(cantidad);
        Game.setCardsSet(dobble);
        Game.setModoJuego(modo);
        return;
    }

    public void addplayer(String nombre) {
        if (Game.getCantJugadores() != Game.getJugadores().size()) {
            ArrayList<Player> jugadores = Game.getJugadores();
            for (Player jugador : jugadores) {
                if (jugador.getNombre().equals(nombre)) {
                    System.out.println("Jugador ya se encuentra dentro del juego.");
                    return;
                }
            }
            Player player = new Player(nombre, 0);
            Game.getJugadores().add(player);
            System.out.println("Jugador ingresado.");
        } else {
            System.out.println("No se pueden agregar mas jugadores a esta partida!");
        }
    }

    public void jugar(int respuesta) {
        return;
    }

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

    public boolean dobbleCheck() {
        return Game.dobbleCheck();
    }
}
