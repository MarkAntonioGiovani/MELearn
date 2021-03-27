package com.example.melearn.logic;

public class Card {

    private final String front;
    private final String back;
    private int score = 0;

    public Card(String front, String back){
        this.front = front;
        this.back = back;
    }

    public String getFront(){
        return this.front;
    }

    public String getBack(){
        return this.back;
    }

    public void increaseScore(int increment){
        this.score += increment;
    }
}
