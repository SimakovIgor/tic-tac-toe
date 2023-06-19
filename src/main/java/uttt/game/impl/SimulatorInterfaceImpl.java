package uttt.game.impl;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.PlayerInterface;
import uttt.game.SimulatorInterface;
import uttt.game.UserInterface;
import uttt.utils.Move;
import uttt.utils.Symbol;

public class SimulatorInterfaceImpl implements SimulatorInterface {

    private BoardInterface[] boardInterfaces;
    private Symbol currentPlayerSymbol;
    private int indexNextBoard;

    public SimulatorInterfaceImpl(BoardInterface[] boardInterfaces) {
        if (boardInterfaces.length != 9) {
            throw new IllegalArgumentException();
        }
        this.boardInterfaces = boardInterfaces;
        this.indexNextBoard = -1;
        this.currentPlayerSymbol = Symbol.EMPTY;
    }

    @Override
    public BoardInterface[] getBoards() {
        return this.boardInterfaces;
    }

    @Override
    public void setBoards(BoardInterface[] boardInterfaces) throws IllegalArgumentException {
        if (boardInterfaces.length != 9) {
            throw new IllegalArgumentException();
        }

        this.boardInterfaces = boardInterfaces;
    }

    @Override
    public Symbol getCurrentPlayerSymbol() {
        return currentPlayerSymbol;
    }

    @Override
    public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
        currentPlayerSymbol = symbol;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
        if (!isMovePossible(boardIndex)) {
            return false;
        }

        if (currentPlayerSymbol == symbol) {
            if (boardInterfaces[boardIndex].setMarkAt(symbol, markIndex)) {
                setIndexNextBoard(markIndex);
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIndexNextBoard() {
        return indexNextBoard;
    }

    @Override
    public void setIndexNextBoard(int index) throws IllegalArgumentException {
        if (index < 0 || index > 8) {
            throw new IllegalArgumentException("Illegal board index: " + index);
        }
        if (boardInterfaces[index].isClosed()) {
            indexNextBoard = -1;
        } else {
            indexNextBoard = index;
        }
    }

    @Override
    public boolean isGameOver() {
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
    public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex > 8) {
            throw new IllegalArgumentException("Illegal board index: " + boardIndex);
        }

        if (boardInterfaces[boardIndex] == null) {
            throw new IllegalArgumentException("Board on position: " + boardIndex + " did not created");
        }

        return boardIndex == this.indexNextBoard || this.indexNextBoard == -1;
    }

    @Override
    public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {

        if (!(boardIndex >= 0 && boardIndex < 9 && markIndex >= 0 && markIndex < 9
                && this.boardInterfaces[boardIndex] != null)) // ?????????????????
            throw new IllegalArgumentException();

        if ((boardIndex == this.indexNextBoard || this.indexNextBoard == -1)
                && this.boardInterfaces[boardIndex].getMarkInterfaces()[markIndex].getSymbol() == Symbol.EMPTY) {
            return true;
        }

        return false;

    }

    @Override
    public Symbol getWinner() {
        if (horiz(0))
            return this.boardInterfaces[0].getWinner();
        if (horiz(3))
            return this.boardInterfaces[3].getWinner();
        if (horiz(6))
            return this.boardInterfaces[6].getWinner();
        if (vert(0))
            return this.boardInterfaces[0].getWinner();
        if (vert(1))
            return this.boardInterfaces[1].getWinner();
        if (vert(2))
            return this.boardInterfaces[2].getWinner();
        if (diag1())
            return this.boardInterfaces[0].getWinner();
        if (diag2())
            return this.boardInterfaces[2].getWinner();

        return Symbol.EMPTY;
    }

    @Override
    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
            throws IllegalArgumentException {

        SimulatorInterface game = UTTTFactory.createSimulator();
        game.setCurrentPlayerSymbol(playerOne.getSymbol());

        while (!game.isGameOver()) {
            ui.updateScreen(game);
            Move move = ui.getUserMove();

            if (game.getCurrentPlayerSymbol() == playerOne.getSymbol()) {
                if (game.setMarkAt(playerOne.getSymbol(), move.getBoardIndex(), move.getMarkIndex())) {
                    game.setCurrentPlayerSymbol(playerTwo.getSymbol());
                }
            } else {
                if (game.setMarkAt(playerTwo.getSymbol(), move.getBoardIndex(), move.getMarkIndex())) {
                    game.setCurrentPlayerSymbol(playerOne.getSymbol());
                }
            }

        }
        System.out.println("!!!!!!!!!!");
        ui.showGameOverScreen(game.getWinner());
    }

    private boolean horiz(int i) {
        return this.boardInterfaces[i].isClosed()
                && this.boardInterfaces[i + 1].isClosed()
                && this.boardInterfaces[i + 2].isClosed()
                && this.boardInterfaces[i].getWinner() ==  this.boardInterfaces[i + 1].getWinner()
                && this.boardInterfaces[i].getWinner() ==  this.boardInterfaces[i + 2].getWinner();
    }

    private boolean vert(int i) {
        return this.boardInterfaces[i].isClosed()
                && this.boardInterfaces[i + 3].isClosed()
                && this.boardInterfaces[i + 6].isClosed()
                && this.boardInterfaces[i].getWinner() ==  this.boardInterfaces[i + 3].getWinner()
                && this.boardInterfaces[i].getWinner() ==  this.boardInterfaces[i + 6].getWinner();
    }

    private boolean diag1() {
        return this.boardInterfaces[0].isClosed()
                && this.boardInterfaces[4].isClosed()
                && this.boardInterfaces[8].isClosed()
                && this.boardInterfaces[0].getWinner() ==  this.boardInterfaces[4].getWinner()
                && this.boardInterfaces[0].getWinner() ==  this.boardInterfaces[8].getWinner();
    }

    private boolean diag2() {
        return this.boardInterfaces[2].isClosed()
                && this.boardInterfaces[4].isClosed()
                && this.boardInterfaces[6].isClosed()
                && this.boardInterfaces[2].getWinner() ==  this.boardInterfaces[4].getWinner()
                && this.boardInterfaces[2].getWinner() ==  this.boardInterfaces[6].getWinner();
    }

}
