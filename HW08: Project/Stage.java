/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Execution: none
* 
* Description: this file is the stage, or arena, for the game, where the other 
*              objects (Ball, Platform, Brick, and extraLife) are called, 
*              and where a majority of the actual game is written.
*/

public class Stage {
    // width and height of PennDraw screen
    private double width, height;
    
    // all the bricks in the game stage
    private Brick[] bricks;
    
    // the one and only ball in the game
    private Ball ball;
    
    // the one and only platform in the game
    private Platform platform;

    // all the extra life powerups
    private ExtraLife[] extra;
    
    // waiting for user to launch ball and begin the game
    private boolean setStartScreen;
    private boolean mouseListeningMode;
    private boolean mouseWasPressedLastUpdate;
    
    private boolean flyingMode;
    private boolean fallingMode;

    private int hitPointsSum;
    private int counter;

    public Stage(String filename) {
        In in = new In(filename);
        int numBricks = in.readInt();
        int numExtras = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
        int numLives = in.readInt();
        
        bricks = new Brick[numBricks];
        for (int i = 0; i < bricks.length; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double length = in.readDouble();
            int hitPoints = (int) (Math.floor(Math.random() * 3.9));

            bricks[i] = new Brick(width, height, xPos, yPos, length, hitPoints);
        }

        extra = new ExtraLife[numExtras];
        for (int i = 0; i < extra.length; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double radius = 0.25;
            int hitPoints = 1;
            extra[i] = new ExtraLife(xPos, yPos, radius, hitPoints);
        }

        PennDraw.setXscale(0, width);
        PennDraw.setYscale(0, height);
        
        this.ball = new Ball(width, height, 5.0, 0.5, 0.15, numLives);
        this.platform = new Platform(5.0, 1.0);
        
        setStartScreen = true;
        mouseListeningMode = false;
        mouseWasPressedLastUpdate = false;
        
        flyingMode = false;
        fallingMode = false;
        
        in.close();
    }

    /** END OF GAME FUNCTIONS
    * This section contains the end of game functions;
    * specifically, these are didPlayerWin(), 
    * didPlayerLose(), gameOver(), restartGame(), and
    * resetGame()
    */

    /**
    * Inputs: none
    * Outputs: boolean
    * Description: returns true or false, depending on whether the player has won
    *              the game
    */
    private boolean didPlayerWin() {
        if (getHitPointsSum() - counter <= 0) {
            return true;
        }
        return false;
    }
    
    /**
    * Inputs: none
    * Outputs: boolean
    * Description: returns true or false, depending on whether the player has lost
    *              the game
    */
    private boolean didPlayerLose() {
        if (mouseListeningMode) {
            if ((ball.getNumLives() == 0) && (getHitPointsSum() > 0)) {
                return true;
            }
        }
        return false;
    }
    
    /**
    * Inputs: none
    * Outputs: boolean
    * Description: returns true or false, depending on whether the player has 
    *              finished the game 
    */
    public boolean gameOver() {
        if (didPlayerWin() || didPlayerLose()) {
            return true;
        }
        if (setStartScreen) {
            return false;
        }
        return false;
    }
    /**
    * Inputs: none
    * Outputs: none
    * Description: draws the final game screen for when called for whether a player
    *              won or lost the game
    *              
    */
    public void drawFinalGameScreen() {
        PennDraw.setPenColor(PennDraw.WHITE);
        if (didPlayerWin()) {
            PennDraw.text(5, 2.5, "You win! Great job!");
            PennDraw.text(5, 2.25, "Would you like to play again?");
            PennDraw.text(5, 2.0, "Press the space bar!");
        }
        else {
            PennDraw.text(5, 2.5, "You ran out of lives...");
            PennDraw.text(5, 2.25, "Would you like to play again?");
            PennDraw.text(5, 2.0, "Press the space bar!");
        }
        PennDraw.advance();
    }

    /**
    * Inputs: none
    * Outputs: boolean
    * Description: returns whether the user has tried to restart the game
    */
    public boolean restartGame() {
        if (PennDraw.mousePressed()) {
            setStartScreen = true;
            return true;
        }
        return false;
    }

    /**
    * Inputs: none
    * Outputs: none
    * Description: resets the game values so that the player can play again
    */
    public void resetGame() {
        ball.setNumLives();
        scoreReset();
        platform.reset();
        for (int i = 0; i < bricks.length; i++) {
            bricks[i].setHitPoints((int) (Math.floor(Math.random() * 3.9)));
        }
        for (int i = 0; i < extra.length; i++) {
            extra[i].setHitPoints();
        }
        hitPointsSum = 0;
    }

    /**
    * Inputs: none
    * Outputs: none
    * Description: draws the opening screen for the game
    */
    public void drawStartScreen() {
        if (setStartScreen) {
            PennDraw.clear();
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.text(5.0, 2.5, "Welcome to BrickBreaker!");
            PennDraw.text(5.0, 2.25, "Click anywhere to begin");
        }
        else {
            PennDraw.clear();
        }
        PennDraw.advance();
    }
    
    /**
    * Inputs: double timeStep
    * Outputs: none
    * Description: updates Stage functions
    */
    public boolean getSetStartScreen() {
        return setStartScreen;
    }

