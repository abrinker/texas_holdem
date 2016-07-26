/* Alex Rinker
 * HandSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class HandSpec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Test
    public void test_add_remove(ArrayList<String> failures) {
       Hand hand = new Hand();
       Card card = new Card(1, "Ace", Suits.SPADES);

       try {
           assertEquals(0, hand.size());
           hand.add(card);
           assertEquals(1, hand.size());
           hand.remove();
           assertEquals(0, hand.size());
           System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
       }
       catch (Exception e) {
           System.out.printf(ANSI_RED + "F" + ANSI_RESET);
           failures.add("Hand properly adds and removes cards");
       }
    }

    @Test
    public void test_value(ArrayList<String> failures) {
        Hand hand = new Hand();
        Card card_1 = new Card(1, "Ace", Suits.SPADES);
        Card card_2 = new Card(11, "Jack", Suits.DIAMONDS);
        hand.add(card_1);
        hand.add(card_2);

        try {
            //Test First Card
            Card card  = hand.remove();
            assertEquals(1, card.get_value());
            assertEquals("Ace", card.get_name());
            assertEquals(Suits.SPADES, card.get_suit());

            //Test Second Card
            card = hand.remove();
            assertEquals(11, card.get_value());
            assertEquals("Jack", card.get_name());
            assertEquals(Suits.DIAMONDS, card.get_suit());
            System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + "F" + ANSI_RESET);
            failures.add("Hand creates a hand with the correct values");
        }
    }

    @Test
    public void test_peek(ArrayList<String> failures) {
        Hand hand = new Hand();
        Card card = new Card(1, "Ace", Suits.SPADES);
        hand.add(card);

        try {
            Card temp = hand.peek().get(0);
            assertEquals(1, card.get_value());
            assertEquals("Ace", card.get_name());
            assertEquals(Suits.SPADES, card.get_suit());
            assertEquals(1, hand.size());
            System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + "F" + ANSI_RESET);
            failures.add("Hand properly implements peek() method");
        }
    }

    public void run_tests(ArrayList<String> failures) {
        this.test_add_remove(failures);
        this.test_value(failures);
        this.test_peek(failures);
    }

    public static void main(String args[]) {
        return;
    }
}
