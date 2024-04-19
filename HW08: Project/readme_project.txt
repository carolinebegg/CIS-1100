/****************************************************************************
* readme
* Final Project
****************************************************************************/

Name: Caroline Begg
PennKey: cbegg
Recitation: 205

/****************************************************************************
* the required files for this project as BrickBreaker.java, Stage.java, Brick.java,
Platform.java, Ball.java, extraLife.java, and levels.txt. In the 
command line, one should run java BrickBreaker [filename], as BrickBreaker.java is 
the file that should be run and the code reads in from a file. The given file for 
this code is called levels.txt. Each file contains a more in depth explanation of
its purpose and functionality. Addition features that were implemented include a
powerup that increases the number of lives the player has by 1, as well as a score
counter on the side. 

The descriptions of the file are below:

Stage.java
this file is the stage, or arena, for the game, where the other 
objects (Ball, Platform, Brick, and extraLife) are called, and where a majority of 
the actual game is written.

BrickBreaker.java
This file contains the main function for the BrickBreaker game. this
file controls the canvas size and the animation frame speed, and 
takes in a single command line arguement, which is a txt file that 
provides the data for setting up the game stage (provided in this 
example is the file level.txt). additionally, this file controls the 
timestep, calls several important functions from the Arena
class, and draws the final game screen after the player has finished
the game. it also contains the loop that allows the player to restart the game. 

Brick.java
this file contains the code that controls the individual bricks that
the player tries to destroy by hitting them with the ball. there are 
three different levels of bricks: the single hit point bricks, which
are light-colored and take only a single hit to destroy, the double 
hit bricks, which are medium-colored and take two hits to destroy,
and the triple hit bricks, which are dark-colored and take three hits
to destroy. this file also includes the relevant getter and setter 
functions for the various private variables, which allow them to be 
accessed in other files, such as Stage.java.  

Platform.java
this file contains the code that controls the moving platform that
is the initial position of the ball and also provides a space for 
the ball to bounce off of during the game. the movement of the 
platform is controlled by the player, as it will follow the x 
position of the player's cursor.

level.txt
this is the file that is read into for the level

extraLife.java
this is the file for the extra life power up. when hit, the player gains an extra 
life. 

an additional interesting feature is the endGameTester() function, which 
allows the user to automatically end the current game and restart a new one by
clicking the character 'a'. this function was originally just included to be used
as a helpful tool when i was developing the program, but i decided to leave it in 
because i found it helpful when playing the game to be able to easily restart at
the click of one key. 
****************************************************************************/