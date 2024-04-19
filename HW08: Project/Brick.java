/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Execution: none
* 
* Description: this file contains the code that controls the individual bricks that
*              the player tries to destroy by hitting them with the ball. there are 
*              three different levels of bricks: the single hit point bricks, which
*              are light-colored and take only a single hit to destroy, the double 
*              hit bricks, which are medium-colored and take two hits to destroy,
*              and the triple hit bricks, which are dark-colored and take three hits
*              to destroy. this file also includes the relevant getter and setter 
*              functions for the various private variables, which allow them to be 
*              accessed in other files, such as Stage.java.  
*/

public class Brick {

    // variables for width and height of screen
    private double width, height;

    // x position, y position, length of one side of brick
    private double xPos, yPos, length;

    private int hitPoints;

    private boolean hitThisShot;

    public Brick(double width, double height, double xPos, double yPos, 
    double length, int hitPoints) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.length = length;
        this.hitPoints = hitPoints;
        this.hitThisShot = false;
    }

    public void draw() {
        if (this.hitPoints > 0) {
            // single hit bricks
            if (this.hitPoints == 1) {
                PennDraw.setPenColor(255, 87, 74);
                PennDraw.filledSquare(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius();
                PennDraw.square(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.WHITE);
                PennDraw.text(xPos, yPos, Integer.toString(hitPoints));
            }

            // double hit bricks
            else if (this.hitPoints == 2) {
                PennDraw.setPenColor(209, 23, 8);
                PennDraw.filledSquare(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius();
                PennDraw.square(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.WHITE);
                PennDraw.text(xPos, yPos, Integer.toString(hitPoints));
            }

            // triple hit bricks
            else if (this.hitPoints == 3) {
                PennDraw.setPenColor(74, 8, 3);
                PennDraw.filledSquare(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius();
                PennDraw.square(xPos, yPos, length);
                PennDraw.setPenColor(PennDraw.WHITE);
                PennDraw.text(xPos, yPos, Integer.toString(hitPoints));
            } 
        }
    }

    public void decreaseHP() {
        --hitPoints;
    }

    public void setHitThisShot(boolean hit) {
        hitThisShot = hit;
    }

    public boolean isHit() {
        return hitThisShot;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hp) {
        hitPoints = hp;
    }

    public double getXpos() {
        return xPos;
    }

    public double getYpos() {
        return yPos;
    }

    public double getLength() {
        return length;
    }
}