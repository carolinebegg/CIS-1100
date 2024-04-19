/**
* Name : Caroline Begg
* PennKey : cbegg
*
* Execution: java MySketch
*
* This program uses PennDraw to create a picture. This picture is called 
* "Night Forest" and shows a nightime forestscape, including a tree, a sandy lake
* with a salmon swimming in it, a brown bear, and a night sky full of stars, an owl,
* and the moon. 
*/

public class MySketch {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);
        PennDraw.clear(29, 32, 31);

        //moon
        PennDraw.setPenColor(255, 255, 255);
        PennDraw.filledCircle(0.15, 0.85, 0.1);
        
        //grass
        PennDraw.setPenColor(0, 130, 35);
        PennDraw.filledRectangle(0.5, 0.15, 1, 0.15);
        
        //stars
        PennDraw.setPenColor(255, 255, 255);
        PennDraw.filledRectangle(0.5, 0.75, 0.001, 0.04);
        PennDraw.filledRectangle(0.5, 0.75, 0.04, 0.001);

        PennDraw.filledRectangle(0.75, 0.75, 0.001, 0.04);
        PennDraw.filledRectangle(0.75, 0.75, 0.04, 0.001);

        PennDraw.filledRectangle(0.5, 0.50, 0.001, 0.04);
        PennDraw.filledRectangle(0.5, 0.50, 0.04, 0.001);

        PennDraw.filledRectangle(0.25, 0.50, 0.001, 0.04);
        PennDraw.filledRectangle(0.25, 0.50, 0.04, 0.001);

        PennDraw.filledRectangle(0.75, 0.50, 0.001, 0.04);
        PennDraw.filledRectangle(0.75, 0.50, 0.04, 0.001);

        PennDraw.filledRectangle(0.125, 0.625, 0.001, 0.04);
        PennDraw.filledRectangle(0.125, 0.625, 0.04, 0.001);

        PennDraw.filledRectangle(0.625, 0.375, 0.001, 0.04);
        PennDraw.filledRectangle(0.625, 0.375, 0.04, 0.001);

        PennDraw.filledRectangle(0.375, 0.625, 0.001, 0.04);
        PennDraw.filledRectangle(0.375, 0.625, 0.04, 0.001);

        PennDraw.filledRectangle(0.375, 0.375, 0.001, 0.04);
        PennDraw.filledRectangle(0.375, 0.375, 0.04, 0.001);

        PennDraw.filledRectangle(0.625, 0.625, 0.001, 0.04);
        PennDraw.filledRectangle(0.625, 0.625, 0.04, 0.001);

        PennDraw.filledRectangle(0.125, 0.375, 0.001, 0.04);
        PennDraw.filledRectangle(0.125, 0.375, 0.04, 0.001);

        PennDraw.filledRectangle(0.875, 0.375, 0.001, 0.04);
        PennDraw.filledRectangle(0.875, 0.375, 0.04, 0.001);

        PennDraw.filledRectangle(0.875, 0.625, 0.001, 0.04);
        PennDraw.filledRectangle(0.875, 0.625, 0.04, 0.001);

        PennDraw.filledRectangle(0.875, 0.875, 0.001, 0.04);
        PennDraw.filledRectangle(0.875, 0.875, 0.04, 0.001);

        PennDraw.filledRectangle(0.625, 0.875, 0.001, 0.04);
        PennDraw.filledRectangle(0.625, 0.875, 0.04, 0.001);

        PennDraw.filledRectangle(0.375, 0.875, 0.001, 0.04);
        PennDraw.filledRectangle(0.375, 0.875, 0.04, 0.001);

        //lake (sand)
        PennDraw.setPenColor(219, 170, 35);
        PennDraw.setPenRadius(0.05);
        PennDraw.ellipse(0.5, 0.15, 0.25, 0.1);

        //lake (water)
        PennDraw.setPenRadius();
        PennDraw.setPenColor(35, 161, 219);
        PennDraw.filledEllipse(0.5, 0.15, 0.25, 0.1);

        //tree trunk
        PennDraw.setPenColor(89, 61, 10);
        PennDraw.setPenRadius(0.05);
        PennDraw.line(0.8, 0.25, 0.8, 0.6);

        //salmon
        PennDraw.setPenColor(247, 146, 124);
        PennDraw.filledCircle(0.5, 0.15, 0.05);
        PennDraw.filledPolygon(0.53, 0.15, 0.6, 0.2, 0.6, 0.1);

        //tree top; PennDraw.filledPolygon(x1, y1, x2, y2, x3, y3, ...);
        PennDraw.setPenColor(PennDraw.GREEN);
        PennDraw.filledPolygon(0.8, 0.8, 0.7, 0.4, 0.9, 0.4);
        
        //yogi bear image
        PennDraw.picture(0.2, 0.4, "bear.png", 50, 0);

        //owl image
        PennDraw.picture(0.6, 0.8, "owl.png", 75, 0);
    }
}