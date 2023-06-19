package uttt.game.impl;

import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class BoardInterfaceImpl implements BoardInterface {

    private MarkInterface[] markInterfaces;

    public BoardInterfaceImpl(MarkInterface[] markInterfaces) {
        if (markInterfaces.length != 9) {
            throw new IllegalArgumentException();
        }
        this.markInterfaces = markInterfaces;
    }

    @Override
    public MarkInterface[] getMarkInterfaces() {
        return this.markInterfaces;
    }

    @Override
    public void setMarkInterfaces(MarkInterface[] markInterfaces) throws IllegalArgumentException {
        if (markInterfaces.length != 9) {
            throw new IllegalArgumentException();
        }
        this.markInterfaces = markInterfaces;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {
        if (isMovePossible(markIndex)) {
            markInterfaces[markIndex].setSymbol(symbol);
            return true;
        }

        return false;
    }

    @Override
    public boolean isClosed() {
        // Win:
        if (horiz(0) || horiz(3) || horiz(6)) {
            return true;
        }
        if (vert(0) || vert(1) || vert(2)) {
            return true;
        }
        if (diag1() || diag2()) {
            return true;
        }

        return false;

    }

    @Override
    public boolean isMovePossible(int markIndex) throws IllegalArgumentException {
        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException();
        }

        return !isClosed() && this.markInterfaces[markIndex].getSymbol() == Symbol.EMPTY;
    }

    @Override
    public Symbol getWinner() {
        if (horiz(0))
            return this.markInterfaces[0].getSymbol();
        if (horiz(3))
            return this.markInterfaces[3].getSymbol();
        if (horiz(6))
            return this.markInterfaces[6].getSymbol();
        if (vert(0))
            return this.markInterfaces[0].getSymbol();
        if (vert(1))
            return this.markInterfaces[1].getSymbol();
        if (vert(2))
            return this.markInterfaces[2].getSymbol();
        if (diag1())
            return this.markInterfaces[0].getSymbol();
        if (diag2())
            return this.markInterfaces[2].getSymbol();

        return Symbol.EMPTY;

    }

    private boolean horiz(int i) {
        return this.markInterfaces[i].getSymbol() == this.markInterfaces[i + 1].getSymbol()
                && this.markInterfaces[i].getSymbol() == this.markInterfaces[i + 2].getSymbol()
                && this.markInterfaces[i].getSymbol() != Symbol.EMPTY;
    }

    private boolean vert(int i) {
        return this.markInterfaces[i].getSymbol() == this.markInterfaces[i + 3].getSymbol()
                && this.markInterfaces[i].getSymbol() == this.markInterfaces[i + 6].getSymbol()
                && this.markInterfaces[i].getSymbol() != Symbol.EMPTY;
    }

    private boolean diag1() {
        boolean a = this.markInterfaces[0].getSymbol() == this.markInterfaces[4].getSymbol()
                && this.markInterfaces[0].getSymbol() == this.markInterfaces[8].getSymbol()
                && this.markInterfaces[0].getSymbol() != Symbol.EMPTY;

        return a;
    }

    private boolean diag2() {
        boolean b = this.markInterfaces[2].getSymbol() == this.markInterfaces[4].getSymbol()
                && this.markInterfaces[2].getSymbol() == this.markInterfaces[6].getSymbol()
                && this.markInterfaces[2].getSymbol() != Symbol.EMPTY;
        return b;
    }
}
