package uttt.game.impl;

import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class MarkInterfaceImpl implements MarkInterface {

    private Symbol symbol;
    private final int position;

    public MarkInterfaceImpl(Symbol symbol, int position) {
        if (position < 0 || position > 8) {
            throw new IllegalArgumentException();
        }
        this.symbol = symbol;
        this.position = position;
    }

    @Override
    public Symbol getSymbol() {
        return this.symbol;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public void setSymbol(Symbol symbol) throws IllegalArgumentException {
        if (this.symbol == Symbol.CIRCLE || this.symbol == Symbol.CROSS) {
            throw new IllegalArgumentException();
        }
        this.symbol = symbol;
    }

}
