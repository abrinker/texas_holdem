/* Alex Rinker
 * HandSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class HandSpec {

    @Test
    public void testValue(ArrayList<String> failures) {
        Hand hand = new Hand();
        Card card_1 = new Card(1,"Ace",Suits.SPADES);
        Card card_2 = new Card(11,"Jack",Suits.DIAMONDS);
        hand.add(card_1);
        hand.add(card_2);

        try {
            //Test First Card
            Card card  = hand.peek()[0];
            assertEquals(1, card_2.get_value());
            assertEquals("Ace", card_2.get_name());
            assertEquals(Suits.SPADES, card_2.get_suit());

            //Test Second Card
            card = hand.peek()[1];
            assertEquals(11, card_2.get_value());
            assertEquals("Jack", card_2.get_name());
            assertEquals(Suits.DIAMONDS, card_2.get_suit());
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + 'F' + ANSI_RESET);
            failures.add("it creates a hand with the correct values");
        }
    }

    public static void main(String args[]) {
        return;
    }
}
