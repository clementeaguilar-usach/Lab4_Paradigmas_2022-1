/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.clases;
import java.util.ArrayList;

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
