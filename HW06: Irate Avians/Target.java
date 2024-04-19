/*  Name: Caroline Begg
*  PennKey: cbegg
*  Recitation: 205
*
*  A class that represents a target to be hit in
*  Irate Avians. Can update its own position based
*  on velocity and time.
*/

public class Target {
    
    // variables for width and height of screen
    private double width, height;
    
    // Position and radius
    private double xPos, yPos, radius;
    
    // Velocity components
    private double xVel, yVel;
    
    /**
    * When a target's hit points reach zero,
    * it has been destroyed by the bird.
    */
    private int hitPoints;
    
    // Track if target has been hit this shot.
    private boolean hitThisShot;
    
    /**
    * Given a position, a radius, a velocity, and a number of hit points,
    * construct a Target.
    */
    public Target(double width, double height, double xPos, double yPos,
    double radius, double xVel, double yVel, int hitPoints) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        this.xVel = xVel;
        this.yVel = yVel;
        this.hitPoints = hitPoints;
        this.hitThisShot = false;
    }
    
    /**
    * Draw a circle centered at the target's position
    * with a radius equal to the target's radius.
    * Only draw a Target if it has more than zero
    * hit points.
    */
    public void draw() {
        if (this.hitPoints > 0) {
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(xPos, yPos, radius);
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.filledCircle(xPos, yPos, radius * 0.75);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(xPos, yPos, radius * 0.5);
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.filledCircle(xPos, yPos, radius * 0.25);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(xPos, yPos, radius * 0.125);
            PennDraw.text(xPos, yPos + radius + 0.1, Integer.toString(hitPoints));
        }
    }
    
    /**
    * Given the change in time, update the target's
    * position based on its x and y velocity. When
    * a target is completely offscreen horizontally,
    * its position should wrap back around to the opposite
    * horizontal side. For example, if the target moves off the
    * right side of the screen, its xPos should be set to the
    * left side of the screen minus the target's radius.
    * The same logic should apply to the target's vertical
    * position with respect to the vertical screen boundaries.
    */
    public void update(double timeStep) {
        xPos = xPos + xVel * timeStep;
        yPos = yPos + yVel * timeStep;

        if (xPos > width + radius) {
            xPos = 0 - radius;
        }
        if (xPos < 0 - radius) {
            xPos = width + radius;
        }
        if (yPos > height + radius) {
            yPos = 0 - radius;
        }
        if (yPos < 0 - radius) {
            yPos = height + radius;
        }
    }
    
    // Decrement the target's hit points by 1.
    /**
     * Inputs: no input
     * Outputs: no output
     * Description: decrease the hitpoints of a target by 1 when it is hit
    */
    public void decreaseHP() {
        --hitPoints;
    }
    
    // Setter function for whether or not target hit this round.
    /**
    * Inputs: boolean hit
    * Outputs: no output
    * Description: set the value of boolean hitThisShot to the value of hit
    */
    public void setHitThisShot(boolean hit) {
        hitThisShot = hit;
    }
    
    /**
    * Return whether or not this target is hit this round.
    */
    public boolean isHit() {
        return hitThisShot;
    }
    
    /**
    * Getter functions that return a copy of the
    * indicated member variable.
    */
    public int getHitPoints() {
        return hitPoints;
    }
    
    /**
     * Inputs: no input
     * Outputs: no output
     * Description: getter function for the private value of Xpos
    */
    public double getXpos() {
        return xPos;
    }
    
    /**
     * Inputs: no input
     * Outputs: no output
     * Description: getter function for the private value of Ypos
    */
    public double getYpos() {
        return yPos;
    }
    
    /**
     * Inputs: no input
     * Outputs: no output
     * Description: getter function for the private value of radius
    */
    public double getRadius() {
        return radius;
    }

    /**
    * Inputs: no input
    * Outputs: no output
    * Description: decrease the value of the radius of the target; called in 
    *               Arena.java to decrease the size of the target by 25% after each
    *               time that it is hit
    */
    public double decreaseRadius() {
        radius = radius * 0.75;
        return radius;
    }
}