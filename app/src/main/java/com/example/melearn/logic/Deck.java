package com.example.melearn.logic;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private String title;
    private String description;

    public Deck(String title, String description){
        this.title = title;
        this.description = description;
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards(){
        return this.cards;
    }

    public void addCard(String front, String back){
        this.cards.add(new Card(front, back));
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }
}
