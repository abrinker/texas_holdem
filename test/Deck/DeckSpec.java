/* Alex Rinker
 * DeckSpec.java
 */

package holdemSpec;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class DeckSpec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Test
    public void test_build(ArrayList<String> failures) {
        Deck deck = new Deck();
        Card temp;
        List<String> values = Arrays.asList("Ace","Two","Three","Four","Five","Six","Seven","Eight",
                                            "Nine","Ten","Jack","Queen","King");
        try {
            for (Suits suit : Suits.values()) {
                for(int i=1;i<14;i++){
                    temp = new Card(i, values.get(i-1), suit);
                    assertEquals(true, deck.contains(temp));
                }
            }
            System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + "F" + ANSI_RESET);
            failures.add("Deck contains all 52 individual cards");
        }
    }

    @Test
    public void test_draw_discard(ArrayList<String> failures) {
        Deck deck = new Deck();
        Card card;

        try {
            card = deck.draw();
            assertEquals(false, deck.contains(card));
            deck.discard(card);
            assertEquals(true, deck.get_discard().get(0).get_value() == card.get_value());
            System.out.printf(ANSI_GREEN + "." + ANSI_RESET);
        }
        catch (Exception e) {
            System.out.printf(ANSI_RED + "F" + ANSI_RESET);
            failures.add("Deck properly draws and discards");
        }
    }

    //TODO, add a shuffle test

    //TODO, add a reset test

    public void run_tests(ArrayList<String> failures) {
        this.test_build(failures);
        this.test_draw_discard(failures);
    }

    public static void main(String args[]) {
        return;
    }
}
