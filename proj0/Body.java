public class Body {
    /** constant */
    public static final double G = 6.67e-11;

    /** instance variables */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /** constructors */
    public Body(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }
    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    /** calculate the distance between two Body's 
     *  @param other Body
    */
    public double calcDistance(Body other) {
        double dx = other.xxPos - this.xxPos;
        double dy = other.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** calculate the exerted force 
     *  @param other Body
    */
    public double calcForceExertedBy(Body other) {
        return G * this.mass * other.mass / Math.pow(calcDistance(other), 2);
    }

    /** calculate the exerted force in the X direction 
     *  @param other Body
    */
    public double calcForceExertedByX(Body other) {
        double dx = other.xxPos - this.xxPos;
        return calcForceExertedBy(other) * dx / calcDistance(other);
    }

    /** calculate the exerted force in the Y direction 
     *  @param other Body
    */
    public double calcForceExertedByY(Body other) {
        double dy = other.yyPos - this.yyPos;
        return calcForceExertedBy(other) * dy / calcDistance(other);
    }

    /** calculate the net force exerted in the X direction 
     *  @param list of Bodies
    */
    public double calcNetForceExertedByX(Body[] list) {
        double netFore = 0;
        for (Body other: list) {
            if (this.equals(other)){
                continue;
            }
            netFore += calcForceExertedByX(other);
        }
        return netFore;
    }

    /** calculate the net force exerted in the Y direction 
     *  @param list of Bodies
    */
    public double calcNetForceExertedByY(Body[] list) {
        double netFore = 0;
        for (Body other: list) {
            if (this.equals(other)){
                continue;
            }
            netFore += calcForceExertedByY(other);
        } 
        return netFore;
    }

    /** update the state of the body when exerting a fore on it 
     *  @param dt, the peroid of time
     *  @param fX, force in the X direction
     *  @param fY, force in the Y direction
    */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + aX * dt;
        this.yyVel = this.yyVel + aY * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    /** draw the Body */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
