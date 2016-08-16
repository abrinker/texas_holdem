/* Alex Rinker
 * HoldemSpec.java
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdemSpec.*;

public class HoldemSpec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    private ArrayList<String> failed_tests;

    public HoldemSpec() {
      this.failed_tests = new ArrayList<String>();
    }

    public int num_failed() {
        return this.failed_tests.size();
    }

    public void print_fails() {
        for (String failure : this.failed_tests) {
            System.out.println(ANSI_RED + failure + ANSI_RESET);
        }
    }

    public void run_tests() {
        CardSpec card = new CardSpec();
        HandSpec hand = new HandSpec();
        DeckSpec deck = new DeckSpec();
        CommunityCardsSpec community = new CommunityCardsSpec();

        //Run tests
        card.run_tests(this.failed_tests);
        hand.run_tests(this.failed_tests);
        deck.run_tests(this.failed_tests);
        community.run_tests(this.failed_tests);
    }

    public static void main(String args[]) {
        System.out.println("Running All Tests");
        HoldemSpec test = new HoldemSpec();
        test.run_tests();
        if (test.num_failed() == 0) {
            System.out.println("\nAll Tests Pass!");
        } else {
            System.out.println("\nFailing Tests:");
            test.print_fails();
        }
    }
  }
