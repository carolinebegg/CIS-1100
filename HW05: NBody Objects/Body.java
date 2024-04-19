/**
 * Name: Caroline Begg
 * Pennkey: cbegg
 * Execution: none
 *
 * Description: this file computes all of the necessary values (such as x distance, 
 *              y distance, etc) for the bodies in order to calculate how the many
 *              bodies will affect the position and velocity of the other bodies
**/
public class Body {
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
    * Constructor: This creates a new instance of a body object.
    */
    public Body(double mass, double posX, double posY, double velX, double velY, 
    String imageFile) {
        m = mass;
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        img = imageFile;
    }
    
    /**
    * Description: returns a string representation of the body for the
    * purposes of printing. We will discuss toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s",
        m, px, py, vx, vy, img);
    }

    /**
     * Inputs: Body other
     * Outputs: double of the x distance between the two bodies
     * Description: subtracts the x position of the other body from the original
     *              body; returns the difference between the two x positions
    */
    public double distanceToX(Body other) {
        return other.px - px;

    }
    
    /**
     * Inputs: Body other
     * Outputs: double of the y distance between the two bodies
     * Description: subtracts the y position of the other body from the original
     *              body; returns the difference between the two y positions
    */
    public double distanceToY(Body other) {
        return other.py - py;
    }
    
    /**
     * Inputs: Body other
     * Outputs: double of the resultant vector distance between the two bodies
     * Description: computes the resultant vector distance between the two bodies; 
     *              takes square root of the x position squared plus the y position
     *              squared
    */
    public double distanceTo(Body other) {
        return Math.sqrt((distanceToX(other) * distanceToX(other)) + 
        (distanceToY(other) * distanceToY(other)));
    }
    
    /**
     * Inputs: Body other
     * Outputs: double of the force of gravity between the two bodies
     * Description: calculates the force of gravity between two bodies
    */
    public double force(Body other) {
        return (G * other.m * m) / ((distanceTo(other) * distanceTo(other)));
    }
    
    /**
     * Inputs: Body other
     * Outputs: double value for force in x direction
     * Description: calculates force in x direction
    */
    public double forceX(Body other) {
        return force(other) * distanceToX(other) / distanceTo(other);
    }
    
    /**
     * Inputs: Body other
     * Outputs: double value for force in y direction
     * Description: calculates force in y direction
    */
    public double forceY(Body other) {
        return force(other) * distanceToY(other) / distanceTo(other);
    }
    
    /**
     * Inputs: double px, double py, String img
     * Outputs: none
     * Description: draws a body
    */
    public void draw() {
        PennDraw.picture(px, py, img);
    }
    
    /**
     * Inputs: double timeStep, which is the 
     * Outputs: does not return a value (void); updates positions px and py
     * Description: calculates the new positions of the body
    */
    public void move(double timeStep) {
        px += vx * timeStep;
        py += vy * timeStep;
    }
    
    /**
     * Inputs: Body object and double timeStep
     * Outputs: does not return a value (void); updates accelerations ax and ay, as
     *          well as velocities vx and vy
     * Description: calculates the acceleration of the body and then calculates and
     *              updates the new velocities of the body
    */
    public void getAffectedBy(Body other, double timeStep) {
        double ax = forceX(other) / m;
        double ay = forceY(other) / m;

        vx = vx + timeStep * ax;
        vy = vy + timeStep * ay;
    }
}
