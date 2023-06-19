package uttt.game.impl;

import uttt.game.PlayerInterface;
import uttt.game.SimulatorInterface;
import uttt.game.UserInterface;
import uttt.utils.Move;
import uttt.utils.Symbol;

public class PlayerInterfaceImpl implements PlayerInterface {

    private Symbol playerSymbol;

    public PlayerInterfaceImpl(Symbol symbol) {
        this.playerSymbol = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return this.playerSymbol;
    }

    @Override
    public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {

        if (game == null)
            throw new IllegalArgumentException();

        Move move;

        move = ui.getUserMove();

        return move;

    }

}
