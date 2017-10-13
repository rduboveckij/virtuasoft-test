# Hi-Lo card game engine

## Rules
* Hi-Lo is played with a standard single 52 deck of cards.
* The game is played with 2 players of more.
* Aces are low, so the order of cards are: A, 2, 3, 4 ,5 ,6 ,7, 8, 9, 10, J, Q, K.
* The deck of cards are shuffled before starting a game.
* Each player is dealt one card per round.
* The player with the highest card wins.
* A match consists of 5 games. The winner of match is the player who has won the most games.

## Model
### *Class HiLoGameCommands*
 Responsible for an interaction of players with the game by shell command interface.
### *Class HiLoGameService*
 Is a bridge with a game logic and players. Can start the game, menage players and know a winner.
 The game can be configure from this class.
### *Class HiLoGame*
 Is a core of a game logic, stores players, who play now, and decks and rounds of the games and a partial result.
### *Class Player*
 Is a player of the game with name, can be extended with personal statistic. *Should be serializable.*
### *Class Game*
 Should be rename to Round, It is a class for storing round results (winner and which cards had players). *Should be serializable.*
### *Class Deck*
 By default is classic deck with cards, but can different with missing cards for example. *Should be serializable.*
 Can shuffle a deck(Should create a new deck).
### *Class Card*
 It is a simple immutable dto which represent a real card with a suit and a rank. *Should be serializable.*
### *Enum Rank*
 It is a simple card rank, but with a score(Scores are hardcoded can be a problem for reusing)
### *Enum Suit*
 It is a simple card suit. 
  
## Features to be done
* Write a unit test.
* Fix problems with winners calculation.
* Add Spring shell command as a part of a test GUI.
* Cover all error cases.
* Refactored logic model to split immutable and stateful objects.
* Extract code reusable module(a general for card game).
* Make the game more configurable.