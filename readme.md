# Ultimate Tic-Tac-Toe

* You can run game with run **uttt.game.Main**
* You can find detail description in file **Java_Ultimate_Tic_Tac_Toe.pdf**

## Description

Ultimate Tic-Tac-Toe is a more complex version of the classic Tic-Tac-Toe game. Instead of playing on a single 3x3 grid,
you play on a larger 9x9 grid, which is divided into nine smaller 3x3 grids.

The objective is to win the game by getting three of your marks (either X or O) in a row, either horizontally,
vertically, or diagonally, within one of the smaller grids.

However, there's a twist: the position you play in a smaller grid determines which grid your opponent must play in next.
If your move sends your opponent to a grid that is already won or full, they can choose any open grid.

The game continues until one player wins the overall game by completing three grids in a row, or the entire game board
fills up and the game ends in a draw.

## Gameplay Rules

The board is composed of 9 Tic-Tac-Toe grids arranged in a 3x3 grid. Here's how the game is played:

1. The game starts with the first player placing their mark (X or O) in any cell of any smaller board.
2. The move made by a player determines the board on which the next player must play. For example, if the first player
   places their mark in the top right cell of a small board, the next player must play on the top right small board.
3. This rule continues, meaning the position of a move within a small board dictates where the next move must be made
   within the larger board.
4. To win a small board, a player must get three of their marks in a row, either horizontally, vertically, or
   diagonally, just like traditional Tic-Tac-Toe.
5. The larger game is won by winning three small boards in a row, either horizontally, vertically, or diagonally.
6. If a player is supposed to make a move on a small board that is already won or drawn (entirely filled), they can
   choose to play on any board that is not won or drawn.
7. The game ends when a player wins the larger board by completing three small boards in a row or there are no legal
   moves left, resulting in a draw.

### Figures illustrates 4 sample Ultimate Tic-Tac-Toe gameplay moves:

![screen1.png](src%2Fmain%2Fresources%2Fscreen1.png)
![screen2.png](src%2Fmain%2Fresources%2Fscreen2.png)
![screen3.png](src%2Fmain%2Fresources%2Fscreen3.png)
![screen4.png](src%2Fmain%2Fresources%2Fscreen4.png)