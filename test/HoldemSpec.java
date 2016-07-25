/* Alex Rinker
 * HoldemSpec.java
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdem.*;

public class HoldemSpec {
    private ArrayList<String> failed_tests;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public HoldemSpec() {
      this.failed_tests = new ArrayList<String>();
    }

    public int num_failed() {
        return this.failed_tests.size();
    }

    public String print_fails() {
        for (String failure : this.failed_tests) {
            System.out.println(ANSI_RED + failure + ANSI_RESET);
        }
    }

    @Test
    public void CardSpec() {
        Card card = new Card(2, "Two", Suits.DIAMONDS);
        try {
            assertEquals(2, card.get_value());
            System.out.println(ANSI_GREEN + '.' + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + 'F' + ANSI_RESET);
            this.failed_tests.append("HandSpec testing Hand.java")
        }
    }

    public static void main(String args[]) {
        System.out.println("Running All Tests");
        HoldemSpec test = new HoldemSpec();
        test.HandSpec();
        if (test.num_failed() == 0) {
            System.out.println("All Tests Pass!");
        } else {
            System.out.println("Failing Tests:");
            test.print_fails();
        }
    }
  }
