package match;

import cards.Card;
import decks.Deck;
import decks.Stack;
import listeners.PlayListener;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Player> players;
    private boolean isReversed;
    private Deck deck;
    private int indexCurrentPlayer;
    private Stack playedCards;

    public Match(int playersQuantity){
        deck = new Deck();
        players = new ArrayList();
        isReversed = false;
        indexCurrentPlayer = 0;

        for (int i = 0; i < playersQuantity; i++) {
            players.add(new Player(deck));
        }

        playedCards = new Stack(deck);
    }

    public Deck getDeck(){
        return deck;
    }

    public void addCard(int cardIndex){
        if(getCurrentPlayer().placeCard(cardIndex, playedCards)) {
            if(getLastCard() instanceof PlayListener){
                ((PlayListener) getLastCard()).playEvent(this);
            }
            changePlayerIndex();

            return;
        }

        System.out.println("Não pode jogar essa carta");
    }

    public void buyCard(){
        while (getCurrentPlayer().mustBuy(playedCards))
            getCurrentPlayer().buyCards(deck, 1);
    }

    public void changePlayerIndex(){
        indexCurrentPlayer = getNextIndexPlayer();
        if(getCurrentPlayer().isBloqued()){
            getCurrentPlayer().setBloqued(false);
            indexCurrentPlayer = getNextIndexPlayer();
        }
    }

    public Player getCurrentPlayer(){
        return players.get(indexCurrentPlayer);
    }

    public Player getNextPlayer(){
        return players.get(getNextIndexPlayer());
    }

    public int getNextIndexPlayer(){
        if(!isReversed){
            return (indexCurrentPlayer+1) % players.size();
        }
        if(isReversed && indexCurrentPlayer==0){
            return indexCurrentPlayer = players.size()-1;
        }

        return indexCurrentPlayer-1;

    }

    public Card getLastCard(){
        return playedCards.getTop();
    }

    public void reverse(){
        isReversed = !isReversed;
    }
}
