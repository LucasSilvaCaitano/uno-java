package enums;

public enum EnumSymbol {
    PLUS_2("+2"), BLOCK("Ø"), REVERT("↕");

    private String symbol;

    EnumSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
