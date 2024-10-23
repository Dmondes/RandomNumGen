package task11.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Deck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] numList = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
                "Queen", "King" };
        ArrayList<String> deck = new ArrayList<>();
        HashMap<String, Integer> values = new HashMap<>();
        for (String suit : suits) {
            for (String num : numList) {
                deck.add(num + " of " + suit);
            }
        }
        for (String item : deck) {
            if (item.contains("Two")) {
                values.put(item, 2);
            } else if (item.contains("Three")) {
                values.put(item, 3);
            } else if (item.contains("Four")) {
                values.put(item, 4);
            } else if (item.contains("Five")) {
                values.put(item, 5);
            } else if (item.contains("Six")) {
                values.put(item, 6);
            } else if (item.contains("Seven")) {
                values.put(item, 7);
            } else if (item.contains("Eight")) {
                values.put(item, 8);
            } else if (item.contains("Nine")) {
                values.put(item, 9);
            } else if (item.contains("Ace")) {
                values.put(item, 1);
            } else {
                values.put(item, 10);
            }
        }
        // deck.forEach((n) -> {System.out.print(n + ", ");});
        // System.out.println(deck.size());
        // for (String name: values.keySet()){
        //     System.out.println(name + ": " + values.get(name));
        // }
        Collections.shuffle(deck);
        System.out.println("How many players");
        String num = scan.nextLine();
        int count = 0;
        HashMap<String, ArrayList<String>> players = new HashMap<>();
        for (int i = 0; i < Integer.valueOf(num); i ++){
            String name = "Player" + Integer.toString(i + 1);
            ArrayList<String> hand = new ArrayList<>();
            hand.add(deck.get(count++));
            hand.add(deck.get(count++));
            players.put(name, hand);
        }
        for (int i = 1; i <= players.size(); i ++){
            int sum = 0;
            System.out.println(players.get("Player" + Integer.toString(i)));
            String playerName = "Player" + Integer.toString(i);
            for (String item:players.get(playerName)){
                int val = values.get(item);
                System.out.println(val);
                if (val == 1 && sum < 21){
                    val = val + 10;
                }
                sum += val;
            }
            System.out.println(sum);
            while (sum < 21){
                System.out.println("Deal a card?");
                String deal = scan.nextLine();
                if (deal.trim().toLowerCase().equals("yes")){
                    players.get(playerName).add(deck.get(count));
                    System.out.println(deck.get(count));
                    sum += values.get(deck.get(count++));
                    if (sum > 21 && playerName.contains("Ace")){
                        sum -= 10;
                        System.out.println("Taking Ace as 1");
                    }
                    System.out.println(sum);
                } else if (deal.trim().toLowerCase().equals("no")){
                    System.out.println("Stay hand");
                    break;
                } 
            } 
            if (sum > 21){
                System.out.println("Busted");
            } 

            if (sum == 21){
                System.out.println("Blackjack!");
            }
            
        }

        
    }

}
