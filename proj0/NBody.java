public class NBody {

    /** read radius of the universe from file */
    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        
        return in.readDouble();
    }

    /** read Body from file */
    public static Body[] readBodies(String s) {
        In in = new In(s);
        int number = in.readInt();
        in.readDouble();
        Body[] list = new Body[number];
        for(int i = 0; i < number; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            list[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return list;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("arguments incorrect!");
            System.exit(0);
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double radius = readRadius(fileName);
        Body[] bodies = readBodies(fileName);
        
		/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

		/** Scale the universe. */
		StdDraw.setScale(-radius, radius);

        for(double t = 0; t <=T; t += dt) {
		    /* Clears the drawing window. */
		    StdDraw.clear();

		    /* Draw the background. */
            String background = "images/starfield.jpg";
		    StdDraw.picture(0, 0, background, 2*radius, 2*radius);

            /* Draw Bodies */
            for (Body b: bodies) {
                double netForceX = b.calcNetForceExertedByX(bodies);
                double netForceY = b.calcNetForceExertedByY(bodies);
                b.update(dt, netForceX, netForceY);
                b.draw();
            }
		    /* Shows the drawing to the screen, and waits 2000 milliseconds. */
		    StdDraw.show();
		    StdDraw.pause(10);
        }

        /* print the universe */
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
}
	}

}
