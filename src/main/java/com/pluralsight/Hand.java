package com.pluralsight;
import java.util.ArrayList;


    public class Hand {
        private ArrayList<Card> cards;

        public Hand() {
            cards = new ArrayList<>();
        }

        public void deal(Card card) {
            cards.add(card);
        }

        public int getValue() {
            int total = 0;
            int aceCount = 0;

            for (Card card : cards) {
                card.flip(); // show the card to calculate
                total += card.getPointValue();

                if (card.getValue().equals("A")) {
                    aceCount++;
                }
            }

            // Adjust for Aces (11 or 1)
            while (total > 21 && aceCount > 0) {
                total -= 10; // make one Ace worth 1 instead of 11
                aceCount--;
            }

            return total;
        }

        public void showHand() {
            for (Card card : cards) {
                card.flip(); // make them visible
                System.out.println(card);
            }
        }

        public int getSize() {
            return cards.size();
        }
    }

