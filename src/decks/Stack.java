package decks;

import cards.Card;
import cards.NumericCard;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Card> placedCards;
    
    public Stack(Deck deck){
        placedCards = new ArrayList();
        Card card = deck.giveCard();
        while (!(card instanceof NumericCard)){
            deck.addBottom(card);
            card = deck.giveCard();
        }

        addCard(card);
    }

    public Card getTop(){
        return placedCards.get(placedCards.size()-1);
    }

    public void addCard(Card card){
        placedCards.add(card);
    }

    public void empty(Deck deck){
        deck.add(placedCards);
    }
}
