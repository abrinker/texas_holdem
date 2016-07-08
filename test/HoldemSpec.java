/* Alex Rinker
 * HoldemSpec.java
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HoldemSpec {

  @Test
  public void HandSpec() {
    Card card = new Card(2, "Two", Suits.DIAMONDS);
    assertEquals(2, card.get_value());
  }
}
