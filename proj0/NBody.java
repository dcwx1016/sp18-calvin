public class NBody {
	private static final String backgroundMusic = "./audio/2001.mid";
	/** 
		Returns a double corresponding to the radius of the universe
	*/
	public static double readRadius(String args) {
		In in = new In(args);
		int first = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	
	/** 
		Returns an array of planets.
	*/
	public static Planet[] readPlanets(String args) {
		In in = new In(args);
		int num = in.readInt();
		in.readDouble();
		Planet[] a = new Planet[num];
		for (int i = 0; i < num ; i ++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			a[i] = new Planet(xp,yp,xv,yv,mass,name);
		}
		return a;
	}

    public static void main(String[] args) {
    	/** Read command line inputs.*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		StdAudio.play(backgroundMusic);

		/** Read radius and array of planets. */
		double radius = readRadius(filename);
		Planet[] array = readPlanets(filename);

		/** Enable double buffering, set the scale, clear the scene
		and draw the background.*/
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();
		StdDraw.picture(0,0,"./images/starfield.jpg");

		/** draw the initial positions.*/
		for (Planet d : array) {
			d.draw();
		}
		StdDraw.show();

		StdDraw.enableDoubleBuffering();
		double t = 0;
		int num = array.length;
		while (t != T) {
			/**  Create an array of xForces and yFofces.*/
			double[] xForces = new double[num];
			double[] yForces = new double[num];

			/**  calculate the forces.*/
			for (int i = 0; i < num; i ++) {
				double xF = array[i].calcNetForceExertedByX(array);
				double yF = array[i].calcNetForceExertedByY(array);
				xForces[i] = xF;
				yForces[i] = yF;
			}

			/**  Update the positions*/
			for (int i = 0; i < num; i++ ) {
				array[i].update(dt, xForces[i], yForces[i]);
    		}

    		/* draw background and all of planets.*/
			StdDraw.picture(0, 0, "./images/starfield.jpg");
    		for (Planet d : array) {
				d.draw();
		    }
			StdDraw.show();
			StdDraw.pause(10);
			t += dt;
		}

		StdOut.printf("%d\n", array.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < array.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  array[i].xxPos, array[i].yyPos, array[i].xxVel,
                  array[i].yyVel, array[i].mass, array[i].imgFileName);   
		}
	}
}