/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;


import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = generateMagicHand();

        displayMagicHand(magicHand);

        // Prompt user for card input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();

        System.out.print("Enter a suit (0-3 where 0 = hearts, 1 = Diamonds, 2 = clubs, 3 = Spades): ");
        int userSuit = scanner.nextInt();

        Card luckyCard = new Card();
        luckyCard.setValue(userValue);
        luckyCard.setSuit(Card.SUITS[userSuit]);

        // Check if luckyCard is in magicHand
        boolean isLuckyCardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                isLuckyCardFound = true;
                break;
            }
        }

        // Display result
        if (isLuckyCardFound) {
            System.out.println("Congratulations! Your lucky card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Method to generate a magic hand of seven cards with random values
    private static Card[] generateMagicHand() {
        Random random = new Random();
        Card[] magicHand = new Card[7];

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            card.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit
            magicHand[i] = card;
        }

        return magicHand;
    }

    // Method to display the magic hand
    private static void displayMagicHand(Card[] magicHand) {
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
    }
}
