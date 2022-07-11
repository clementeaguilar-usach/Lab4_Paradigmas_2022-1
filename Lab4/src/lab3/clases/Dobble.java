/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.clases;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Dobble corresponde a la clase que representa el mazo de cartas Dobble.
 * 
 * Sus atributos son:
 * cards: Lista de cartas del mazo
 * maxC: Entero representando el tamaño del mazo.
 * numE: Entero representando el número de elementos por carta.
 * elements: Lista de strings que contiene los elementos presentes en el mazo Dobble
 */
public class Dobble {
    private ArrayList<Card> cards;
    private int maxC;
    private int numE;
    private ArrayList<String> elements;
    
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public Dobble(ArrayList<String> elements) {
        this.elements = elements;
    }

    public int getmaxC() {
        return maxC;
    }
    
    public int getnumE() {
        return numE;
    }

    public void setmaxC(int maxC) {
        this.maxC = maxC;
    }
    
    public void setnumE(int numE) {
        this.numE = numE;
    }

    public Dobble(){
        this.maxC = 0;
        this.numE = 0;
        this.cards = new ArrayList<Card>();
        this.elements = new ArrayList<String>();
    }

    /**
     * Dobble constructor de mazo Dobble en base a los parametros numero de
     * elementos por carta, cantidad maxima de cartas del mazo, lista de Strings
     * con elementos. Usa la fórmula n^2 + n + 1 para generar las cartas. Si
     * se escogió un maxC distinto a -1 y 0, se corta el mazo hasta el tamanio
     * deseado.
     * @param numE Entero, número de elementos
     * @param maxC Entero, máximo de cartas en un mazo
     * @param Elements Lista de strings con elementos.
     */
    public Dobble(int numE, int maxC, ArrayList<String> Elements){
        this.maxC = maxC;
        this.numE = numE;
        Integer orden = numE - 1;
        Integer aux = (orden*orden)+ orden + 1; //=)
        ArrayList<String> elements0 = new ArrayList<String>();
        for(int e=1; e<= aux; e++){
            elements0.add(Elements.get(e)+" ");
        }
        ArrayList<Card> mazo = new ArrayList<Card>();
        ArrayList<String> elements2 = new ArrayList<String>();

        for (int i = 1; i <= numE; i++) {
            elements2.add(Elements.get(i));
        }
        mazo.add(new Card(new ArrayList<String>(elements2)));
        
        for (int j=1; j <= orden; j++) {
            elements2.clear();
            elements2.add(Elements.get(1));
            
            for (int k=1; k <= orden; k++) {
                elements2.add(Elements.get(orden * j + (k+1)));
            }
            mazo.add(new Card(new ArrayList<String>(elements2)));
        }
        
        for (int i= 1; i <= orden; i++) {
            for (int j=1; j <= orden; j++) {
                elements2.clear();
                elements2.add(Elements.get(i+1));
                
                for (int k=1; k <= orden; k++) {
                    elements2.add(Elements.get(orden+2+orden*(k-1)+(((i-1)*(k-1)+j-1)%(orden))));
                }
                mazo.add(new Card(new ArrayList<String>(elements2)));
            }
        }
        if(maxC != -1 && maxC != 0){
            for(int i = 0; i < aux - maxC; i++){
                elements0.remove(0);
            }
        }
        this.elements = elements0;
        Collections.shuffle(mazo);
        
        if(maxC != -1 && maxC != 0){
            for(int i = 0; i < aux - maxC; i++){
                mazo.remove(0);
            }
        }
        this.maxC = mazo.size();
        this.cards = mazo;
        System.out.println("Mazo creado con exito.");
    }
    
    /**
     * OnlyOneCommon función encargada de encontrar un elemento en común entre
     * todos los pares de cartas del mazo.
     * @return 
     */
    public boolean OnlyOneCommon(){
        for(Card carta : cards){
            for(int i = 0; i < carta.getElements().size(); i++){
                for(Card carta2 : cards){
                    if(carta != carta2){
                        if(carta2.getElements().contains(carta.getElements().get(i))){
                            for(int k = 0; k < carta.getElements().size(); k++){
                                if(k != i){
                                    if(carta2.getElements().contains(carta.getElements().get(k))){
                                        return false;
                                    }
                                } 
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * dobbleCheck Llama a la funcion OnlyOneCommon.
     * @return 
     */
    public boolean dobbleCheck(){
        return OnlyOneCommon();
    }
}
