import java.util.*;

public class runBlackJack {
    public static void main (String[] args){
        Deck myDeck = new Deck();
        for (int i = 1; i <= 4; i++ ) {
            for(int j = 2; j<= 14; j++){
                myDeck.cards.add(new Card(i,j));
            /*
        1 is spades
        2 is clubs
        3 is hearts
        4 is diamonds
         */
            }
        }

        Player sam = new Player();
        Dealer deal = new Dealer();

        sam.newCard(myDeck.dealCard());
        sam.newCard(myDeck.dealCard());

        deal.newCard(myDeck.dealCard());
        deal.newCard(myDeck.dealCard());

        System.out.println("Welcome to blackjack. Your cards are "+sam.toString()+". The dealer shows a "+ deal.toString()+". Type 's' to stay and 'h' to hit.");


    }


}

