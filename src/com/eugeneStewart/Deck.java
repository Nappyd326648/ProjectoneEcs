package com.eugeneStewart;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Eugene on 10/12/2015.
 */
public class Deck {

    LinkedList<Card> Startdeck;
    static final char Club = '\u2663';
    static final char Diamonds = '\u2666';
    static final char Hearts = '\u2665';
    static final char Spades = '\u2660';
    String club ="Club";
    String diamond="Diamonds";
    String heart= "Hearts";
    String spade ="Spades";
    String[] suits = {club, diamond, heart, spade};

    String[] values = {"A", "2" , "3" , "4","5", "6" , "7" , "8","9", "10" ,"J","Q","K"};

            public Deck(){
                Startdeck = new LinkedList<Card>();

                for (String suit : suits) {

                    for (String value : values) {

                        String color;
                        if ( suit == diamond || suit == heart) {
                            color = "\u001B[30m";
                        } else {
                            color = "black";
                        }

                        Card newCard = new Card(suit, color, value);

                        Startdeck.add(newCard);

                    }

                }


                Collections.shuffle(Startdeck);


            }


    public Card drawCard(){
        //if (Startdeck != null) {
            return Startdeck.pop();
     //  }
        //if (Startdeck
        //Startdeck=removeall
        //What happens if the deck is empty??

    //}
            }
}



