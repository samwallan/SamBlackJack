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
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine().toLowerCase();




        if(userInput.equals("h")){
            sam.newCard(myDeck.dealCard());
            System.out.println("Your hand is now"+ sam.toString());
            if(sam.valueOfHand() > 21){
                System.out.println("That means you lose.");
            }else if(sam.valueOfHand() == 21){
                System.out.println("I guess that means you win.");

            }else{
                System.out.println("Type 's' to stay and 'h' to hit."+ sam.valueOfHand());

            }
        }else if(userInput.equals("s")){

            for(int i = 0; i<= 1; i++){
                if(deal.valueOfHand()<17){
                    deal.newCard(myDeck.dealCard());
                    if(deal.valueOfHand()<17){
                        i=1;
                    }
                }
            }


            System.out.println("You chose to stay. Your hand value is "+ sam.valueOfHand()+". The dealer's hand value is "+ deal.valueOfHand()+".");
            if (sam.valueOfHand()>deal.valueOfHand()){
                System.out.println("You win.");
            }

        }




    }


}

