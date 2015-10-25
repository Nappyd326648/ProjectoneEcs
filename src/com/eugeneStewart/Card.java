package com.eugeneStewart;

import java.util.ArrayList;

/**
 * Created by Eugene on 10/13/2015.
 */
public class Card {


        String suit;
        String color;
        String value;

        public Card(String s, String c, String v) {
            this.suit=s;
            this.color=c;
            this.value=v;
        }


        public String toString(){
            return   "Suit= " + suit + " value = " + value + " color= " + color ;
        }


    }
