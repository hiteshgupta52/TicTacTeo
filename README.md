# Tic Tac Toe kata

## Instructions

### How to run the tests

From the main root you can use maven to execute the tests, running

    mvn clean test

### How to build an executable jar file

From the main root run

    mvn clean install


### Launch the jar application

Go to the folder

TicTacTeo\target

and run

    java -jar TicTacTeo-0.0.1-SNAPSHOT.jar


### How to play the game

Two players can play the game.

Each player will select the position by selecting the number in between 1-9.

Player X starts.

The game ends when either three consecutive fields have been taken by a player, or when all the fields have been taken.

if already player selected the already marked position he will be asked to re-enter another number from 1-9 range. This process will be continued either any of the result occur WIN OR DRAW. 