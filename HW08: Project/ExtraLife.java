/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Description: this is the file for the extra life power up. when hit, the player 
*              gains an extra life. 
*/

public class ExtraLife {
    private double xPos, yPos, radius;
    private int hitPoints;
    private boolean hitThisShot;

    public ExtraLife(double xPos, double yPos, double radius, int hitPoints) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        this.hitPoints = 1;
        hitThisShot = false;
    }

    public void draw() { // yellow powerup
        if (hitPoints > 0) {
            PennDraw.setPenColor(130, 97, 5);
            PennDraw.filledCircle(xPos, yPos, 0.25);
            PennDraw.setPenColor(252, 186, 3);
            PennDraw.filledCircle(xPos, yPos, 0.75 * 0.25);
            PennDraw.setPenColor(242, 198, 73);
            PennDraw.filledCircle(xPos, yPos, 0.5 * 0.25);
        }
    }

    public double getXpos() {
        return xPos;
    }

    public double getYpos() {
        return yPos;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setHitThisShot(boolean hit) {
        hitThisShot = hit;
    }

    public boolean isHit() {
        return hitThisShot;
    }

    public void decreaseHP() {
        hitPoints--;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints() {
        hitPoints = 1;
    }

}