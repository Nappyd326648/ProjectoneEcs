package com.eugeneStewart;

import java.util.LinkedList;

/**
 * Created by in0418gq on 10/21/2015.
 */
public class Hand {
    LinkedList<Card> inHand;

    public Hand() {
        //constructor
        // initialize inHand list
        inHand = new LinkedList<Card>();
    }

    void addCard(Card c) {
        inHand.add(c);

    }

    public void printHand() {
        System.out.println();
        System.out.println("Your hand");
        int n = 0;
        for (int x = 0; x < this.inHand.size(); x++) {
            System.out.println(x + ". " + this.inHand.get(x));
            n = x;
        }
        System.out.println(n + 1 + ". To draw a card");

    }

    public int size() {
        return this.inHand.size();
    }

    public void removeCard(Card c) {
        inHand.remove(c);
    }

    public Card playable(int answer) {

        return this.inHand.get(answer);

    }

    public void printSuit() {
        String[] suits = {"club", "diamond", "heart", "spade"};
        for (int x = 0; x < suits.length; x++) {
            System.out.println(x + ". " + suits[x]);
        }

    }

    public String suit(int answer) {
        String[] suits = {"Club", "Diamond", "Heart", "Spade"};
        return suits[answer];
    }


    public boolean lookatCard(Card played) {
        Card n = new Card("spade", "i", "i");
        for (int x = 0; x < this.inHand.size(); x++) {
            n = this.inHand.get(x);
            if (n.value == played.value) {
                return true;
            }
        }
        return false;
    }

    public Card findtwo(Card played) {
        Card n = new Card("spade", "i", "i");
        for (int x = 0; x < this.inHand.size(); x++) {
            n = this.inHand.get(x);
            if (n.value == played.value) {
                return n;
            }

        }
        return null;
    }

    public Card cPlayable(Card played) {
        Card n = new Card("spade", "i", "i");
        for (int x = 0; x < this.inHand.size(); x++) {
            n = this.inHand.get(x);
            if (n.suit == played.suit) {
                return n;
            }
            else if (n.suit == played.suit){
                return n;
            }
        }
        return null;
    }

    public Card findeight(Card played) {
        Card n = new Card("spade", "i", "i");
        for (int x = 0; x < this.inHand.size(); x++) {
            n = this.inHand.get(x);
            if (n.value == "8") {
                return n;
            }

        }
        return null;
    }

    public String newsuit() {
        int s=0;
        int c=0;
        int d=0;
        int h=0;
        Card n = new Card("spade", "i", "i");
        for (int x = 0; x < this.inHand.size(); x++) {
            n = this.inHand.get(x);
            if (n.suit.equals("Spade")){
                s++;
            }
            else if(n.suit.equals("Club")){
                c++;
            }
            else if(n.suit.equals("Diamond")){
                d++;
            }
            else if(n.suit.equals("Heart")){
                h++;
            }
        }
            if (s>c&&s>d&&s>h) {
                return "Spade";
            }
            if(c>s&&c>d&&c>h){
                return"Club";
            }
            if (d>c&&d>s&&d>h) {
            return "Diamond";
            }
            if (h>c&&h>d&&h>s) {
            return "Heart";
            }
        return null;
    }
}