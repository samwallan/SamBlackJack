import java.lang.reflect.Array;
import java.util.*;


public class Deck  {
    ArrayList<Card> cards;
    String deckString ="";
    public Deck() {
        this.cards = new ArrayList<>();
    }

public int dealCard(){
    //returns a random card from the deck's arrayList of cards (name: cards)
    return cards.get((int)Math.floor(Math.random() * cards.size())).totalValue;
}

public String toString(){
    for (int i = 0; i<cards.size(); i++){
     deckString += cards.get(i).value+ " ";

    }
    return deckString;
}

}
