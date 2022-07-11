/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.clases;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * Player corresponde a la clase que representa a cada jugador
 * de Dobble.
 * 
 * Sus atributos son:
 * nombre: Nombre del jugador
 * score: Puntaje del jugador
 */
public class Player {
    private String nombre;
    private int score;
    private ArrayList<Card> stack;

    public Player(String nombre, int score, ArrayList<Card> stack) {
        this.nombre = nombre;
        this.score = score;
        this.stack = stack;
    }

    public String getNombre() {
        return nombre;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack = stack;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + this.score;
        hash = 37 * hash + Objects.hashCode(this.stack);
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
        final Player other = (Player) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.stack, other.stack);
    }

    @Override
    public String toString() {
        return "Player{" + "nombre=" + nombre + ", score=" + score + ", stack=" + stack + '}';
    }  
}