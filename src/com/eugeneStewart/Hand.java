package com.eugeneStewart;

import java.util.LinkedList;

/**
 * Created by in0418gq on 10/21/2015.
 */
public class Hand {
    LinkedList<Card> inHand;
    public Hand(){
        //constructor
        // initialize inHand list
        inHand = new LinkedList<Card>();
    }
    void addCard(Card c){
        inHand.add(c);

    }
public void printHand(){
    System.out.println();
    System.out.println("Your hand");
    int n=0;
    for (int x = 0; x < this.inHand.size(); x++){
        System.out.println(x+". "+ this.inHand.get(x));
        n=x;
    }
    System.out.println(n+1+". To draw a card");

}

public int size(){
    return this.inHand.size();
}

    public void removeCard(Card c) {
        inHand.remove(c);
    }

public Card playable(int answer){

    return inHand.get(answer) ;

}

}
