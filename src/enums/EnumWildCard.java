package enums;

public enum EnumWildCard {
    CHANGE_COLOR_PLUS_4("+4"), CHANGE_COLOR("any");

    private String symbol;

    EnumWildCard(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
