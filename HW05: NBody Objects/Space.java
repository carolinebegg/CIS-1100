/**
 * Name: Caroline Begg
 * Pennkey: cbegg
 * Execution: none
 *
 * Description: this file acts as the "body manager" for the rest of the code; this
 *              code simulates the movement of the bodies based on how all of the 
 *              other bodies affect each other
**/
public class Space {
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public Body[] bodies; //array of Body objects in the space
    public double radius; //radius of the universe
    
    /* DO NOT EDIT ANY CODE ABOVE THIS LINE */

    public double m;
    public double px;
    public double py;
    public double vx;
    public double vy;
    public String img;
    
    /**
    * Constructor: This creates a new instance of a space object.
    */
    public Space(String filename) {
        In inStream = new In(filename);
        
        int numBodies = inStream.readInt();
        radius = inStream.readDouble();

        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);

        bodies = new Body[numBodies];
        
        double[] m = new double[numBodies];
        double[] px = new double[numBodies];
        double[] py = new double[numBodies];
        double[] vx = new double[numBodies];
        double[] vy = new double[numBodies];
        String[] img = new String[numBodies];
        
        for (int i = 0; i < numBodies; i++) {
            m[i] = inStream.readDouble();
            px[i] = inStream.readDouble();
            py[i] = inStream.readDouble();
            vx[i] = inStream.readDouble();
            vy[i] = inStream.readDouble();
            img[i] = inStream.readString();
        }

        for (int i = 0; i < numBodies; i++) {
            bodies[i] = new Body(m[i], px[i], py[i], vx[i], vy[i], img[i]);
        }

    }
    
    /**
    * Description: returns a string representation of space for the purposes
    * of printing. We have discussed toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + bodies.length + "\n");
        sb.append(String.format("%.2e\n", radius) + "\n");
        for (int i = 0; i < bodies.length; i++) {
            sb.append(bodies[i].toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
     * Inputs: none
     * Outputs: none (void)
     * Description: draws starfield and then draws all the bodies
    */
    public void draw() {
        PennDraw.picture(0.0, 0.0, "starfield.jpg");
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].draw();
        }

    }
    
    /**
     * Inputs: double timeStep (time variable)
     * Outputs: no return valyue (void)
     * Description: simulates the effect of gravitational attraction from all the
     *              other bodies on a planet
    */
    public void simulate(double timeStep) {
        for (int i = 0; i < bodies.length; i++) {
            for (int j = 0; j < bodies.length; j++) {
                if (j != i) {
                    bodies[i].getAffectedBy(bodies[j], timeStep);
                }
            }
        }
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].move(timeStep);
        }
    }
}
