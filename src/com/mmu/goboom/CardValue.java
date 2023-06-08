package com.mmu.goboom;

public enum CardValue {
    c2('c', 2), d2('d', 2), h2('h', 2), s2('s', 2),     // assigning numeric values to each card according to their suits and value.
    c3('c', 3), d3('d', 3), h3('h', 3), s3('s', 3),
    c4('c', 4), d4('d', 4), h4('h', 4), s4('s', 4),
    c5('c', 5), d5('d', 5), h5('h', 5), s5('s', 5),
    c6('c', 6), d6('d', 6), h6('h', 6), s6('s', 6),
    c7('c', 7), d7('d', 7), h7('h', 7), s7('s', 7),
    c8('c', 8), d8('d', 8), h8('h', 8), s8('s', 8),
    c9('c', 9), d9('d', 9), h9('h', 9), s9('s', 9),
    c10('c', 10), d10('d', 10), h10('h', 10), s10('s', 10),
    cJ('c', 11), dJ('d', 11), hJ('h', 11), sJ('s', 11),
    cQ('c', 12), dQ('d', 12), hQ('h', 12), sQ('s', 12),
    cK('c', 13), dK('d', 13), hK('h', 13), sK('s', 13),
    cA('c', 14), dA('d', 14), hA('h', 14), sA('s', 14);

    private char cardSuit;
    private int cardValue;

    private CardValue(char suit, int value) {
        this.cardValue = value;
        this.cardSuit = suit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public char getCardSuit() {
        return cardSuit;
    }

    @Override
    public String toString() {
        String cardString;
        switch (cardValue) {
            case 11:
                cardString = "J";
                break;
            case 12:
                cardString = "Q";
                break;
            case 13:
                cardString = "K";
                break;
            case 14:
                cardString = "A";
                break;
            default:
                cardString = Integer.toString(cardValue);
                break;
        }
        return cardSuit + cardString;
    }
}