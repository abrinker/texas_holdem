/* Alex Rinker
 * Deck.java
 */

package holdem;
import java.util.*;

//Simulates a standard deck of playing cards
public class Deck {
    private ArrayList<Card> cards;
    private ArrayList<Card> discard;

    //Constructor
    public Deck() {
        this.build();
    }

    //Builds a deck
    private void build() {
        List<String> values = Arrays.asList("Ace","Two","Three","Four","Five","Six","Seven","Eight",
                                            "Nine","Ten","Jack","Queen","King");
        this.cards = new ArrayList<Card>();
        this.discard = new ArrayList<Card>();

        //Determine what suit the card should be
        for (Suits suit : Suits.values()) {
            this.build(values, suit);
        }
    }

    //Normal build
    private void build(List<String> values, Suits suit) {
        //Now Create the cards
        Card temp;
        for (int j=1;j<14;j++) {
            temp = new Card(j,values.get(j-1),suit);
            this.cards.add(temp);
        }
    }

    //Draw. Returns null if empty
    public Card draw() {
        if (this.cards.size() > 0) {
            return this.cards.remove(0);
        }
        else {
            return null;
        }
    }

    //Discard. Place a card in discard
    public void discard(Card card) {
        this.discard.add(card);
    }

    //Shuffles the remaining deck
    public void shuffle() {
        Random rand = new Random();
        ArrayList<Card> temp = new ArrayList<Card>();
        int numcards = this.cards.size();
        for(int i=0;i<numcards;i++) {
            temp.add(this.cards.remove(rand.nextInt(numcards-i)));
        }
        this.cards = temp;
    }

    //Returns discarded cards to the deck and shuffles
    public void reset() {
        for (Card card : this.discard) {
            this.cards.add(card);
        }
        this.shuffle();
        this.discard.clear();
    }

    //Provides the caller with the discarded cards
    public ArrayList<Card> get_discard() {
        return this.discard;
    }

    //Returns true if the input card is in the deck
    public boolean contains(Card card) {
        for (Card c : this.cards) {
            if(card.get_value() == c.get_value() && card.get_suit() == c.get_suit()) {
                return true;
            }
        }
        return false;
    }

    //toString
    public String toString() {
        String temp = "Deck: ";
        for (int i=0;i<this.cards.size();i++) {
            temp += (this.cards.get(i).get_name() + " " + this.cards.get(i).get_value() + ", ");
        }
        temp += "\nDiscard: ";
        for (int i=0;i<this.discard.size();i++) {
            temp += (this.discard.get(i).get_name() + " " + this.discard.get(i).get_value() + ", ");
        }
        return temp;
    }

    //Main
    public static void main(String args[]) {
        System.out.println("Generates a deck of 52 cards and then prints out the deck");
        Deck deck = new Deck();
        System.out.println("The Initial Deck:\n" + deck.toString());
        deck.discard(deck.draw());
        System.out.println("After Shuffle:");
        deck.shuffle();
        System.out.println(deck.toString());
        System.out.println("After Reset:");
        deck.reset();
        System.out.println(deck.toString());
    }
}
