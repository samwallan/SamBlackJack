import java.util.*;

public class runBlackJack {
    public static void main(String[] args) {
        boolean ifthis = true;

        boolean win = false;
        int betamnt = 0;
        Deck myDeck = new Deck();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                myDeck.cards.add(new Card(i, j));
            }
        }
        Scanner scan = new Scanner(System.in);
        Player sam = new Player();
        Dealer deal = new Dealer();


        while (ifthis) {

            sam.clearHand();
            deal.clearHand();

            sam.newCard(myDeck.dealCard());
            sam.newCard(myDeck.dealCard());

            deal.newCard(myDeck.dealCard());
            deal.newCard(myDeck.dealCard());


            System.out.println("You have " + sam.bank + " dollars to bet. Enter how much you want to bet");
            String userInpu = scan.nextLine().toLowerCase();

                /* userInpu = String.valueOf(sam.bank); */
            if(Integer.parseInt(userInpu)<sam.bank+1){
                betamnt = Integer.parseInt(userInpu);
            }else{
                betamnt = sam.bank;
            }
            sam.bank = sam.bank - betamnt;
            System.out.println("You bet " + betamnt + ". You have " + sam.bank + " left.");

            System.out.println("Welcome to the table. Your cards are " + sam.toString() + ". The dealer shows a " + deal.toString() + ". Type 's' to stay and 'h' to hit.");


            boolean check = true;
            while (check) {
                String userInput = scan.nextLine().toLowerCase();

                switch (userInput) {
                    case "h":
                        sam.newCard(myDeck.dealCard());
                        System.out.println("Your hand is now" + sam.toString());
                        if (sam.valueOfHand() > 21) {
                            System.out.println("That means you lose. You're over 21.");
                            win = false;
                            check = false;
                        } else if (sam.valueOfHand() == 21) {
                            System.out.println("I guess that means you win. You got 21 exactly.");
                            win = true;
                            check = false;
                        } else {
                            System.out.println("Type 's' to stay and 'h' to hit.");
                        }
                        break;
                    case "s":

                        for (int i = deal.valueOfHand(); i < 17; i++) {
                            deal.newCard(myDeck.dealCard());
                            i = deal.valueOfHand();
                        }
                        System.out.println("You chose to stay. Your hand value is " + sam.valueOfHand() + ". The dealer's hand " +
                                "was" + deal.revealHand() + ", with value  " + deal.valueOfHand() + ".");
                        if (sam.valueOfHand() > deal.valueOfHand() && sam.valueOfHand() < 22 && !(sam.valueOfHand() == deal.valueOfHand())) {
                            System.out.println("You win.");
                            win = true;
                            check = false;
                        } else if (sam.valueOfHand() < deal.valueOfHand() && deal.valueOfHand() < 22) {
                            System.out.println("You lose.");
                            win = false;
                            check = false;
                        } else {
                            System.out.println("You win!");
                            win = true;
                            check = false;
                        }

                        break;
                    default:
                        System.out.println("Enter an 's' or an 'h'.");
                        break;
                }
                if (win) {
                    sam.bank = sam.bank + (2 * betamnt);

                }



            }
            System.out.println("You have " + sam.bank + " dollars left.");
            if(!(sam.bank == 0)){
                System.out.println("Play again? Type 'y' for yes and 'n' for no");
                userInpu = scan.nextLine().toLowerCase();
                if (userInpu.equals("y")) {
                    ifthis = true;
                } else if( userInpu.equals('n')){
                    ifthis = false;
                }else{
                    System.out.println("Thats not an 'n' or a 'y', but I guess that means you want to play again.");
                    ifthis = true;
                }
            }else{
                System.out.println("You're out of money and lose the entire game.");
                ifthis = false;
            }
        }
    }
}


