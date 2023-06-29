package cards;

import enums.EnumColor;
import enums.EnumSymbol;
import listeners.PlayListener;
import match.Match;

public class SpecialCard extends Card implements PlayListener{
    private EnumSymbol symbol;

    private PlayListener playListener;

    public SpecialCard(EnumColor color, EnumSymbol symbol, PlayListener playListener) {
        super(color);
        this.symbol = symbol;
        this.playListener = playListener;
    }

    public EnumSymbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean canPlay(Card card) {
        return super.canPlay(card) ||
                (card instanceof SpecialCard &&
                        ((SpecialCard) card).symbol == symbol);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), symbol);
    }

    @Override
    public void playEvent(Match math) {
        playListener.playEvent(math);
    }
}
