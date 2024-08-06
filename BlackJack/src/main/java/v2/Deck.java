package v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    List<Integer> deck = new ArrayList<>(52);
    public void setDeck(){
        if(deck.size()<=10) {
            deck = new ArrayList<>();
            for (int i = 1; i < 12; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.add(i);
                }
            }

            for (int i = 0; i < 12; i++) {
                deck.add(11);
            }

            Collections.shuffle(deck);
        }
    }
    public int getCard() {
        return deck.remove(0);
    }

    public List<Integer> showCards(int i) {
        return deck.subList(0,5);
    }
}