    /**
    * Inputs: none
    * Outputs: none
    * Description: calls the two end of game boolean functions (didPlayerWin() and 
    *              didPlayerLose()) and returns a message and screen depending on 
    *              whether the player wins or loses
    */
    public void drawEndScreen() {
        PennDraw.clear();
        PennDraw.setPenColor(PennDraw.BLACK);
        if (didPlayerWin()) {
            PennDraw.text(5.0, 2.5, "Congratulations! You have won!");
            PennDraw.text(5.0, 2.25, "Click anywhere to play again");
            PennDraw.advance();
        }
        else {
            PennDraw.text(5.0, 2.5, "You have lost. Better luck next time!");
            PennDraw.text(5.0, 2.25, "Click anywhere to play again");
            PennDraw.advance();
        }
    }
    /**
    * Inputs: none
    * Outputs: none
    * Description: causes the game to quit when the 'a' character is pressed; 
    *              must be called after ball is launched
    */
    public void endGameTester() {
        for (int i = 0; i < bricks.length; i++) {
            bricks[i].setHitPoints(0);
        }
    }

    /** UPDATE AND DRAW FUNCTIONS
    * The update() and draw() function are both run
    * in the BrickBreaker.java file, and are seperated
    * into their own section because they are long and
    * very important to the code
    */

    /**
    * Inputs: double timeStep
    * Outputs: none
    * Description: updates Stage functions
    */
    public void update(double timeStep) {
        while (PennDraw.hasNextKeyTyped()) {
            if (PennDraw.nextKeyTyped() == 'a') {
                endGameTester();
            }
        }
        if (setStartScreen) {
            if (PennDraw.mousePressed()) {
                setStartScreen = false;
                mouseListeningMode = true;
            }
        }
        if (mouseListeningMode) {
            if (PennDraw.mousePressed()) {
                mouseWasPressedLastUpdate = true;
                ball.setVelocityFromMousePos();
            }
            if (!PennDraw.mousePressed() && mouseWasPressedLastUpdate) {
                mouseListeningMode = false;
                mouseWasPressedLastUpdate = false;
                ball.decrementLives();
                flyingMode = true;
            }
        }
        else {
            ball.update(timeStep);
            platform.movePlatform();                        
            if (flyingMode) {
                for (int i = 0; i < extra.length; i++) {
                    ball.powerUpExtraCollision(extra[i]);
                    if (extra[i].isHit()) {
                        extra[i].decreaseHP();
                        extra[i].setHitThisShot(false);
                    }
                }

                if ((ball.getYpos() < height / 2) && (ball.getYvel() < 0)) {
                    fallingMode = true;
                }
                else {
                    for (int i = 0; i < bricks.length; i++) {
                        ball.testAndHandleCollision(bricks[i]);
                        if (bricks[i].isHit()) {
                            bricks[i].decreaseHP();
                            bricks[i].setHitThisShot(false);
                            flyingMode = false;
                            fallingMode = true;
                            counter++;
                        }
                    }
                }
            }
            if (fallingMode) {
                ball.testAndHandlePlatformBounce(platform);
                flyingMode = true;
                if (ballIsOffscreen()) {
                    ball.reset();
                    platform.reset();
                    mouseListeningMode = true;
                }
            }
        }
    }

    /**
    * Inputs: none
    * Outputs: none
    * Description: draws a variety of images and shapes using PennDraw
    */
    public void draw() {
        PennDraw.clear();

        for (int i = 0; i < bricks.length; i++) {
            bricks[i].draw();
        }
        for (int i = 0; i < extra.length; i++) {
            extra[i].draw();
        }

        platform.draw();
        ball.draw();
        drawScore();

        if (mouseWasPressedLastUpdate && mouseListeningMode) {
            ball.drawVelocity();
        }
        PennDraw.advance();
    }

    /** HELPER FUNCTIONS
    * This section includes the many helper functions 
    * that are used and called in Stage.java. These 
    * are the important functions that are called 
    * and used within Stage.java, but are not called
    * in the BrickBreaker.java file
    */

    /**
    * Inputs: none
    * Outputs: none
    * Description: draws the score box
    */
    public void drawScore() {
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.square(1.0, 1.0, 0.5);
        PennDraw.text(1.0, 1.25, "Score:");
        PennDraw.text(1.0, 0.9, Integer.toString(counter));
    }

    /**
    * Inputs: none
    * Outputs: double
    * Description: resets the player's score to 0
    */
    public double scoreReset() {
        counter = 0;
        return counter;
    }

    /**
    * Inputs: none
    * Outputs: int
    * Description: calculates the total hit points of all the bricks
    */
    public int getHitPointsSum() {
        hitPointsSum = 0;
        for (int i = 0; i < bricks.length; i++) {
            hitPointsSum += bricks[i].getHitPoints();
        }
        return hitPointsSum;
    }

    /**
    * Inputs: none
    * Outputs: boolean
    * Description: returns true or false, depending on whether the ball has fallen
    *              below the bottom bound of the screen
    */
    private boolean ballIsOffscreen() {
    return ball.getYpos() + ball.getRadius() < 0;
    }
}
