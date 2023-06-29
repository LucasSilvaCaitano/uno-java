package decks;

import cards.Card;
import cards.SpecialCard;
import cards.NumericCard;
import cards.WildCard;
import enums.EnumColor;
import enums.EnumSymbol;
import enums.EnumWildCard;
import listeners.PlaceCardListenerRepository;

import java.util.*;

public class Deck {
    private ArrayDeque<Card> cards;

    public Deck(){
        cards = new ArrayDeque();

        for (EnumColor color: EnumColor.values()) {
            for (EnumSymbol symbol: EnumSymbol.values()) {
                cards.push(new SpecialCard(color, symbol,
                        PlaceCardListenerRepository.placeCardListenerHashMap.get(symbol.toString())));
            }
            cards.push(new NumericCard(color, 0));
        }

        for(EnumWildCard wildCard : EnumWildCard.values()){
            for (int i = 0; i < 4; i++) {
                cards.push(new WildCard(wildCard, PlaceCardListenerRepository
                        .placeCardListenerHashMap.get(wildCard.toString())));
            }
        }

        for (int i = 1; i < 10; i++) {
            for (EnumColor color: EnumColor.values()) {
                for (int j = 0; j < 2; j++) {
                    cards.push(new NumericCard(color, i));
                }
            }
        }

        shuffle();
    }

    public Card giveCard(){
        return cards.pop();
    }

    public void shuffle(){
        ArrayList<Card> shuffledCards = new ArrayList();
        while (!cards.isEmpty()){
            shuffledCards.add(cards.pop());
        }
        Collections.shuffle(shuffledCards);
        cards.addAll(shuffledCards);
    }

    public void add(ArrayList<Card> placedCards){
        for (int i = 0; i < placedCards.size()-2; i++) {
            cards.add(placedCards.get(i));
        }

        shuffle();
    }

    public void addBottom(Card card){
        cards.addLast(card);
    }
}
