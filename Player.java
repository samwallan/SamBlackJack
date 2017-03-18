
public class Player extends Person {

    String handString;
    int bank;
    public Player() {
        this.handString = "";
        this.handValue= valueOfHand();
        this.bank = 100;
    }

    public String toString(){
        handString = "";
        for (int i = 0; i<this.hand.size();i++) {
            handString += (hand.get(i).name);
        }
        return handString;
    }
    public void moneyChange(int change){
        this.bank += change;
    }
}
