import java.util.Stack;
import java.util.Collections;
public class Deck
{
    private Stack<Card> deck;
    public Deck(){
        deck = new Stack<Card>();
        for(int i = 1; i <= 52; i++){
            if(i == 1){
                deck.push(new Card(14, Suit.SPADE, "A"));
            }
            else if(i < 11){
                deck.push(new Card(i, Suit.SPADE, ""+i));
            }
            else if(i == 11){
                deck.push(new Card(11, Suit.SPADE, "J"));
            }
            else if(i == 12){
                deck.push(new Card(12, Suit.SPADE, "Q"));
            }
            else if(i == 13){
                deck.push(new Card(13, Suit.SPADE, "K"));
            }
            else if(i == 14){
                deck.push(new Card(14, Suit.CLUB, "A"));
            }
            else if(i < 24){
                deck.push(new Card(i%13, Suit.CLUB, ""+i%13));
            }
            else if(i == 24){
                deck.push(new Card(11, Suit.CLUB, "J"));
            }
            else if(i == 25){
                deck.push(new Card(12, Suit.CLUB, "Q"));
            }
            else if(i == 26){
                deck.push(new Card(13, Suit.CLUB, "K"));
            }
            else if(i == 36){
                deck.push(new Card(14, Suit.HEART, "A"));
            }
            else if(i < 37){
                deck.push(new Card(i%13, Suit.HEART, ""+i%13));
            }
            else if(i == 37){
                deck.push(new Card(11, Suit.HEART, "J"));
            }
            else if(i == 38){
                deck.push(new Card(12, Suit.HEART, "Q"));
            }
            else if(i == 39){
                deck.push(new Card(13, Suit.HEART, "K"));
            }
            else if(i == 40){
                deck.push(new Card(14, Suit.DIAMOND, "A"));
            }
            else if(i < 50){
                deck.push(new Card(i%13, Suit.DIAMOND, ""+i%13));
            }
            else if(i == 50){
                deck.push(new Card(11, Suit.DIAMOND, "J"));
            }
            else if(i == 51){
                deck.push(new Card(12, Suit.DIAMOND, "Q"));
            }
            else if(i == 52){
                deck.push(new Card(13, Suit.DIAMOND, "K"));
            }
        }
        shuffleDeck();
    }

    public Card dealCard(){
        if(deck.empty()){
            resetDeck();
        }
        return deck.pop();
    }

    public void resetDeck(){
        deck = new Stack<Card>();
        for(int i = 1; i <= 52; i++){
            if(i == 1){
                deck.push(new Card(14, Suit.SPADE, "A"));
            }
            else if(i < 11){
                deck.push(new Card(i, Suit.SPADE, ""+i));
            }
            else if(i == 11){
                deck.push(new Card(11, Suit.SPADE, "J"));
            }
            else if(i == 12){
                deck.push(new Card(12, Suit.SPADE, "Q"));
            }
            else if(i == 13){
                deck.push(new Card(13, Suit.SPADE, "K"));
            }
            else if(i == 14){
                deck.push(new Card(14, Suit.CLUB, "A"));
            }
            else if(i < 24){
                deck.push(new Card(i%13, Suit.CLUB, ""+i%13));
            }
            else if(i == 24){
                deck.push(new Card(11, Suit.CLUB, "J"));
            }
            else if(i == 25){
                deck.push(new Card(12, Suit.CLUB, "Q"));
            }
            else if(i == 26){
                deck.push(new Card(13, Suit.CLUB, "K"));
            }
            else if(i == 36){
                deck.push(new Card(14, Suit.HEART, "A"));
            }
            else if(i < 37){
                deck.push(new Card(i%13, Suit.HEART, ""+i%13));
            }
            else if(i == 37){
                deck.push(new Card(11, Suit.HEART, "J"));
            }
            else if(i == 38){
                deck.push(new Card(12, Suit.HEART, "Q"));
            }
            else if(i == 39){
                deck.push(new Card(13, Suit.HEART, "K"));
            }
            else if(i == 40){
                deck.push(new Card(14, Suit.DIAMOND, "A"));
            }
            else if(i < 50){
                deck.push(new Card(i%13, Suit.DIAMOND, ""+i%13));
            }
            else if(i == 50){
                deck.push(new Card(11, Suit.DIAMOND, "J"));
            }
            else if(i == 51){
                deck.push(new Card(12, Suit.DIAMOND, "Q"));
            }
            else if(i == 52){
                deck.push(new Card(13, Suit.DIAMOND, "K"));
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
}
