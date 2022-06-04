package org.example.seawar.AssistClasses;

public class SendSymbolAndCoord {
    private int x;
    private int y;
    private String symbol;

    public SendSymbolAndCoord() {

    }

    public SendSymbolAndCoord(int x, int y, String symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
