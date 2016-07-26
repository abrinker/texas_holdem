/* Alex Rinker
 * CardSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.CardSpec;

public class CardSpec {

    @Test
    public void testValue(ArrayList<String> failures) {
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

    public static void main(String args[]) {
        return;
    }
}
