import java.util.ArrayList;


public class Person {

    //private final int totalHandValue;
    ArrayList<Card> hand= new ArrayList<Card>();
    int handValue;

    public void clearHand(){
        this.hand.clear();

    }
    public Person() {
       // int totalHandValue = this.valueOfHand();

    }

public int valueOfHand(){
    handValue = 0;
    for(int i=0; i<hand.size(); i++){
       handValue += hand.get(i).totalValue;
   }
    return handValue;
}

public void newCard(Card theCard){
    this.hand.add(theCard);
}

}
