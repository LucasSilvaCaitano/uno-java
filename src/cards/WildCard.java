package cards;

import enums.EnumColor;
import enums.EnumWildCard;
import listeners.PlayListener;
import match.Match;

public class WildCard extends Card implements PlayListener{
    private EnumWildCard symbol;
    private PlayListener playListener;

    public WildCard(EnumWildCard symbol, PlayListener playListener) {
        super(null);
        this.symbol = symbol;
        this.playListener = playListener;
    }

    public void setCor(EnumColor color){
        this.color = color;
    }
    @Override
    public boolean canPlay(Card card) {
        return true;
    }

    public boolean hasColor(){
        return color != null;
    }

    @Override
    public String toString() {
        if(color ==null)
            return symbol.toString();
        return String.format(super.toString(), symbol);
    }

    @Override
    public void playEvent(Match math) {
        playListener.playEvent(math);
    }
}
