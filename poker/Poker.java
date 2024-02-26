import java.util.ArrayList;
import java.util.Scanner;
public class Poker
{
    private static Player PC;
    private static Scanner scan = new Scanner(System.in);
    private static Player player1;
    private static Deck deck = new Deck();
    private static boolean playing = true;
    private static int round = 0;
    private static int playerWins = 0;
    private static int PCWins = 0;
    public static void main(String[] args){
        System.out.println("Welcome to Poker!!! Enter your name: ");
        player1 = new Player(scan.nextLine());
        PC = new Player("PC");
        while(playing){
            System.out.print("\f");
            round++;
            player1.clearHand();
            PC.clearHand();
            deck.shuffleDeck();
            System.out.printf("Round %d: %d to %d\n", round, playerWins, PCWins);
            startingDeal();
            replacePlayerCards();
            player1.printHand();
            System.out.println("The Computer will not replace any cards and will just stay with what they have.");
            player1.setHandType();
            PC.setHandType();
            printHandTypes();
            PC.printHand();
            printWinner();
            System.out.printf("Round %d: %d to %d\n", round, playerWins, PCWins);
            System.out.println("Would you like to play the game again? yes/no");
            boolean response = true;
            scan.nextLine();
            String playAgain = scan.nextLine();
            while(response && playAgain != null){
                if(playAgain.equalsIgnoreCase("yes")){
                    System.out.println("Alrighty then! Good luck on this next round!");
                    response = false;
                    try
                    {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                else if(playAgain.equalsIgnoreCase("no")){
                    System.out.println("Okay good cuz I was tired of you anyways");
                    System.out.printf("Round %d: %d to %d\n", round, playerWins, PCWins);
                    playing = false;
                    response = false;
                }
                else{
                    System.out.println("oh my lord can you just follow instructions for two seconds");
                    playAgain = scan.nextLine();
                }
            }
        }
    }

    public static void dealPlayerCard(){
        player1.addCard(deck.dealCard());
    }

    public static void startingDeal(){
        for(int i = 0; i < 5; i++){
            PC.addCard(deck.dealCard());
            dealPlayerCard();
        }
        player1.printHand();
    }

    public static void replacePlayerCards(){
        System.out.println("Which cards would you like to replace for new ones? \nPlease type the cards you would like to replace in one line and in the format of the face value first, followed by a space and the suit. \nPlease separate each card with spaces. \nEx: Q heart 10 DIAMOND j sPaDe \nType in done when you are finished replacing cards!");
        boolean face = true;
        String currentFace = "";
        Suit currentSuit = Suit.SPADE;
        String s = scan.next();
        while(!s.equals("done")){
            if(face){
                if(s.matches("[jJqQkKaA]|[1-9]|10")){
                    currentFace = s;
                }
                else{System.out.println("The instructions were pretty clear so I don't know how you messed this up smhwmf. Try again goober"); replacePlayerCards(); scan.next();scan.next();break;}
                face = false;
            }
            else{
                face = true;
                if(s.equalsIgnoreCase("Heart")){
                    currentSuit = Suit.HEART;
                }
                else if(s.equalsIgnoreCase("DIAMOND")){
                    currentSuit = Suit.DIAMOND;
                }
                else if(s.equalsIgnoreCase("CLUB")){
                    currentSuit = Suit.CLUB;
                }
                else if(s.equalsIgnoreCase("SPADE")){
                    currentSuit = Suit.SPADE;
                }
                else{
                    System.out.println("The instructions were pretty clear so I don't know how you messed this up smhwmf. Try again goober"); replacePlayerCards(); scan.next();break;
                }
                if(player1.indexOfCard(new Card(currentSuit, currentFace)) < 0){
                    System.out.println("girl don't try and cheat I literally see right through you");
                }
                else{
                    player1.removeCard(new Card(currentSuit, currentFace));
                    dealPlayerCard();
                }
            }
            s = scan.next();
        }
    }

    public static void printHandTypes(){
        System.out.println("You have a " + player1.getHandType().toString());
        System.out.println("The computer has a " + PC.getHandType().toString());
    }

    public static void printWinner(){
        Player winner = determineWinner(player1, PC);
        if(winner == null){
            System.out.println("Tie!");
        }
        else{
            System.out.println(winner.getName() + " wins!");
            if(winner.equals(player1)){playerWins++;}
            else{PCWins++;}
        }
    }

    public static Player determineWinner(Player p1, Player p2){
        int pairValue1 = HandType.getHigherSet(p1.getHand());
        int pairValue2 = HandType.getHigherSet(p2.getHand());
        int highCardValue1 = p1.getHighestCardValue();
        int highCardValue2 = p2.getHighestCardValue();
        if(p1.getHandType().equals(p2.getHandType())){
            if(p1.getHandType().equals(HandType.PAIR) || 
            p1.getHandType().equals(HandType.TWOPAIR) ||
            p1.getHandType().equals(HandType.THREEOFAKIND) ||
            p1.getHandType().equals(HandType.FOUROFAKIND)){
                if(pairValue1 > pairValue2){
                    return p1;
                }
                else if(pairValue1 < pairValue2){
                    return p2;
                }
                else{
                    return null;
                }
            }
            else{
                if(highCardValue1 > highCardValue2){
                    return p1;
                }
                else if(highCardValue1 < highCardValue2){
                    return p2;
                }
                return null;
            }
        }
        else{
            if(p1.getHandType().value > p2.getHandType().value){
                return p1;
            }
            else if(p1.getHandType().value < p2.getHandType().value){
                return p2;
            }
            return null;
        }
    }
}
