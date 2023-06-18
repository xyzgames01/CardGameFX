/**
 * Author : Zachary Zawodny
 * Class : ITN262
 * Date : 3/7/2023
 * Assignment : Stack Card Game
 */
package com.game.cardgamefx;

import java.util.ArrayList;
import java.util.Collections;


public class CardGame {

    public static ArrayList<Integer> deck = new ArrayList<>();

    public static LinkedStack<Integer> player1Deck = new LinkedStack<>();
    public static LinkedStack<Integer> player1WinDeck = new LinkedStack<>();

    public static LinkedStack<Integer> player2Deck = new LinkedStack<>();
    public static LinkedStack<Integer> player2WinDeck = new LinkedStack<>();


    public static void createDeck(){
        for(int i = 0; i < 52; i++){
            deck.add(i);
        }
    }

    public static void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public static void createPlayerDecks(){
        int count = 0;
        for(Integer i: deck){
            if(count % 2 == 0){
                player1Deck.push(i);
            }else {
                player2Deck.push(i);
            }
            count++;
        }
    }

    public static void simulateGame(){
        for(int i = 0; i < 26; i++){
            int player1 = player1Deck.peek();
            int player2 = player2Deck.peek();

            if (player1 > player2){
                player1WinDeck.push(player1Deck.pop());
                player1WinDeck.push(player2Deck.pop());
            }else {
                player2WinDeck.push(player2Deck.pop());
                player2WinDeck.push(player1Deck.pop());
            }

        }

    }
    public static void resetGame(){
        deck.clear();

        while (!player1WinDeck.isEmpty()){
            player1WinDeck.pop();
        }
        while (!player2WinDeck.isEmpty()){
            player2WinDeck.pop();
        }

    }
}
