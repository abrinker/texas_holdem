/* Alex Rinker
 * Card.java
 */

import java.util.*;

//Simulates a playing card from a deck
public class Card {
  private int value;
  private String name;
  private Suits suit;

  //Constructor
  public Card(int val, String name, Suits suit) {
    this.value = val;
    this.name = name;
    this.suit = suit;
  }

  //Returns the value of the card
  public int get_value() {
    return this.value;
  }

  //Returns the suit of the card
  public Suits get_suit() {
    return this.suit;
  }

  //Returns the 'name' of the card e.g. 'Jack'
  public String get_name() {
    return this.name;
  }

  //Returns a simple string representing the card
  public String toString() {
    return this.name + " of " + this.suit;
  }

  //Returns a prettified string
  public String prettify() {
    String ascii = "";
    String number = Integer.toString(this.value);
    //Replace special cards with special chars
    switch (number) {
      case "1":
        number = "A";
        break;
      case "10":
        number = "T";
        break;
      case "11":
        number = "J";
        break;
      case "12":
        number = "Q";
        break;
      case "13":
        number = "K";
        break;
    }
    //Get the ascii symbol for suit
    switch (this.suit) {
      case SPADES:
        ascii = "\u2660";
        break;
      case DIAMONDS:
        ascii = "\u2666";
        break;
      case CLUBS:
        ascii = "\u2663";
        break;
      case HEARTS:
        ascii = "\u2764";
        break;
    }
    return (this.suit == Suits.HEARTS) ? ("|" + ascii + "    |\n" +
                                    "|  " + number + "  |\n" +
                                    "|   " + ascii + " |\n") :
                                   ("|" + ascii + "    |\n" +
                                    "|  " + number + "  |\n" +
                                    "|    " + ascii + "|\n");
  }

  //Main
  public static void main(String args[]) {
    System.out.println("Generates a random number from 1-10 and assigns it to a new card\n" +
                       "Then prints out the value of the card using the accessor method");
    Card card = new Card(1, "Ace", Suits.HEARTS);
    System.out.println(card);
    System.out.println(card.prettify());
    card = new Card(10, "Ten", Suits.DIAMONDS);
    System.out.println(card);
    System.out.println(card.prettify());
    card = new Card(11, "Jack", Suits.CLUBS);
    System.out.println(card);
    System.out.println(card.prettify());
    card = new Card(12, "Queen", Suits.SPADES);
    System.out.println(card);
    System.out.println(card.prettify());
  }
}
