/*
* Name: Caroline Begg
* Pennkey: cbegg
* Execution: java Sierpinski args[0]
*
*
* Program Description: recursively draws Sierpinski carpet based on the input value
*                       entered in the command line; draws black squares in a 
*                       repeating pattern
*/
public class Sierpinski {
    public static void sierpinski(int numLevels, double halfSideLength, 
        double x, double y) {

        if (numLevels < 1) {
            return;
        }
        else {
            PennDraw.filledSquare(x, y, halfSideLength);
            PennDraw.enableAnimation(30);
            sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, 
                y + 2 * halfSideLength);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x, y + 2 * halfSideLength);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, 
                y + 2 * halfSideLength);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, y);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, y);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, 
                y - 2 * halfSideLength);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x, y - 2 * halfSideLength);
            PennDraw.advance();
            sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, 
                y - 2 * halfSideLength);
            PennDraw.advance();
        }
    }

    public static void main(String[] args) {
        int numLevels = Integer.parseInt(args[0]);
        sierpinski(numLevels, 1.0 / 6.0, 0.5, 0.5);

    }
}