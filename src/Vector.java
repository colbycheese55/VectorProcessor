package src;
import java.util.Arrays;

public class Vector {
    double x, y, z;

    public Vector(String in) {
        String code = in.substring(0, in.indexOf(" "));
        double[] values = values_helper(in.substring(in.indexOf(" ")));
        values = dimensional_checker(code, values);
        switch (code) {
            case "cart":
                x = values[0];
                y = values[1];
                z = values[2];
                break;
            case "pol":
                x = values[0]*Math.cos(Math.toRadians(values[1]));
                y = values[0]*Math.cos(Math.toRadians(values[2]));
                z = values[0]*Math.cos(Math.toRadians(values[3]));
                break;
            case "unit":
                x = values[0]*values[1];
                y = values[0]*values[2];
                z = values[0]*values[3];
                break;
            case "tp":
                x = values[0]*Math.cos(Math.toRadians(values[1]))*Math.cos(Math.toRadians(values[2]));
                y = values[0]*Math.sin(Math.toRadians(values[1]))*Math.cos(Math.toRadians(values[2]));
                z = values[0]*Math.sin(Math.toRadians(values[2]));
                break;
            case "dir":
                double r = Math.sqrt(Math.pow(values[1], 2) + Math.pow(values[2], 2) + Math.pow(values[3], 2));
                x = values[0]*values[1]/r;
                y = values[0]*values[2]/r;
                z = values[0]*values[3]/r;
                break;
            default:
                System.out.println("\nERROR: UNKNOWN OR NO FORMAT CODE. THIS ENTRY WAS DISREGARDED\n");
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
        double endtheta_x = truncate(Math.toDegrees(Math.acos(x/r)));
        double endtheta_y = truncate(Math.toDegrees(Math.acos(y/r)));
        double endtheta_z = truncate(Math.toDegrees(Math.acos(z/r)));

        return "\nResults: \n"+
        "Cartesian Coords: "+truncate(x)+"i + "+truncate(y)+"j + "+truncate(z)+"k \n"+
        "Polar Coords: "+truncate(r)+", "+endtheta_x+", "+endtheta_y+", "+endtheta_z+"\n"+
        "Unit Vector: "+truncate(r)+"e, where e is "+truncate(x/r)+"i + "+truncate(y/r)+"j + "+truncate(z/r)+"k";
    }

    private double[] values_helper(String input) {
        String[] pieces = input.split(",");
        double[] values = new double[pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            values[i] = Double.valueOf(pieces[i]);
        }
        return values;
    }
    private double truncate(double val) {
        int place = 4;
        return Math.floor(val*Math.pow(10, place)+0.5*Math.pow(10, -place))/Math.pow(10, place);
    }
    private double[] dimensional_checker(String code, double[] in) {
        if ((code.equals("cart") || code.equals("tp")) && !(in.length == 2 || in.length == 3)) {
            System.out.println("\nERROR: INCORRECT NUMBER OF COMPONENTS FOR THIS FORMAT. THIS ENTRY WAS DISREGARDED\n");
            return new double[4];
        }
        if ((code.equals("pol") || code.equals("dir")) && !(in.length == 3 || in.length == 4)) {
            System.out.println("\nERROR: INCORRECT NUMBER OF COMPONENTS FOR THIS FORMAT. THIS ENTRY WAS DISREGARDED\n");
            return new double[4];
        }
        double[] out = Arrays.copyOf(in, in.length+1);
        return out;
    }
}
