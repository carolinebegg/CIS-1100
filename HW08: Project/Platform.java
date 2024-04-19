/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Execution: none
* 
* Description: this file contains the code that controls the moving platform that
*              is the initial position of the ball and also provides a space for 
*              the ball to bounce off of during the game. the movement of the 
*              platform is controlled by the player, as it will follow the x 
*              position of the player's cursor.
*/

public class Platform {

    // x position, y position,
    private double pXpos, pYpos;

    // platform width, platform height
    private double pWidth, pHeight;

    private boolean hitPlatform;

    public Platform(double pXpos, double pWidth) {
        this.pXpos = pXpos;
        pYpos = 0.25;
        this.pWidth = pWidth;
        pHeight = 0.075;
        this.hitPlatform = false;
    }

    public void draw() {
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledRectangle(pXpos, pYpos, pWidth, pHeight);
    }

    public void movePlatform() {
        pXpos = PennDraw.mouseX();
    }

    public void reset() {
        pXpos = 5.0;
    }

    public double getPxPos() {
        return pXpos;
    }

    public void setPxPos(double xPos) {
        pXpos = xPos;
    }

    public double getPyPos() {
        return pYpos;
    }

    public double getPwidth() {
        return pWidth;
    }

    public double getPheight() {
        return pHeight;
    }

    public void setHitPlatform(boolean hit) {
        hitPlatform = hit;
    }

    public boolean isHit() {
        return hitPlatform;
    } 

}