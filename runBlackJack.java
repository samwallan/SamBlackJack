import java.util.*;

/**
 * Created by h205p2 on 3/7/17.
 */


public class runBlackJack {
    public static void main (String[] args){
        Deck myDeck = new Deck();
        /*
        1 is spades
        2 is clubs
        3 is hearts
        4 is diamonds
         */
        for (int i = 1; i <= 4; i++ ) {
            for(int j = 2; j<= 14; j++){
                myDeck.cards.add(new Card(i,j));
            }
        }



        System.out.println(myDeck.toString());
    }


}

