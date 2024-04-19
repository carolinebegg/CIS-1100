/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Execution: none
* 
* Description: this file contains the code that controls the ball, which is used by
*              the player to destroy the bricks. within this file, the velocity of
*              the ball updates itself independent of the rest of the program, based
*              off of the TIME_STEP from BrickBreaker.java and the initial equations
*              used to launch it. it also includes severel functions responsible for
*              handling the many collisions that take place, such as between the 
*              ball and the bricks, the ball and the platform, and the ball and the 
*              walls and ceiling, as well as the collisions between the ball and the
*              various powerups. this file also includes the relevant getter and 
*              setter functions for the various private variables, which allow them
*              to be accessed in other files, such as Stage.java. 
*/

public class Ball {
    
    // variables for width and height of screen
    private double width, height;
    
    // position, velocity, and radius of the ball
    private double xPos, yPos, xVel, yVel, radius;
    
    // number of lives the player has left
    private int numLives;
    
    public Ball(double width, double height, double xPos, double yPos,
    double radius, int lives) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        numLives = lives;
        xVel = 0;
        yVel = 0;
    }
    
    public void draw() {
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledCircle(xPos, yPos, radius);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledCircle(xPos, yPos, 0.75 * radius);
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledCircle(xPos, yPos, 0.5 * radius);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledCircle(xPos, yPos, 0.25 * radius);
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledCircle(xPos, yPos, 0.125 * radius);
        PennDraw.text(xPos, yPos + radius + 0.1, Integer.toString(numLives));
    }
    
    public void drawVelocity() {
        PennDraw.line(xPos, yPos, xPos + xVel, yPos + yVel);
    }
    
    public void reset() {
        xPos = 5.0;
        yPos = 0.5;
        xVel = 0.0;
        yVel = 0.0;
    }
    
    public void setVelocityFromMousePos() {
        xVel = xPos - PennDraw.mouseX();
        yVel = yPos - PennDraw.mouseY();
    }
    
    public void incrementLives() {
        numLives++;
    }
        
    public void update(double timeStep) {
        xPos += xVel * timeStep;
        yPos += yVel * timeStep;
        yVel -= 0.25 * timeStep;
        
        if (yPos > 5.0 + 0.15) {
            yPos = 5.15;
            yVel = -0.75 * yVel;
        }
        if (xPos > 10 + 0.15) {
            xPos = 10.15;
            xVel = -0.75 * xVel;
        }
        if (xPos < 0 - radius) {
            xPos = -0.15;
            xVel = -0.75 * xVel;
        }
    }
    
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    
    public void testAndHandleCollision(Brick b) {
        if (b.getHitPoints() > 0 && !b.isHit()) {
            if ((distance(xPos, yPos, b.getXpos(), b.getYpos())) <= 
            (b.getLength() + radius)) {
                b.setHitThisShot(true);
                yVel = -0.75 * yVel;
                xVel = -0.75 * xVel;
            }
        }
    }
    
    public void testAndHandlePlatformBounce(Platform p) {
        if (distance(xPos, yPos, p.getPxPos(), 0.25) <= 
        (p.getPwidth() / 2) + radius) {
            p.setHitPlatform(true);
            yVel = -1.05 * yVel;
        }
    }
    
    public void powerUpExtraCollision(ExtraLife e) {
        if (e.getHitPoints() > 0 && !e.isHit()) {
            if (distance(xPos, yPos, e.getXpos(), e.getYpos()) <= 
            (e.getRadius() + radius)) {
                e.setHitThisShot(true);
                incrementLives();
            }
        }
    }
    
    public void decrementLives() {
        numLives--;
    }

    public double getXpos() {
        return xPos;
    }

    public double getYpos() {
        return yPos;
    }

    public double getXvel() {
        return xVel;
    }

    public double getYvel() {
        return yVel;
    }

    public double getRadius() {
        return radius;
    }
    public int getNumLives() {
        return numLives;
    }

    public void setNumLives() {
        numLives = 11;
    }
}
