/**
 * Name: Caroline Begg
 * Pennkey: cbegg
 * Execution: Tools > JUnit > Execute
 *
 * Description: test that the constructor returns the correct number of bodies and 
 *              radius of the universe, test that the constructor returns the
 *              correct vy and px values, and test that the simulate function
 *              returns the correct values for px, py, vx, and vy
**/

import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceTest {

    /*
     * REQUIRED TESTS
     */
     
     public static final double DELTAFIELDS = 1e-4;
     public static final double DELTAPOSITION = 1e-6;

    @Test
    public void testSpaceConstructorFields() {
        Space s = new Space("binary.txt");

        int actualLen = s.bodies.length;
        double actualRad = s.radius;

        int expectedLen = 2;
        double expectedRad = 5.0e10;

        assertEquals(expectedLen, actualLen);
        assertEquals(expectedRad, actualRad, DELTAFIELDS);
    }

    @Test
    public void testSpaceConstructorBodies() {
        Space s = new Space("binary.txt");
        
        double actual1 = s.bodies[1].vy;
        double expected1 = 0.0;

        double actual0 = s.bodies[0].px;
        double expected0 = 0.0;

        assertEquals(expected1, actual1, 0.01);
        assertEquals(expected0, actual0, DELTAPOSITION);
    }

    @Test
    public void testSpaceSimulate() {
        Space s = new Space("solarSystem.txt");
        s.simulate(25000.0);

        double actualVx = s.bodies[0].vx;
        double expectedVx = -1.48201e+02;

        double actualVy = s.bodies[0].vy;
        double expectedVy = 2.98000e+04;

        double actualPx = s.bodies[0].px;
        double expectedPx = 1.49596e+11;

        double actualPy = s.bodies[0].py;
        double expectedPy = 7.45000e+08;
    }
}