import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck; // declare array

    public Deck(){
        this.deck = new ArrayList<>(); //this will initialize deck variable with an empty array
        
        for (CardValue value : CardValue.values()) {  
            for (int j = 0; j < 4; j++) {
                Card card = new Card(value, value);            
                if (!deck.contains(card)) {             // so this loop adds all the 52 cards into the empty array  
                    this.deck.add(card);                
                }
            }
        }
        Collections.shuffle(deck); // shuffles the deck in the array
    }

    public String toString(){    //toString Method 
        return "Deck    : " + deck;
    }

    public Card getCard(int i) { //getCard method 
        return deck.get(i);
    }

    public void removeCard(int i) { //Used to remove the card
        deck.remove(i); 
        
    }
    public int getDeckSize() {
        return deck.size();
    }
}