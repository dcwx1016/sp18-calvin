public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos)
		 + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
	}

	public double calcForceExertedBy(Planet p) {
		return G * this.mass * p.mass / this.calcDistance(p) / this.calcDistance(p);

	}

	public double calcForceExertedByX(Planet p) {
		return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] p) {
		double result = 0;
		for (Planet a : p) {
			if (!(this.equals(a))) 
				result += this.calcForceExertedByX(a);
		}
		return result;
	}

	public double calcNetForceExertedByY(Planet[] p) {
		double result = 0;
		for (Planet a : p) {
			if (!(this.equals(a))) 
				result += this.calcForceExertedByY(a);
		}
		return result;
	}

	public void update(double dt, double fX, double fY) {
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	public void draw() {
		String location = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, location);
	}
}