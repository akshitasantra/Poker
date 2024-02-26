import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public enum HandType
{
    ROYALFLUSH(10), 

    STRAIGHTFLUSH(9), 

    FOUROFAKIND(8), 

    FULLHOUSE(7), 

    FLUSH(6), 

    STRAIGHT(5),

    THREEOFAKIND(4), 

    TWOPAIR(3), 

    PAIR(2), 

    HIGHCARD(1);

    int value;

    HandType(int v){
        value = v;
    }

    public String toString(){
        switch (this){
            case ROYALFLUSH:
                return "Royal Flush";
            case STRAIGHTFLUSH:
                return "Straight Flush";
            case FOUROFAKIND:
                return "Four of a Kind";
            case FULLHOUSE:
                return "Full House";
            case FLUSH:
                return "Flush";
            case STRAIGHT:
                return "Straight";
            case THREEOFAKIND:
                return "Three of a Kind";
            case TWOPAIR:
                return "Two of Pairs";
            case PAIR:
                return "Pair";
        }
        return "High Card";
    }

    public static boolean isPair(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);
        if (freqMap.containsValue(2)) {
            return true;
        }
        return false;
    }

    public static boolean isTwoPair(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);
        if (Collections.frequency(freqMap.values(), 2) == 2) {
            return true;
        }
        return false;
    }

    public static boolean isThreeOfAKind(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);
        if (freqMap.containsValue(3)) {
            return true;
        }
        return false;
    }

    public static boolean isStraight(ArrayList<Card> hand){
        Iterator<Card> it = hand.iterator();
        int prev = it.next().getValue();
        while (it.hasNext()) {
            int curr = it.next().getValue();
            if (prev + 1 != curr) {
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public static boolean isFlush(ArrayList<Card> hand){
        Suit temp = hand.get(0).getSuit();
        for(int i = 1; i < hand.size(); i++){
            if(temp != hand.get(i).getSuit()){return false;}
        }
        return true;
    }

    public static boolean isFullHouse(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);
        Set<Integer> fullHouseCheck = new HashSet<Integer>(freqMap.values());
        if (fullHouseCheck.contains(2) && fullHouseCheck.contains(3)) {
            return true;
        }
        return false;
    }

    public static boolean isFourOfAKind(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);  
        if (freqMap.containsValue(4)) {
            return true;
        }
        return false;
    }

    public static boolean isStraightFlush(ArrayList<Card> hand){
        return isStraight(hand) && isFlush(hand);
    }

    public static boolean isRoyalFlush(ArrayList<Card> hand){
        return isStraightFlush(hand) && hand.get(4).getValue() == 14;
    }

    public static HandType getHandType(ArrayList<Card> hand){
        if(isRoyalFlush(hand)) return HandType.ROYALFLUSH;
        else if (isStraightFlush(hand)) return HandType.STRAIGHTFLUSH;
        else if (isFourOfAKind(hand)) return HandType.FOUROFAKIND;
        else if (isFullHouse(hand)) return HandType.FULLHOUSE;
        else if (isFlush(hand)) return HandType.FLUSH;
        else if (isStraight(hand)) return HandType.STRAIGHT;
        else if (isThreeOfAKind(hand)) return HandType.THREEOFAKIND;
        else if (isTwoPair(hand)) return HandType.TWOPAIR;
        else if (isPair(hand)) return HandType.PAIR;
        return HandType.HIGHCARD;
    }

    public static int getHigherSet(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = createFrequencyMap(hand);
        for(Map.Entry<Integer, Integer> e : freqMap.entrySet()){
            int cardValue = e.getKey();
            int freq = e.getValue();
            switch(freq){
                case 2:
                case 3:
                case 4:
                    return cardValue;
            }
        }
        return 0;
    }

    public static Map<Integer, Integer> createFrequencyMap(ArrayList<Card> hand){
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(Card c : hand){
            Integer value = freqMap.get(c.getValue());
            if(value == null){
                value = 0;
            }
            value++;
            freqMap.put(c.getValue(), value);
        }
        return freqMap;
    }
}
