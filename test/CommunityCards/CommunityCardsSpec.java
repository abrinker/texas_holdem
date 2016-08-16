/* Alex Rinker
 * CommunityCardsSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class CommunityCardsSpec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Test
    public void test_add_remove(ArrayList<String> failures) {
        CommunityCards cards = new CommunityCards();
        Card card = new Card(1, "Ace", Suits.DIAMONDS);

        try {
            assertEquals(null, cards.remove());
            cards.add(card);
            assertEquals(card, cards.peek().get(0));
            assertEquals(card, cards.remove());
            System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + "F" + ANSI_RESET);
            failures.add("Community cards properly adds and removes cards");
        }
    }

    public void run_tests(ArrayList<String> failures) {
        this.test_add_remove(failures);
    }

    public static void main(String args[]) {
        return;
    }
}
