/* Alex Rinker
 * CardSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class CardSpec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Test
    public void test_value(ArrayList<String> failures) {
        Card card = new Card(2, "Two", Suits.DIAMONDS);
        try {
            assertEquals(2, card.get_value());
            assertEquals("Two", card.get_name());
            assertEquals(Suits.DIAMONDS, card.get_suit());
            System.out.printf(ANSI_GREEN + '.' + ANSI_RESET);
        } catch (Exception e) {
            System.out.printf(ANSI_RED + 'F' + ANSI_RESET);
            failures.add(
                         "it creates a card with the correct suit " +
                         " value, and name"
                        );
        }
    }

    public void run_tests(ArrayList<String> failures) {
        this.test_value(failures);
    }

    public static void main(String args[]) {
        return;
    }
}
