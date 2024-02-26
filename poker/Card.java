public class Card implements Comparable<Card>
{
    private int value;
    private Suit suit;
    private String faceValue;
    public Card(int v, Suit s, String f){
        value = v;
        suit = s;
        faceValue = f;
    }
    public Card(Suit s, String f){
        value = 0;
        suit = s;
        faceValue = f;
    }
    public int getValue(){
        return value;
    }
    public Suit getSuit(){
        return suit;
    }
    public String getFaceValue(){
        return faceValue;
    }
    public String toString(){
        return faceValue + suit.toString();
    }
    @Override 
    public int compareTo(Card c){
        return  value-c.value;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){return true;}
        if(!(o instanceof Card)){return false;}
        Card c = (Card) o;
        return (faceValue.equalsIgnoreCase(c.getFaceValue())) && (suit == c.getSuit());
    }
}
