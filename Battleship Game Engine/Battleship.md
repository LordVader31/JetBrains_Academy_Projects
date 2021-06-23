## Battleship Game Engine

This package contains a fully functioning Player v. Player Battleship Game engine that can 
* Print the battlefield(s)
* Allow players to place their ships (according to the rules of the game)
* Allow players to strategically bomb their enenmies battlefield

The rules of the game are given here : [Battleship Rules of the Game](https://www.mombooks.com/wp-content/uploads/Games-from-Childhood.pdf)

## How-To-Play
This guides the reader on how to use the Battleship text-based game engine. This is a classic PvP match consisting of 2 parts - Setup and Wartime.

#### Setup
 During setup, Player 1 is prompted first to place his/her ships on the battlefield. When prompted to do so a picture of the current battlefield arrangement will be shown and the user must type the first coordinate on the first line and the second coordinate on the second line.  
* The Row letter must be followed by the Column number with no gaps between them
* After typing the first coordinates, press Enter and type the second coordinates.
* Only horizontal and vertical placements are legal

Remember to examine the length of the ship and the corresponding coordinates. _(You can't fit a Battleship (4 cells) in a space of 3 cells).
For example:

```
 1 2 3 4 5 6 7 8 9 10 
A O O O O O ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 


Enter the coordinates of the Battleship (4 cells): 
D9
G9

  1 2 3 4 5 6 7 8 9 10 
A O O O O O ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ O ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ O ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ O ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ O ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 


Enter the coordinates of the Submarine (3 cells): 

```

An approriate error message will be displayed if there is something wrong with the input. This occurs when :
* The specified coordinates are too small or too large for the ship
* The coordinates are invalid (eg. letters > J or numbers outside the 1 to 10 range)
* The ships are touching each other (only touching diagonally is legal).

Once Player 1 has completed setup, **double press the Enter key** and pass it one to Player 2 who must repeat the Setup proces.

#### Wartime
For Wartime, Player 1 wil go first. Player 1 will be shown Player 2's "Fog of War" screen at the top and they have to guess where they want to fire. Under P2 FOW is a divider and P1's own ship layout. P1 will guess where to fire and if they hit a ship they will see that part marked with the HIT character whether that be X or (any character that is designated by the programmer). 

This is then followed by an enter prompt which generated as large amount of space and then Player 2 will play. **Now the obvious problem here is that if P2, scrolls enough then they will see P1s guess and ships, so one must trust the other to play fairly**. The following example denotes a possible scenario:

```
  1 2 3 4 5 6 7 8 9 10 
A X ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

--------------------
  1 2 3 4 5 6 7 8 9 10 
A X O O O O ~ ~ ~ ~ O 
B ~ M ~ ~ ~ ~ ~ O ~ O 
C ~ ~ ~ ~ ~ ~ ~ O ~ O 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G O O O ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I O O O O ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Player 2, it's your turn:
a2

  1 2 3 4 5 6 7 8 9 10 
A X X ~ ~ ~ ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

You hit a ship! 
Press Enter and pass the move to another player
```

The game goes on until one players sinks all the ships of the other player. The appropriate celebratory message with the winning player is displayed and then the game stops.
