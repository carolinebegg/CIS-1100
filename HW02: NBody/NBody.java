/**
* Name: Caroline Begg
* Pennkey: cbegg
* Execution: java NBody simulationTime timeStep filename
*
* Description: simulation of planets around the sun
**/
public class NBody {
    public static void main(String[] args) {
        //declare simulationTime as the first command line argument
        double simulationTime = Double.parseDouble(args[0]);
        
        //declare timeStep as the second command line argument
        double timeStep = Double.parseDouble(args[1]);
        
        // declare filename as the third command line argument
        String filename = args[2];
        
        In inStream = new In(filename);
        
        int numBodies = inStream.readInt();
        double radius = inStream.readDouble();
        
        //declaring arrays for mass, x & y position, x & y velocity, and img
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
        
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        
        PennDraw.enableAnimation(30);
        
        //the time loop (where the simulation takes place)
        
        double t = 0.0; // number of iterations of the time loop
        for (double elapsedTime = 0.0; elapsedTime < simulationTime;
        elapsedTime += timeStep) {
            PennDraw.picture(0, 0, "starfield.jpg");
            
            for (int i = 0; i < numBodies; i++) {
                PennDraw.picture(px[i], py[i], img[i]); //set initial positions
                
                double forceTotalX = 0.0; //total x force on body
                double forceTotalY = 0.0; //total y force on body
                
                //inner loop
                for (int j = 0; j < numBodies; j++) {
                    if (j != i) { //ensure body calculation doesn't include self
                        double dispX = px[j] - px[i];
                        double dispY = py[j] - py[i];
                        
                        //declare universal gravitational constant variable
                        double G = 6.67e-11;
                        
                        //declare "r" (d)
                        double d = Math.sqrt(dispX * dispX + dispY * dispY);
                        
                        //calculate force from one other body
                        double force = ((G * m[i]) / (d * d)) * m[j];
                        
                        //calculate force components
                        double forceX = force * (dispX / d);
                        double forceY = force * (dispY / d);
                        
                        //sum of forces
                        forceTotalX += forceX;
                        forceTotalY += forceY;
                    }
                }
                //calculate acceleration components
                double accelerationX = forceTotalX / m[i];
                double accelerationY = forceTotalY / m[i];
                
                //updating velocity
                vx[i] = vx[i] + (timeStep * accelerationX);
                vy[i] = vy[i] + (timeStep * accelerationY);
                
            }
            
            //updating position
            for (int i = 0; i < numBodies; i++) {
                px[i] = px[i] + (timeStep * vx[i]);
                py[i] = py[i] + (timeStep * vy[i]);
            }
            
            PennDraw.advance();
        }
        
        System.out.printf("%d\n", numBodies);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numBodies; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n",
            m[i], px[i], py[i], vx[i], vy[i], img[i]);
        }
        
    }
}
