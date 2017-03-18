import java.util.*;

public class runBlackJack {
    public static void main(String[] args) {
        System.out.println("Hello");
        boolean playMore = true;

        boolean win = false;
        int betAmount = 0;
        Deck myDeck = new Deck();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                myDeck.cards.add(new Card(i, j));
            }
        }
        Scanner scan = new Scanner(System.in);
        Player sam = new Player();
        Dealer deal = new Dealer();


        while (playMore) {

            sam.clearHand();
            deal.clearHand();

            sam.newCard(myDeck.dealCard());
            sam.newCard(myDeck.dealCard());

            deal.newCard(myDeck.dealCard());
            deal.newCard(myDeck.dealCard());


            System.out.println("You have " + sam.bank + " dollars to bet. Enter how much you want to bet");
            String userInpu = scan.nextLine().toLowerCase();

            if(!(Integer.parseInt(userInpu) >= (sam.bank))){
                betAmount = Integer.parseInt(userInpu);
            }else{
                betAmount = sam.bank;
            }
            sam.moneyChange(betAmount*(-1));
            //sam.bank = sam.bank - betAmount;
            System.out.println("You bet " + betAmount + ". You have " + sam.bank + " left.");

            System.out.println("Welcome to the table. Your cards are " + sam.toString() + ". The dealer shows a " + deal.toString() + ". Type 's' to stay and 'h' to hit.");


            boolean sameHand = true;
            while (sameHand) {
                String userInput = scan.nextLine().toLowerCase();

                switch (userInput) {
                    case "h":
                        sam.newCard(myDeck.dealCard());
                        System.out.println("Your hand is now" + sam.toString());
                        if (sam.valueOfHand() > 21) {
                            System.out.println("That means you lose. You're over 21.");
                            win = false;
                            sameHand = false;
                        } else if (sam.valueOfHand() == 21) {
                            System.out.println("You win "+betAmount+"dollars. You got 21 exactly.");
                            win = true;
                            sameHand = false;
                        } else {
                            System.out.println("Type 's' to stay and 'h' to hit.");
                        }
                        break;
                    case "s":

                        for (int i = deal.valueOfHand(); i < 16; i++) {
                            deal.newCard(myDeck.dealCard());
                            i = deal.valueOfHand();
                        }
                        System.out.println("You chose to stay. Your hand value is " + sam.valueOfHand() + ". The dealer's hand " +
                                "was" + deal.revealHand() + ", with value  " + deal.valueOfHand() + ".");
                        if (sam.valueOfHand() > deal.valueOfHand() && sam.valueOfHand() < 22 && !(sam.valueOfHand() == deal.valueOfHand())) {
                            System.out.println("You win "+betAmount+" dollars.");
                            win = true;
                            sameHand = false;
                        } else if (sam.valueOfHand() < deal.valueOfHand() && deal.valueOfHand() < 22) {
                            System.out.println("You lose.");
                            win = false;
                            sameHand = false;
                        } else {
                            System.out.println("You win "+betAmount+" dollars.");
                            win = true;
                            sameHand = false;
                        }

                        break;
                    default:
                        System.out.println("Enter an 's' or an 'h'.");
                        break;
                }
                if (win) {
                    sam.moneyChange(2*betAmount);
                    //sam.bank = sam.bank + (2 * betAmount);

                }



            }
            System.out.println("You have " + sam.bank + " dollars.");
            if(!(sam.bank == 0)){
                System.out.println("Play again? Type 'y' for yes and 'n' for no");
                userInpu = scan.nextLine().toLowerCase();
                if (userInpu.equals("y")) {
                    playMore = true;
                } else if( userInpu.equals("n")){
                    playMore = false;
                }else{
                    System.out.println("Thats not an 'n' or a 'y', but I guess that means you want to play again.");
                    playMore = true;
                }
            }else{
                System.out.println("You're out of money and lose the entire game.");
                playMore = false;
            }
        }
        System.out.println("Bye");
    }
}


