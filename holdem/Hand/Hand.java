/* Alex Rinker
 * Hand.java
 */

package holdem;
import java.util.*;

//Simulates a hand of two cards in a game of Texas Hold'em
public class Hand implements Comparator<Hand> {
    private ArrayList<Card> hand;
    private Score score;

    //Constructor
    public Hand() {
        this.hand = new ArrayList<Card>();
        this.score = new Score();
    }

    //Adds a card to the hand
    public void add(Card card) {
        if(this.hand.size() < 2) {
            this.hand.add(card);
        }
    }

    //Removes a card from the hand
    public Card remove() {
        return (this.hand.size() > 0) ? this.hand.remove(0) : null;
    }

    //Peeks at the hand
    public ArrayList<Card> peek(){
        return hand;
    }

    //Returns the current size of the hand
    public int size() {
        return this.hand.size();
    }

    //Clears the hand of cards.
    public void clear() {
        this.hand.clear();
    }

    //Returns the score of the current hand
    public int get_score() {
        return this.score.evaluate();
    }

    public String toString() {
        if (this.hand.size() == 0) {return "Empty Hand";}
        String temp = "";
        Card  tCard;
        for (int i=0;i<this.hand.size();i++) {
            temp += this.hand.get(i).toString() + " ";
        }
        return temp;
    }

    //Prettifies the string
    public String prettify() {
        if (this.hand.size() == 0) {return "";}
        String temp = "";
        String[] parts;
        int size = this.hand.size();
        for (int i=0;i<size;i++) {
            temp += this.hand.get(i).prettify();
        }
        parts = temp.split("\n");
        temp = "";
        for (int i=0;i<3;i++) {
            for (int j=0;j<size;j++) {
                temp += parts[i+(3*j)];
            }
            temp += "\n";
        }
        return temp;
    }

    //Compares two hands
    public int compare(Hand a, Hand b) {
        return compare(a.get_score(), b.get_score());
    }

    public static void main(String args[]) {
        System.out.println("Generates a Hand of two cards and prints them out");
        Hand hand = new Hand();
        Card card_1 = new Card(1,"Ace",Suits.SPADES);
        Card card_2 = new Card(1,"Ace",Suits.DIAMONDS);
        hand.add(card_1);
        hand.add(card_2);
        System.out.println(hand.toString());
        System.out.println(hand.prettify());
        hand.clear();
        System.out.println("After Clearing:");
        System.out.println(hand.toString());
    }
}
