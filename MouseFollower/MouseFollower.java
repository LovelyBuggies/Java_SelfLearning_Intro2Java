/******************************************************************************
 *  Compilation:  javac MouseFollower.java
 *  Execution:    java MouseFollower
 *  Author:       Nino Lau on 2017-08-11/20:26.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Draw a magenta filled circle wherever the mouse is, in cyan if the
 *  mouse is pressed.
 *
 *
 *  % java MouseFollower
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ******************************************************************************/

public class MouseFollower {
    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();

        while (true) {

            // mouse click
            if (StdDraw.mousePressed()) StdDraw.setPenColor(StdDraw.CYAN);
            else                          StdDraw.setPenColor(StdDraw.MAGENTA);

            // mouse location
            StdDraw.clear();
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            StdDraw.filledCircle(x, y, 0.05);
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }
}
