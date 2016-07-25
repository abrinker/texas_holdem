/* Alex Rinker
 * CommunityCards.java
 */

package holdem;
import java.util.*;

//Simulates the 5 community cards in a game of hold'em
public class CommunityCards {
    private ArrayList<Card> cards;

    //Constructor
    public CommunityCards() {
        this.cards = new ArrayList<Card>();
    }

    //peek at the cards
    public ArrayList<Card> peek() {
        return this.cards;
    }

    //Adds a card to the community
    public void add(Card card) {
        this.cards.add(card);
    }

    //Removes a card from the community
    public Card remove() {
        return (this.cards.size() > 0) ? this.cards.remove(0) : null;
    }

    //Clears the community
    public void clear() {
        this.cards.clear();
    }

    //toString
    public String toString() {
        String temp = "";
        for (Card card : this.cards) {
            temp += card.toString() + " ";
        }
        return temp;
    }

    //prettifies the string
    public String prettify() {
        String temp = "";
        String[] parts;
        int size = this.cards.size();
        for (int i=0;i<size;i++) {
            temp += this.cards.get(i).prettify();
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

    public static void main(String args[]) {
        System.out.println("Simulating the Community Cards in a game of holdem");
    }
}
