package com.eugeneStewart;

import java.util.LinkedList;

/**
 * Created by in0418gq on 10/21/2015.
 */
public class Player {
    int score;
    String name;
    Hand hand;

   public Player(String n, int score, Hand h){
       this.name = n;
       this.score = score;
       this.hand=h;
   }
}
