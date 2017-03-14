import java.util.ArrayList;

public class Dealer extends Person {
   // ArrayList<Card> hand = new ArrayList<Card>();

    public Dealer(){
        this.hand= hand;
    }

    public String toString(){
        return this.hand.get(0).name;
    }
    public String revealHand(){
        String handString = "";
        for(int i = 0; i< this.hand.size(); i++){
            handString += this.hand.get(i).name;
        }
        return handString;
    }
}
