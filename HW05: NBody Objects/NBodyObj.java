/**
 * Name: Caroline Begg
 * Pennkey: cbegg
 * Execution: java NBodyObj simulationTime timeStep filename
 *
 * Description: calls the simulate function on the space object s and draws the
 *              bodies contained in the object
**/

public class NBodyObj {
    public static void main(String[] args) {

      double simulationTime = Double.parseDouble(args[0]);
      double timeStep = Double.parseDouble(args[1]);
      String filename = args[2];
      
      Space s = new Space(filename);

      PennDraw.enableAnimation(30);

      
      double t = 0.0; // number of iterations of the time loop
      for (double elapsedTime = 0.0; elapsedTime < simulationTime; 
      elapsedTime += timeStep) {
        s.simulate(timeStep);
        s.draw();
        PennDraw.advance();
      }
      System.out.println(s);
    }
}