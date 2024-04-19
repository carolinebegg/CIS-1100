/**
 * Name: Caroline Begg
 * Pennkey: cbegg
 * Execution: Tools > JUnit > Execute
 *
 * Description: tests the accuracy of the following functions: distanceToX,
 *              distanceToY, distanceTo, force, forceX, forceY, move, and 
 *              GetAffectedBy
**/

import org.junit.Test;
import static org.junit.Assert.*;

public class BodyTest {

    // Do not change this!
    // Use DELTA as the tolerance for your assertEquals statements.
    public static final double DELTA = 1e-4;

    /*
     * REQUIRED TESTS
     */

    /////////////////////////////////////
    // DISTANCE TESTS ///////////////////
    /////////////////////////////////////
    @Test
    public void testDistanceToX() {
        Body sun = new Body(1, 3, 4, 0, 0, "sun.gif");
        Body earth = new Body(1, 7, 7, 0, 0, "earth.gif");

        double actual = sun.distanceToX(earth);
        double expected = 4.0;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testDistanceToY() {
        Body sun = new Body(1, 3, 4, 0, 0, "sun.gif");
        Body earth = new Body(1, 7, 7, 0, 0, "earth.gif");

        double actual = sun.distanceToY(earth);
        double expected = 3.0;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testDistanceTo() {
        Body sun = new Body(1, 3, 4, 0, 0, "sun.gif");
        Body earth = new Body(1, 7, 7, 0, 0, "earth.gif");

        double actual = sun.distanceTo(earth);
        double expected = 5.0;

        assertEquals(expected, actual, DELTA);
    }

    /////////////////////////////////////
    // FORCE TESTS //////////////////////
    /////////////////////////////////////

    @Test
    public void testForce() {
        Body mars = new Body(10, 2, 4, 0, 0, "mars.gif");
        Body mercury = new Body(50, 7, 10, 0, 0, "mercury.gif");

        double actual = mars.force(mercury);
        double expected = 5.4707377 * 10e-11;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testForceX() {
        Body mars = new Body(10, 2, 4, 0, 0, "mars.gif");
        Body mercury = new Body(50, 7, 10, 0, 0, "mercury.gif");

        double actual = mars.forceX(mercury);
        double expected = 3.50228093 * 10e-10;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testForceY() {
        Body mars = new Body(10, 2, 4, 0, 0, "mars.gif");
        Body mercury = new Body(50, 7, 10, 0, 0, "mercury.gif");

        double actual = mars.forceY(mercury);
        double expected = 4.20273712 * 10e-10; 

        assertEquals(expected, actual, DELTA);
    }

    /////////////////////////////////////
    // VELOCITY TESTS ///////////////////
    /////////////////////////////////////

    @Test
    public void testMove() {
        Body mercury = new Body(5000, 7, 10, -3, 4, "mercury.gif");
        mercury.move(10);

        double actualX = mercury.px;
        double expectedX = -23.0;

        assertEquals(expectedX, actualX, DELTA);

        double actualY = mercury.py;
        double expectedY = 50.0;

        assertEquals(expectedY, actualY, DELTA);

    }

    @Test
    public void testGetAffectedBy() {
        Body mars = new Body(1000, 2, 4, 0, 0, "mars.gif");
        Body mercury = new Body(5000, 7, 10, -3, 4, "mercury.gif");

        mars.getAffectedBy(mercury, 100000.0);

        double actualX = mars.vx;
        double expectedX = 3.50228093e-4;

        assertEquals(expectedX, actualX, DELTA);

        double actualY = mars.vy;
        double expectedY = 4.20273712e-4;

        assertEquals(expectedY, actualY, DELTA);

    }

    /*
     * You should feel free to write more tests than the ones required.
     * Please keep them below this line.
     */
}