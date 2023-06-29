package player;

import cards.Card;
import decks.Deck;
import decks.Stack;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    private boolean bloqued;

    public Player(Deck deck){
        hand = new ArrayList();

        buyCards(deck, 7);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void buyCards(Deck deck, int qtd){
        for (int i = 0; i < qtd; i++) {
            hand.add(deck.giveCard());
        }
    }

    public void setBloqued(boolean bloqued){
        this.bloqued = bloqued;
    }

    public boolean isBloqued(){
        return bloqued;
    }

    public boolean placeCard(int cardIndex, Stack stack){
        Card card = hand.get(cardIndex);
        Card anotherCard = stack.getTop();

        if(card.canPlay(anotherCard)) {
            stack.addCard(hand.remove(cardIndex));
            return true;
        }

        return false;
    }

    public boolean mustBuy(Stack stack){
        for(Card card : hand)
            if(card.canPlay(stack.getTop()))
                return false;

        return true;

    }

    public Card getCard(int index){
        return hand.get(index);
    }
}
