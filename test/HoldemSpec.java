/* Alex Rinker
 * HoldemSpec.java
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import holdemSpec.*;

public class HoldemSpec {
    private ArrayList<String> failed_tests;

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

    public void run_tests() {
        return; //TODO make it run all tests
    }

    public static void main(String args[]) {
        System.out.println("Running All Tests");
        HoldemSpec test = new HoldemSpec();
        if (test.num_failed() == 0) {
            System.out.println("All Tests Pass!");
        } else {
            System.out.println("Failing Tests:");
            test.print_fails();
        }
    }
  }
