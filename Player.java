
public class Player extends Person {

    String handString;
    int bank;
    public Player() {
        this.handString = new String();
        this.handValue= valueOfHand();
        this.bank = new Integer(100);
    }

    public String toString(){
        handString = "";
        for (int i = 0; i<this.hand.size();i++) {
            handString += (hand.get(i).name);
        }
        return handString;
    }

}
