/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_fuente;

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

    @Override
    public String toString() {
        return "Player{" + "nombre=" + nombre + ", score=" + score + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + this.score;
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
        return Objects.equals(this.nombre, other.nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public int getScore() {
        return score;
    }

    public Player(String nombre, int score) {
        this.nombre = nombre;
        this.score = score;
    }
}