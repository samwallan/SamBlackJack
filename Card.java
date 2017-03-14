
public class Card {
    int suit;
    int value;
    String name;
    int totalValue;

    public Card(int xsuit, int xvalue){
        this.suit = xsuit;
        this.value = xvalue;
       // this.faceVal = calcFace();
        this.name = "("+calcFace() + " of " + calcSuit()+")";
        this.totalValue = valueCalc(this.value);

    }
    public String calcSuit(){
        String suitStr = new String();
        switch (this.suit){
            case 1:
                suitStr = "Clubs";
            break;
            case 2:
                suitStr = "Spades";
            break;
            case 3:
                suitStr = "Diamonds";
            break;
            case 4:
                suitStr = "Hearts";
            break;
            default:
                suitStr = "Spades";
            break;

        }
return suitStr;
    }
    public String calcFace(){
        String face;
        if(this.value < 11){
            face = String.valueOf(this.value);
        }else if(this.value == 11){
            face = "Jack";
        }else if(this.value == 12){
            face = "Queen";
        }else if(this.value == 13){
            face = "King";
        }else{
            face = "Ace";
        }
        return face;
    }
    public int valueCalc(int val){
        if(val < 11){
            return val;
        }else if(val == 14){
            return 11;
        }else{
            return 10;
     }

}
}
