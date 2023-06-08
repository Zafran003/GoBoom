package com.mmu.goboom;
import java.util.Objects;

public class Card {
    private CardValue suit;
    private CardValue value;

    public Card() {

    }
    
    public Card(CardValue suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    // Getters, setters, and other methods for the Card class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public CardValue getValue(){
        return value;
    }

    public CardValue getSuit(){
        return suit;
    }
}