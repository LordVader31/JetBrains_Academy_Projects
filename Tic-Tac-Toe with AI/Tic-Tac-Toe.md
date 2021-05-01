# Tic-Tac-Toe with AI

This package contains a working model of a Tic-Tac-Toe game engine. The human player gets to decide whether they want a 
* Human vs. Human 
* Human vs. Engine
* Engine vs. Engine

There 3 levels of Engines :
* Easy - which plays random moves
* Medium - which plays sensibly (i.e it blocks opponent's winning moves and attempts to find a winning combination)
* Hard - which plays perfectly (according to the [minimax algorithm](https://www.freecodecamp.org/news/how-to-make-your-tic-tac-toe-game-unbeatable-by-using-the-minimax-algorithm-9d690bad4b37/))

To clarify, only the name of the project says AI, there is **no ML / Reinforcement Learning models built in.**

## How To Play
The inital prompt is the input command(s). This can be one of two options 
* `start [player1Type] [player2Type]` - allows the game to start with player 1 and player 2 as specified.
* `exit` - quits the game

Now there are 3 types of players - `easy, medium, hard, user`. So if my input command is `start medium user` then Player 1 (X) will be the Medium engine and Player 2 (O) will be the user (you will be prompted to enter the coordinates). If I choose `start easy hard` then the first player (X) will be an Easy engine and the second player (O) will be the Hard engine. You can only spectat this game.

If you choose `user` then a prompt to enter the coordinates will appear when it is your turn. An appropriate error message will be displayed if you enter wrong coordinates or coordiantes of an occupied square.

Note that the Hard Engine is **unbeatable** (i.e you can only draw and lose against it). It will always play perfectly.

### Board 
The board will be by default a 3x3 TicTacToe board but you are free to change this by changing the object instantiation. The board will be displayed as 
```
----------
|        |
|        |
|        |
----------
```
The rows start from 1 to 3 from left to right and columns are from 1 to 3 from top to bottom. So if I enter the coordinates `13` and I am player 1 then the updated board will be.
```
----------
|      X |
|        |
|        |
----------
```

### References 

[1] DavidHurst's [repository](https://github.com/DavidHurst/MiniMax-TicTacToe-Java) on Tic-Tac-Toe.
