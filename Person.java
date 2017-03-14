import java.util.ArrayList;


public class Person {

    ArrayList<Card> hand= new ArrayList<Card>();
    int handValue;

public int valueOfHand(){
    for(int i=0; i<hand.size(); i++){
       handValue += hand.get(i).totalValue;
   }
    return handValue;
}

public void newCard(Card theCard){
    this.hand.add(theCard);
}

}
