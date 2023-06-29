package cards;

import enums.EnumColor;

public abstract class Card {
    protected EnumColor color;

    public Card(EnumColor color){
        this.color = color;
    }

    public EnumColor getColor() {
        return color;
    }

    public boolean canPlay(Card card){
        return color == card.color;
    }

    @Override
    public String toString() {
        return color +"%s\u001B[0m";
    }
}
