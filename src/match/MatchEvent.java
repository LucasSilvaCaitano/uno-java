package match;

import cards.WildCard;

public class MatchEvent {
    private Match match;

    public MatchEvent(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    public void changeColorEvent(WildCard wildCard, int color){
        switch (color){
            case 1:

        }
    }
}
