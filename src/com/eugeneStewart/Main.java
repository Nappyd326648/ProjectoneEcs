package com.eugeneStewart;

import com.sun.javafx.fxml.ParseTraceElement;

import java.io.PrintStream;
import java.lang.System;
import java.util.Scanner;

import static sun.text.normalizer.UTF16.append;

public class Main {

    public static void main(String[] args) {
        //this stores user input
        int answer;
        //this prints instructions
        System.out.println("Welcome to Crazy Eights \n Here Are the rules the special cards two makes the opponent draw two \n the eight card is wild. \n drawing a card loses a turn. \n to choose a card enter a number.");
        //this creates a new deck
        Deck d = new Deck();
        //this is the verilable that is use to store cards that have been played, for evaluation
        Card played = new Card("spade", "i", "i");
        //this creates the user hand
        Human h = new Human(0, new Hand());
        //this creates the computers hand
        Computer c = new Computer(0, new Hand());
        //this setup away to get user input
        Scanner s = new Scanner(System.in);
        //this is how to decide whos turn it is
        boolean endTurn= false;
        //this creates the discard pile
        Discard k = new Discard();
        // this deals seven cards to each player
        for (int x = 0; x != 14; x++) {
            if (x == 1 || x == 3 || x == 5 || x == 7 || x == 9 || x == 11 || x == 13) {
                //this add a card in the computers hand for each odd number
                c.hand.addCard(d.drawCard());
            } else {
                //this add a card in the users hand for each even number
                h.hand.addCard(d.drawCard());
            }

        }
        //this adds a card to the discard pile
        k.addCard(d.drawCard());
        //this will loop the game until game over == true
        while (!gameover(c.hand.size(),h.hand.size())) {
            try {
                if (d.size()==0){
                    for(int x= 0;x!=k.size();x++){
                        d.addCard(k.drawCard());
                    }
                }
                //this gets the top card from the discard pile and makes it evaluable
            played=k.topCard();
            //this prints out how many cards the computer has
            System.out.println(c.name + " has " + c.hand.size() + " cards");
            //this prints the options the user has
            h.hand.printHand();
            //this displays what the top card is
            System.out.println("the top card is " + k.topCard());
            //this get the users choice as and int
           String sanswer = s.nextLine();
            answer = Integer.parseInt(sanswer);
            //this is for when a user plays an eight, it stores the change in the suit
            String suit="";
            //this decides if the user want to draw a card
            if (answer == h.hand.size()) {
                //this draws a card and add it to the users hand
                h.hand.addCard(d.drawCard());
                //this ends the users turn
                endTurn = true;
            } else {
                //this converts the users int into a card
                played = h.hand.playable(answer);
                //this removes the card from the hand
                h.hand.removeCard(played);
                //this test to see if the removed card is a valid card to play
                if(k.isPlayable(played)) {
                    //this test to see if the user has played a eight
                    if(played.value == "8"){
                        //this asks the user to decide what the new suit will be
                        System.out.println("Choose your new Suit");
                        //this will display an array of the suits with numbers for the user to display
                        h.hand.printSuit();
                        //this get the users choice as and int
                         sanswer = s.nextLine();
                        answer = Integer.parseInt(sanswer);
                        //changes users choice to a suit
                        suit=h.hand.suit(answer);
                        //this changes the card suit to the players choice
                        played.suit=suit;
                        //this adds the card to discard pile
                        k.addCard(played);
                        //this ends user turn
                        endTurn = true;
                    }
                    //this test to see if the user has played a two
                   // if(played.value == "2"){

                        k.addCard(played);
                      // if(c.hand.lookatCard(played)){
                         //  endTurn=true;
                      // }
                      //  else{
                          // c.hand.addCard(d.drawCard());
                          // c.hand.addCard(d.drawCard());
                      // }

                  //  }

                    endTurn = true;
                }
                else {
                    h.hand.addCard(played);
                    System.out.println("that is not a playable card Try again");
                }

            }
            while (endTurn) {
                played=k.topCard();
                //if(played.value=="2"){
                   // played=c.hand.findtwo(played);
                   // if(played==null){
                       // endTurn=false;
                    //}/
                  //  c.hand.removeCard(played);
                  //  k.addCard(played);
                   // if(h.hand.lookatCard(played)==true){
                //        System.out.println("Do you want to draw four");
                   //     endTurn=false;
                   // }
                  //  else {
                   //     h.hand.addCard(d.drawCard());
                   //     h.hand.addCard(d.drawCard());
                   //     h.hand.addCard(d.drawCard());
                  //  }
                //}
                played= c.hand.cPlayable(played);

                if(played==null){
                    played= c.hand.findeight(played);
                            if (played==null){
                                c.hand.addCard(d.drawCard());
                                System.out.println("Johnny Walker Drew  a card");
                                endTurn=false;
                            }
                    else if(played.value =="8")  {
                                played.suit=c.hand.newsuit();
                                c.hand.removeCard(played);
                                System.out.println(played);
                                k.addCard(played);

                                endTurn=false;
                    }
                }
                else {

                    c.hand.removeCard(played);
                    System.out.println(played);
                    k.addCard(played);

                    endTurn = false;
                }
            }
            }
            catch (Exception e){
                System.out.println("Input is invalid pick a number");
                endTurn=false;
            }


            //}



        }
    }

    //this test if the game is over
    private static boolean gameover(int c, int h)
    {
        //this test if the computer has ran out of cards
        if (c == 0)
            //this displays who won
            System.out.println("Johnny Walker is out of cards \n"+ "Johnny Walker Wins");
            //this test if the user has ran out of cards
        else if (h  == 0)
            //this displays who won
            System.out.println("You got rid of all your cards! You Won!\n");
        //this tells the system that the game is or isnt over
        return (c == 0|| h  == 0);

    }
    //public Card drawfour()
}
