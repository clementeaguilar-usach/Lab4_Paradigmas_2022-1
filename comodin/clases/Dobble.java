/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 * Dobble corresponde a la clase que representa el mazo de cartas Dobble.
 * 
 * Sus atributos son:
 * cards: Lista de cartas del mazo
 */
public class Dobble {
    private ArrayList<Card> cards;
    private int tamanio;
    private int num_e;
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

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public Dobble(int tamanio, int num_e){
        this.tamanio = tamanio;
        this.num_e = num_e;
        this.cards = new ArrayList<Card>();
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<String> elements2 = new ArrayList<>();

        ArrayList<String> elements = new ArrayList<>(
                        Arrays.asList("-", "Leon", "Conejo", "Leopardo", "Oso", "Aguila", "Serpiente",
                              "Zorro", "Loro", "Puma", "Tigre", "Escorpion", "Capibara",
                              "Jaguar", "Avestruz", "Jirafa", "Elefante", "Rinoceronte", "Ballena",
                              "Mono", "Chimpance", "Gorila", "Nandu", "Pudu", "Alce",
                              "Hipopotamo", "Coyote", "Venado", "Antilope", "Tucan", "Caballo",
                              "Pinguino"));

        //to start, we build the first card
        for (int i = 1; i <= num_e; i++) {
            elements2.add(elements.get(i));
        }
        Collections.shuffle(elements2);
        cards.add(new Card(new ArrayList<String>(elements2)));
        
        //we build the rest of the cards
        for (int j=1; j <= num_e-1; j++) {
            elements2.clear();
            elements2.add(elements.get(1));
            
            for (int k=1; k <= num_e-1; k++) {
                elements2.add(elements.get((num_e-1) * j + (k+1)));
            }    
            Collections.shuffle(elements2);
            cards.add(new Card(new ArrayList<String>(elements2)));
        }
        
        for (int i= 1; i <= num_e-1; i++) {
            for (int j=1; j <= num_e-1; j++) {
                elements2.clear();
                elements2.add(elements.get(i+1));
                
                for (int k=1; k <= num_e-1; k++) {
                    elements2.add(elements.get((num_e-1)+2+(num_e-1)*(k-1)+(((i-1)*(k-1)+j-1)%(num_e-1))));
                }
                Collections.shuffle(elements2);
                cards.add(new Card(new ArrayList<String>(elements2)));
            }
        }
        
        if(tamanio != -1 && tamanio != 0){
            for(int i = 0; i < tamanio; i++){
                this.cards.add(cards.get(i));
            }
            this.tamanio = this.cards.size();
        }
        else{
            this.cards = cards;
            this.tamanio = this.cards.size();
        }
        
    }
    public Dobble() {
        this.cards = new ArrayList<>();
        this.tamanio = 0;
    }
    
    public boolean OnlyOneCommon(){
        int cont = 0;
        for(Card carta : cards){
            for(String elemento : carta.getElements()){
                for(Card carta2 : cards){
                    if(carta2.getElements().contains(elemento)){
                        cont++;
                    }
                }
                if(cont == num_e){
                    cont = 0;
                }
                else{
                    return false;
                }

            }
        }
        return true;
    }

    public boolean dobbleCheck(){
        return OnlyOneCommon();
    }
}
