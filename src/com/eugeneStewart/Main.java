package com.eugeneStewart;

import java.io.PrintStream;
import java.lang.System;
import java.util.Scanner;

import static sun.text.normalizer.UTF16.append;

public class Main {

    public static void main(String[] args) {
        int answer;
        System.out.println("Welcome to Crazy Eights \n Here Are the rules the special cards two makes the opponent draw two \n the eight card is wild. \n drawing a card loses a turn. \n to choose a card enter a number.");
        Deck d = new Deck();
        Card played = new Card("spade", "i", "i");
        Human h = new Human(0, new Hand());
        Computer c = new Computer(0, new Hand());
        Scanner s = new Scanner(System.in);
        boolean endTurn= false;
        Discard k = new Discard();
        for (int x = 0; x != 14; x++) {
            if (x == 1 || x == 3 || x == 5 || x == 7 || x == 9 || x == 11 || x == 13) {
                c.hand.addCard(d.drawCard());
            } else {

                h.hand.addCard(d.drawCard());
            }

        }

        k.addCard(d.drawCard());
        while (!gameover(c.hand.size(),h.hand.size())) {
            System.out.println(c.name+" has " + c.hand.size()+ "cards" );
            h.hand.printHand();
            System.out.println("the top card is " + k.topCard());
            answer = s.nextInt();

            if (answer == h.hand.size()) {
                h.hand.addCard(d.drawCard());
                endTurn = true;
            } else {
                played = h.hand.playable(answer);
                h.hand.removeCard(played);
                if(k.isPlayable(played)) {
                    k.addCard(played);
                    endTurn = true;
                }
                else {
                    h.hand.addCard(played);
                    System.out.println("that is not a playable card Try again");
                }

            }
            while (endTurn == true) {
                c.getTopcard(k.topCard());

            endTurn = false;
            }


            //}
            c.hand.removeCard(played);
            k.addCard(played);


        }
    }
    private static boolean gameover(int c, int h)
    {
        if (c == 0)
            System.out.println("Johnny Walker is out of cards \n"+ "Johnny Walker Wins");
        else if (h  == 0)
            System.out.println("You got rid of all your cards! You Won!\n");
        return (c == 0|| h  == 0);
    }
}
