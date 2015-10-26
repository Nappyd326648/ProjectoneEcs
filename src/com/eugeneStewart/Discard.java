package com.eugeneStewart;

import java.util.LinkedList;

/**
 * Created by Eugene on 10/22/2015.
 */
public class Discard extends Deck{
    LinkedList<Card> enddeck;

    public Discard(){
       enddeck = new LinkedList<Card>();


    }

    public void addCard(Card c) {
        enddeck.add(c);
    }

    public Card topCard() {
        //if (Startdeck != null) {
        return enddeck.getLast();
        //if (enddeck== null)
    }
    public Boolean isPlayable(Card c){
        Card n =enddeck.getLast();
        if (c.suit.equals(n.suit) || c.value.equals(n.value)||c.value.equals("8")){
            return true;
        }
        else
        {
            return false;
        }

    }
    public int size() {
        return enddeck.size();
    }
    public LinkedList<Card> removeall(){
        return enddeck;
    }

}
