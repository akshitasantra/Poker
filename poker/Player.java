import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Player
{
    private String name;
    private ArrayList<Card> hand;
    HandType handType = null;
    public Player(String n){
        name = n;
        hand = new ArrayList<Card>();
    }

    public void printHand(){
        Collections.sort(this.hand);
        Collections.reverse(this.hand);
        System.out.print(this.name + "'s hand:");
        for(int i = 0; i < hand.size(); i++){
            System.out.print(" " + this.hand.get(i).getFaceValue() +" " + this.hand.get(i).getSuit()+" ");
        }
        System.out.println();
    }

    public void clearHand(){
        this.hand.clear();
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public int indexOfCard(Card card){
        return hand.indexOf(card);
    }

    public void removeCard(Card card){
        hand.remove(card);
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public String getName(){
        return name;
    }
    
    public void setHandType(){
        handType = HandType.getHandType(hand);
    }
    
    public HandType getHandType(){
        return handType;
    }
    
    public int getHighestCardValue(){
        return hand.get(0).getValue();
    }
}

