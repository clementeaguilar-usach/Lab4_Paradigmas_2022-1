/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_fuente;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Card corresponde a la clase que representa a cada carta que será parte
 * de un mazo de Dobble.
 * 
 * Sus atributos son:
 * elements: Strings que representan cada elemento dentro de una carta
 *          de dobble
 */
public class Card {
    private ArrayList<String> elements;

    @Override
    public String toString() {
        return "Card{" + "elements=" + elements + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.elements);
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
        final Card other = (Card) obj;
        return Objects.equals(this.elements, other.elements);
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public Card(ArrayList<String> elements) {
        this.elements = elements;
    }
}
