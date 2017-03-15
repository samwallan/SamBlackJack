import java.util.*;

public class runBlackJack {
    public static void main(String[] args) {

        Deck myDeck = new Deck();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                myDeck.cards.add(new Card(i, j));
            }
        }

        Player sam = new Player();
        Dealer deal = new Dealer();

        sam.newCard(myDeck.dealCard());
        sam.newCard(myDeck.dealCard());

        deal.newCard(myDeck.dealCard());
        deal.newCard(myDeck.dealCard());

        System.out.println("Welcome to blackjack. Your cards are " + sam.toString() + ". The dealer shows a " + deal.toString() + ". Type 's' to stay and 'h' to hit.");
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        while (check) {
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.equals("h")) {
                sam.newCard(myDeck.dealCard());
                System.out.println("Your hand is now" + sam.toString());
                if (sam.valueOfHand() > 21) {
                    System.out.println("That means you lose. You're over 21.");
                    check = false;
                } else if (sam.valueOfHand() == 21) {
                    System.out.println("I guess that means you win. You got 21 exactly.");
                    check = false;
                } else {
                    System.out.println("Type 's' to stay and 'h' to hit.");
                }
            } else if (userInput.equals("s")) {

                for (int i = deal.valueOfHand(); i < 17; i++) {
                    deal.newCard(myDeck.dealCard());
                    i = deal.valueOfHand();
                }
                System.out.println("You chose to stay. Your hand value is " + sam.valueOfHand() + ". The dealer's hand " +
                        "was"+deal.revealHand()+", with value  " + deal.valueOfHand() + ".");
                if (sam.valueOfHand() > deal.valueOfHand() && sam.valueOfHand() < 22 && !(sam.valueOfHand() == deal.valueOfHand())) {
                    System.out.println("You win.");
                    check = false;
                } else if (sam.valueOfHand() < deal.valueOfHand() && deal.valueOfHand() < 22) {
                    System.out.println("You lose.");
                    check = false;
                } else {
                    System.out.println("You win!");
                    check = false;
                }

            }else{
                System.out.println("Enter an 's' or an 'h'.");
            }
        }
    }
}
