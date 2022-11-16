/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Dobble corresponde a la clase que representa el mazo de cartas Dobble.
 * 
 * Sus atributos son:
 * cards: Lista de cartas del mazo
 * maxC: Entero representando el tamanio del mazo.
 * numE: Entero representando el numero de elementos por carta.
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

    public void setElements(ArrayList<String> elements){
        this.elements = elements;
    }

    public ArrayList<String> getElements(){
        return elements;
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
    }

    /**
     * getTopTwoCards obtiene el primer par de cartas de un mazo Dobble si
     * quedan pares de cartas por sacar (maxC >= 2). Actualiza cards y maxC.
     * @return
     */
    public ArrayList<Card> getTopTwoCards(){
        ArrayList<Card> topTwoCards = new ArrayList<Card>();
        if(this.maxC >= 2){
            topTwoCards.add(this.cards.get(0));
            topTwoCards.add(this.cards.get(1));
        }
        return topTwoCards;
    }

    /**
     * removeTopTwoCards elimina del mazo las primeras 2 cartas, reduce su tamaño y comunica la acción.
     */
    public void removeTopTwoCards(){
        this.cards.remove(0);
        this.cards.remove(0);
        this.maxC = this.maxC - 2;
        System.out.println("Se quitaron 2 cartas, quedan "+this.maxC+"\n");
    }

    /**
     * Dobble constructor de mazo Dobble en base a los parametros numero de
     * elementos por carta, cantidad maxima de cartas del mazo, lista de Strings
     * con elementos. Usa la formula n^2 + n + 1 (n = numE - 1) para generar las cartas. Si
     * se escogio un maxC distinto a -1 y 0, se corta el mazo hasta el tamanio
     * deseado.
     * @param numE Entero, numero de elementos
     * @param maxC Entero, maximo de cartas en un mazo
     * @param Elements Lista de strings con elementos.
     */
    public Dobble(int numE, int maxC, ArrayList<String> Elements){
        this.maxC = maxC;
        this.numE = numE;
        Integer orden = numE - 1;
        Integer aux = (orden*orden)+orden+1;
        ArrayList<String> elements0 = new ArrayList<String>();
        for(int e=1; e<= aux; e++){
            elements0.add(Elements.get(e)+ "");
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

        this.elements = elements0;
        Collections.shuffle(mazo);

        if(maxC != -1 && maxC != 0){
            for(int i = aux-1; i >= maxC; i--){
                mazo.remove(i);
            }
            this.cards = mazo;
        }
        else{
            this.cards = mazo;
        }
        this.maxC = this.cards.size();
    }
    
    /**
     * OnlyOneCommon metodo encargado de encontrar un elemento en comun entre
     * todos los pares de cartas del mazo.
     * @return true o false
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
     * @return true o false
     */
    public boolean dobbleCheck(){
        return OnlyOneCommon();
    }
}
