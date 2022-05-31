public class TestBody {
    /** Tests the Body class */
    public static void main(String[] args) {
        checkBody();
    }
    
    /** checks whether two things are equal */
    private static void checkEquals(double expected, double actual, double eps, String label) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.print("SUCCESS: ");
        } else {
            System.out.print("ERROR: ");
        }
        System.out.println(label + ": Expected " + expected + ", you got " + actual);
    }

    /** checks functions in the Body class work */
    private static void checkBody() {
        Body saturn = new Body(2.3e12, 9.5e11, 0, 0, 6.0e26, "earth.jpg");
        Body sun = new Body(1.0e12, 2.0e11, 10, 10, 2.0e30, "sum.jpg");
        checkEquals(3.1e22, sun.calcForceExertedByX(saturn), 0.1, "calcForceExertedByX");
        checkEquals(1.8e22, sun.calcForceExertedByY(saturn), 0.1, "calcForceExertedByY");
    }
}
