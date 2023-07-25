package src;
import java.util.Arrays;

public class Vector {
    private double x, y, z;

    public Vector(String in) {
        String[] contents = in.split("\s", 2);
        String vectorFormat = contents[0];
        if (contents.length != 2 || vectorFormat.length() == 0) {
            System.out.println("\nERROR: NO FORMAT CODE GIVEN. THIS ENTRY WAS DISREGARDED\n");
            return;
        }
        double[] values = values_helper(contents[1]);
        values = dimensional_checker(vectorFormat, values);
        switch (vectorFormat) { 
            case "cart":
                x = values[0];
                y = values[1];
                z = values[2];
                break;
            case "rp":
                if (values[1] < 0 || values[1] > 180 || values[2] < 0 || values[2] > 180 || values[3] < 0 || values[3] > 180) {
                    System.out.println("\nERROR: THETA SHOULD BE BETWEEN 0 AND 180 (INCLUSIVE). THIS ENTRY WAS DISREGARDED\n");
                    return;
                }
                x = values[0]*Math.cos(Math.toRadians(values[1]));
                y = values[0]*Math.cos(Math.toRadians(values[2]));
                z = values[0]*Math.cos(Math.toRadians(values[3]));
                break;
            case "unit": 
                Vector unitVector = new Vector(values[1], values[2], values[3]);
                if (unitVector.getMag() > 1.05 || unitVector.getMag() < 0.95) {
                    System.out.println("\nERROR: UNIT VECTOR MAGNITUDE IS NOT 1. THIS ENTRY WAS DISREGARDED\n");
                    return;
                }
                x = values[0]*values[1];
                y = values[0]*values[2];
                z = values[0]*values[3];
                break;
            case "ap":
                if (values[2] < -90 || values[2] > 90) {
                    System.out.println("\nERROR: PHI SHOULD BE BETWEEN -90 AND 90 (INCLUSIVE). THIS ENTRY WAS DISREGARDED\n");
                    return;
                }
                x = values[0]*Math.cos(Math.toRadians(values[1]))*Math.cos(Math.toRadians(values[2]));
                y = values[0]*Math.sin(Math.toRadians(values[1]))*Math.cos(Math.toRadians(values[2]));
                z = values[0]*Math.sin(Math.toRadians(values[2]));
                break;
            case "dir":
                double r = (new Vector(values[1], values[2], values[3])).getMag();
                x = values[0]*values[1]/r;
                y = values[0]*values[2]/r;
                z = values[0]*values[3]/r;
                break;
            default:
                System.out.println("\nERROR: UNKNOWN FORMAT CODE. THIS ENTRY WAS DISREGARDED\n");
        }
    }
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public double getMag() {return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));}

    public String toString() {
        double r = getMag();
        double thetaX = round(Math.toDegrees(Math.acos(x/r)));
        double thetaY = round(Math.toDegrees(Math.acos(y/r)));
        double thetaZ = round(Math.toDegrees(Math.acos(z/r)));

        return "\nResults: \n"+
        "Cartesian Coords: "+round(x)+"i + "+round(y)+"j + "+round(z)+"k \n"+
        "Relative Polar Coords: Magnitude is "+round(r)+"; \u0398 is "+thetaX+", "+thetaY+", "+thetaZ+"\n"+
        "Unit Vector: "+round(r)+"e, where e is "+round(x/r)+"i + "+round(y/r)+"j + "+round(z/r)+"k";
    }

    private static double[] values_helper(String input) {
        String[] pieces = input.split(",");
        double[] values = new double[pieces.length];
        try {
            for (int i = 0; i < pieces.length; i++) {
                values[i] = Double.valueOf(pieces[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nERROR: NON NUMERICAL CHARACTERS WERE INPUT AS VECTOR COMPONENTS OR INVALID USE OF COMMAS. THIS ENTRY WAS DISREGARDED\n");
            return new double[3];
        }
        return values;
    }
    public static double round(double val) {
        final int decimalPlace = 4;
        return Math.round(val*Math.pow(10, decimalPlace)) / Math.pow(10, decimalPlace);
    }
    private static double[] dimensional_checker(String code, double[] in) {
        if ((code.equals("cart") || code.equals("ap")) && !(in.length == 2 || in.length == 3)) {
            System.out.println("\nERROR: INCORRECT NUMBER OF COMPONENTS FOR THIS FORMAT. 2 (2D) OR 3 (3D) ARE EXPECTED. THIS ENTRY WAS DISREGARDED\n");
            return new double[4];
        }
        if ((code.equals("rp") || code.equals("dir") || code.equals("unit")) && !(in.length == 3 || in.length == 4)) {
            System.out.println("\nERROR: INCORRECT NUMBER OF COMPONENTS FOR THIS FORMAT. 3 (2D) OR 4 (3D) ARE EXPECTED. THIS ENTRY WAS DISREGARDED\n");
            return new double[4];
        }
        
        return Arrays.copyOf(in, in.length+1);
    }
}
