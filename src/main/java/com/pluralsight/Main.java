package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        System.out.println("Welcome to Blackjack!");
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        ArrayList<Hand> players = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            names.add(name);
            players.add(new Hand());
        }

        for (Hand hand : players) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }


        for (int i = 0; i < numPlayers; i++) {
            Hand hand = players.get(i);
            String name = names.get(i);

            System.out.println("\n" + name + "'s turn!");
            boolean playing = true;

            while (playing) {
                hand.showHand();
                System.out.println("Total: " + hand.getValue());

                if (hand.getValue() > 21) {
                    System.out.println(name + " busts!");
                    playing = false;
                    break;
                }

                System.out.print("Hit or stay? ");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("hit")) {
                    hand.deal(deck.deal());
                } else {
                    playing = false;
                }
            }
        }

        int best = 0;
        String winner = "No one";

        for (int i = 0; i < numPlayers; i++) {
            int value = players.get(i).getValue();
            if (value > best && value <= 21) {
                best = value;
                winner = names.get(i);
            }
        }

        System.out.println("\n🏆 " + winner + " wins with " + best + " points!");
    }
}