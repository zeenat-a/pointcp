/**
 * This class contains instances of coordinates in polar format.
 * It provides the utilities to convert them into cartesian coordinates.
 * It is not an optimal design, it is used only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP2
{
    //Instance variables ************************************************

    /**
     * Contains the current value of RHO.
     */
    private double rho;

    /**
     * Contains the current value of THETA.
     */
    private double theta;

    //Constructors ******************************************************

    /**
     * Constructs a coordinate object in polar form.
     */
    public PointCP2(double rho, double theta)
    {
        this.rho = rho;
        this.theta = theta;
    }

    //Instance methods **************************************************

    public double getRho()
    {
        return rho;
    }

    public double getTheta()
    {
        return theta;
    }

    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    public PointCP convertToCartesian()
    {
        double x = rho * Math.cos(Math.toRadians(theta));
        double y = rho * Math.sin(Math.toRadians(theta));

        return new PointCP('C', x, y);
    }

    /**
     * Calculates the distance between two points using the Pythagorean
     * theorem (C ^ 2 = A ^ 2 + B ^ 2).
     *
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP2 pointB)
    {
        double deltaX = this.convertToCartesian().getX() - pointB.convertToCartesian().getX();
        double deltaY = this.convertToCartesian().getY() - pointB.convertToCartesian().getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     *
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP2 rotatePoint(double rotation)
    {
        double newTheta = (theta + rotation) % 360;
        if (newTheta < 0) {
            newTheta += 360;
        }

        return new PointCP2(rho, newTheta);
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Polar [" + rho + "," + theta + "]\n";
    }
}
