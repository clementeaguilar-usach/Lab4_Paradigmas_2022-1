/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import clases.*;

/**
 *
 * @author CLEMENTE SOY YO
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
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public void crear_juego(int cantidad, int tamanio, int num_e, int modo) {
        if(cantidad <= 0){
            System.out.println("No se puede crear un juego con 0 jugadores");
            return;
        }
        if(tamanio < -1){
            System.out.println("El tamaño debe ser mayor o igual que -1.");
            return;
        }
        if(tamanio > 31){
            System.out.println("El tamaño sobrepasa el máximo de elementos.");
            return;
        }
        if(modo <= 0){
            System.out.println("No se puede crear un juego sin su modo");
            return;
        }
        Dobble dobble = new Dobble(tamanio, num_e);
        Game.setCantJugadores(cantidad);
        Game.setCardsSet(dobble);
        Game.setModoJuego(modo);
        System.out.println(Game.getCardsSet());
        return;
    }

    public void addplayer(String nombre) {
        ArrayList<Player> jugadores = Game.getJugadores();
        for (Player jugador : jugadores) {
            if(jugador.getNombre().equals(nombre)){
                System.out.println("Jugador ya se encuentra dentro del juego.");
                return;
            }
        }
        Player player = new Player(nombre, 0);
        Game.getJugadores().add(player);
        System.out.println("Jugador ingresado. Jugadores actuales:");
        for (Player jugador : jugadores) {
                System.out.println(jugador.getNombre());
            }
    }

    public void jugar(int respuesta) {
        return;
    }

    public void visualizar_estado(int respuesta){
        return;
    }

    public boolean dobbleCheck(){
        return Game.dobbleCheck();
    }
}