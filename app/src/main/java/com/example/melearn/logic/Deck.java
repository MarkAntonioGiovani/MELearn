package com.example.melearn.logic;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private String name;
    private String description;

    public Deck(String name, String description){
        this.name = name;
        this.description = description;
        this.cards = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(String front, String back) {
        this.cards.add(new Card(front, back));
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

}
