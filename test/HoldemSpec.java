/* Alex Rinker
 * HoldemSpec.java
 */

import java.util.*;
import holdem.*;

public class HoldemSpec {

  public void HandSpec() {
    Card card = new Card(2, "Two", Suits.DIAMONDS);
  }

  public static void main(String args[]) {
    System.out.println("Running All Tests");
    HoldemSpec test = new HoldemSpec();
    test.HandSpec();
  }
}
