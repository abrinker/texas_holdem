/* Alex Rinker
 * AutoHoldem.java
 */

import java.util.*;

//Simulates one automated game of Texas holdem
public class AutoHoldem {
  private ArrayList<Hand> players;
  private CommunityCards community;
  private Deck deck;

  //Constructor
  public AutoHoldem(int numPlayers) {
    this.deck = new Deck();
    this.players = new ArrayList<Hand>();
    for (int i=0;i<numPlayers;i++) {
      this.players.add(new Hand());
    }

    this.community = new CommunityCards();

    this.deck.shuffle();
  }

  //Dealing mechanism
  public void deal() {
    for (int i=0;i<2;i++) {
      for (int j=0;j<this.players.size();j++) {
        this.players.get(j).add(this.deck.draw());
      }
    }
  }

  //Flop mechanism
  public void flop() {
    this.deck.discard(this.deck.draw());
    for (int i=0;i<3;i++) {
      this.community.add(this.deck.draw());
    }
  }

  //Turn and River
  public void turn_river() {
    this.deck.discard(this.deck.draw());
    this.community.add(this.deck.draw());
  }

  //Folding mechanism
  public void fold(int player) {
    Hand hand = this.players.get(player);
    int size = hand.size();
    for (int i=0;i<size;i++) {
      this.deck.discard(hand.remove());
    }
  }

  //prints a nice readable string of the game
  public String toString() {
    String temp = "";
    temp += this.deck.toString() + "\n";
    temp += this.community.toString() + "\n";
    for (Hand player : this.players) {
      temp += player.toString() + "\n";
    }
    return temp;
  }

  //Prints a nice pretty string of the game table
  public String prettify() {
    String temp = "";
    temp += this.community.prettify() + "\n";
    for (Hand player : this.players ) {
      temp += player.prettify() + "\n";
    }
    return temp;
  }

  //Main
  public static void main(String args[]) {
    System.out.println("Plays one 'round' of holdem for test purposes");
    AutoHoldem game = new AutoHoldem(2);
    game.deal();
    game.flop();
    game.turn_river();
    game.turn_river();
    System.out.println(game);
    System.out.println(game.prettify());
    game.fold(1);
  }
}
