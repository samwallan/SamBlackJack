
public class Player extends Person {

    String handString;

    public Player() {
        this.handString = new String();
    }

    public String toString(){
        for (int i = 0; i<this.hand.size();i++) {
            handString += (hand.get(i).name);
        }
        return handString;
    }

}
