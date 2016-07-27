/* Alex Rinker
 * Score.java
 */

package holdem;
import java.util.*;

//Somehow figures out what the best score is for each hand
//and also determines the winner.
public class Score {
    private ArrayList<Card> cards;

    //constructor
    public Score(Hand h, CommunityCards c) {
        this.cards=c.clone();
        for (int i=0;i<h.size();i++){
            this.cards.add(h.peek()[i]); //This is theoretically slow. Change eventually
        }
        this.sort();
    }

    //Sorts the 7 cards
    private void sort() {
        ArrayList<Card> temp = new ArrayList<Card>();
        for (int i=0;i<this.cards.size();i++) {
            for (int j=0;j<this.cards.size();j++) {

            }
        }
    }

    //This should be the only public class
    public int evaluate() {
        return 0;
    }

    public static void main(String args[]) {
        Score score = new Score();
    }
}
