/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_fuente;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Dobble corresponde a la clase que representa el mazo de cartas Dobble.
 * 
 * Sus atributos son:
 * cards: Lista de cartas del mazo
 */
public class Dobble {
    private ArrayList<Card> cards;

    @Override
    public String toString() {
        return "Dobble{" + "cards=" + cards + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.cards);
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
        final Dobble other = (Dobble) obj;
        return Objects.equals(this.cards, other.cards);
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Dobble(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
