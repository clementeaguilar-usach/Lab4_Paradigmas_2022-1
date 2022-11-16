/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Card corresponde a la clase que representa a cada carta que ser� parte
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.elements);
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

    /**
     * mostrarCarta imprime por pantalla los elementos de una carta
     * @return output: String con el formato de la carta (elem1 elem2... elemn).
     */
    public String mostrarCarta(){
        String output = "( ";
        for(String elemento : elements){
            output = output.concat(elemento + " ");
        }
        output = output.concat(")");
        return output;
    }
}
