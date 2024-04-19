/*  Name: Caroline Begg
*  PennKey: cbegg
*  Recitation: 205
*
*  A class representing the arena in which the Irate Avians
*  game takes place. Keeps track of the game's Bird and
*  Targets and receives the player's input to control the bird.
*
*/

public class Arena {
    // The width and height of the PennDraw screen
    private int width, height;
    
    // All the targets in the Arena
    private Target[] targets;
    
    // The one and only bird in the game
    private Bird bird;
    
    /**
    * Whether the game is currently listening for
    * the player's mouse input, or letting the bird
    * fly. Begins as true.
    */
    private boolean mouseListeningMode;
    
    /**
    * Tells the program if the user was pressing
    * the mouse in the previous update call. Lets
    * the program know if the user has just released
    * the mouse because mouseWasPressedLastUpdate will
    * be true, but PennDraw.mousePressed() will be false
    * in the current update call. This enables the game
    * to transition from the mouse listening state into
    * the bird flight state.
    */
    private boolean mouseWasPressedLastUpdate;
    
    /**
    * Given a file that describes the contents of the
    * Arena, parse the file and initialize all member
    * variables of the Arena.
    * The file will be in the following format:
    * numTargets width height
    * bird.numThrows
    * target0.xPos target0.yPos target0.radius 
    * target0.xVel target0.yVel target0.hitPoints
    * target1.xPos... etc.
    */
    public Arena(String filename) {
        In in = new In(filename);
        int numTargets = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
        int numThrowsRemaining = in.readInt();

        targets = new Target[numTargets];

        // TODO : parse given file and init all member variables.

        for (int i = 0; i < targets.length; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double radius = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            int hitPoints = in.readInt();

            targets[i] = new Target(width, height, xPos, yPos, radius, xVel, yVel, 
                        hitPoints);
        }
        PennDraw.setXscale(0, width);
        PennDraw.setYscale(0, height);

        this.bird = new Bird(1, 1, 0.25, numThrowsRemaining);

        mouseListeningMode = true;
        mouseWasPressedLastUpdate = false;

        in.close();
    }
    
    /**
    * Returns true when all targets' hit points are 0.
    * Returns false in any other scenario.
    */
    private boolean didPlayerWin() {
        for (int i = 0; i < targets.length; i++) {
            if (targets[i].getHitPoints() == 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
    * Returns true when the bird's remaining throw count is 0
    * when the game is in mouse-listening mode.
    * Returns false in any other scenario.
    */
    private boolean didPlayerLose() {
        if (mouseListeningMode) {
            for (int i = 0; i < targets.length; i++) {
                if (bird.getNumThrowsRemaining() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Returns true when either the win or lose
    * condition is fulfilled.
    * Win: All targets' hit points are 0.
    * Lose: The bird's remaining throw count reaches 0.
    *       Additionally, the game must be in mouse listening
    * 		mode for the player to have lost so that the bird
    * 		can finish its final flight and potentially hit
    * 		the last target(s).
    */
    public boolean gameOver() {
        if (didPlayerLose() || didPlayerWin()) {
            return true;
        }
        return false;
    }
    
    /**
    * Update each of the entities within the arena.
    * 1. Call each Target's update function
    * 2. Check the game state (mouse listening or bird moving)
    * and invoke the appropriate functions for the bird.
    */
    public void update(double timeStep) {
        for (int i = 0; i < targets.length; i++) {
            targets[i].update(timeStep);
        }
        
        if (mouseListeningMode) {
            if (PennDraw.mousePressed()) {
                mouseWasPressedLastUpdate = true;
                bird.setVelocityFromMousePos();
            }
            
            if (!PennDraw.mousePressed() && mouseWasPressedLastUpdate) {
                mouseListeningMode = false;
                mouseWasPressedLastUpdate = false;
                bird.decrementThrows();
            }
            
            /**
            * If the mouse is currently pressed, then
            * set mouseWasPressedLastUpdate to true, and
            * call bird.setVelocityFromMousePos.
            */
            
            /**
            * If the mouse is NOT currently pressed, AND
            * mouseWasPressedLastUpdate is currently true,
            * that means the player has just released the
            * mouse button, and the game should transition
            * from mouse-listening mode to bird-flight mode.
            */
            
        }
        else {
            bird.update(timeStep);
            for (int i = 0; i < targets.length; i++) {
                bird.testAndHandleCollision(targets[i]);
            }

            if (birdIsOffscreen()) {
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i].isHit()) {
                        targets[i].decreaseHP();
                        targets[i].decreaseRadius();
                        targets[i].setHitThisShot(false);
                    }

                }
                
                bird.reset();
                mouseListeningMode = true;
            }

        }
    }
    
    /**
    * A helper function for the Arena class that lets
    * it know when to reset the bird's position and velocity
    * along with the game state.
    * Returns true when the bird is offscreen to the left, right,
    * or bottom. However, the bird is allowed to go above the top
    * of the screen without resetting.
    */
    private boolean birdIsOffscreen() {
        return bird.getXpos() + bird.getRadius() < 0 || bird.getRadius() - 
        bird.getXpos() > width || bird.getYpos() + bird.getRadius() < 0;
    }
    
    public void draw() {
        PennDraw.clear();
        for (int i = 0; i < targets.length; i++) {
            targets[i].draw();
        }

        bird.draw();
        if (mouseWasPressedLastUpdate && mouseListeningMode) {
            bird.drawVelocity();
        }
        PennDraw.advance();
    }
    
    /**
    * Draws either the victory or loss screen.
    * If all targets have 0 hit points, the player has won.
    * Otherwise they have lost.
    */
    public void drawGameCompleteScreen() {
        PennDraw.clear();
        if (didPlayerWin()) {
            PennDraw.text(width / 2, height / 2, "You Win!");
        }
        if (didPlayerLose()) {
            PennDraw.text(width / 2, height / 2, "You have lost...");
        }
        PennDraw.advance();
    }
        
}
