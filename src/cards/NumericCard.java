package cards;

import enums.EnumColor;

public class NumericCard extends Card {
    private int number;

    public NumericCard(EnumColor color, int number) {
        super(color);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean canPlay(Card card){
        return super.canPlay(card) ||
                (card instanceof NumericCard
                        && ((NumericCard) card).number == number);
    }


    @Override
    public String toString() {
        return String.format(super.toString(), number);
    }
}
