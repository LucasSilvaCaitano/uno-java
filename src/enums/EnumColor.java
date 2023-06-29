package enums;

public enum EnumColor {
    BLUE("\u001B[34m"), GREEN("\u001B[32m"), RED("\u001B[31m"),
    YELLOW("\u001B[33m");

    private String ansiCode;
    EnumColor(String ansiCode){
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
