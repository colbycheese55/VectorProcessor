import java.util.Scanner;
public class vector_converter3D {
 public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    instruction_block();
    System.out.println("Enter the vector you wish to convert");
    String input = scan.nextLine().replace(" ", "");
    System.out.println("Enter the units:");
    String unit = scan.nextLine();
    System.out.print("\n\n");
    results(refine(input), unit);
}
 public static double[] refine(String input) {
   double fr=0, fx=0, fy=0, fz=0,theta_x=0, theta_y=0, theta_z=0, dx=0, dy=0, dz=0, d=0, phi=0;
   input = dimensional_corrector(input);
   if (input.indexOf(",")!=-1) {
     fr = Double.valueOf(input.substring(0, input.indexOf(",")));
     input = input.substring(input.indexOf(",")+1);
     theta_x = Double.valueOf(input.substring(0, input.indexOf(",")));
     input = input.substring(input.indexOf(",")+1);
     if (input.indexOf(",")!=-1) {
         theta_y = Double.valueOf(input.substring(0, input.indexOf(",")));
         input = input.substring(input.indexOf(",")+1);
         theta_z = Double.valueOf(input);
         fx = fr*Math.cos(Math.toRadians(theta_x));
         fy = fr*Math.cos(Math.toRadians(theta_y));
         fz = fr*Math.cos(Math.toRadians(theta_z));
        }
     else {
         phi = Double.valueOf(input);
         fx = fr*Math.cos(Math.toRadians(theta_x))*Math.cos(Math.toRadians(phi));
         fy = fr*Math.sin(Math.toRadians(theta_x))*Math.cos(Math.toRadians(phi));
         fz = fr*Math.sin(Math.toRadians(phi));
     }
   }
   else if (input.indexOf("i+")!=-1 && input.indexOf("e=")==-1) {
     fx = Double.valueOf(input.substring(0, input.indexOf("i")));
     fy = Double.valueOf(input.substring(input.indexOf("+")+1, input.indexOf("j")));
     fz = Double.valueOf(input.substring(input.lastIndexOf("+")+1, input.indexOf("k")));
   }
   else if (input.indexOf("e=")!=-1) {
     fr = Double.valueOf(input.substring(0, input.indexOf("e")));
     fx = fr*Double.valueOf(input.substring(input.indexOf("e=")+2, input.indexOf("i", input.indexOf("e="))));
     fy = fr*Double.valueOf(input.substring(input.indexOf("+")+1, input.indexOf("j")));
     fz = fr*Double.valueOf(input.substring(input.lastIndexOf("+")+1, input.indexOf("k")));
   }
   else if (input.indexOf(";")!=-1) {
     fr = Double.valueOf(input.substring(0, input.indexOf(";")));
     input = input.substring(input.indexOf(";")+1);
     dx = Double.valueOf(input.substring(0, input.indexOf(";")));
     input = input.substring(input.indexOf(";")+1);
     dy = Double.valueOf(input.substring(0, input.indexOf(";")));
     input = input.substring(input.indexOf(";")+1);
     dz = Double.valueOf(input);
     d = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2)+Math.pow(dz, 2));
     fx = fr*dx/d;
     fy = fr*dy/d;
     fz = fr*dz/d;
   }
   else {
       System.out.println("format not recognized");
    }
    double[] xyz = {fx, fy, fz};
    return xyz;
}
public static void instruction_block() {
    System.out.println("Vector entry rules: \n");
    System.out.println(" - Do not enter units until prompted. Angles must be in degrees");
    System.out.println(" - Enter Polar Coords like: 120, 50, 40, 90 ");
    System.out.println(" - Enter Cartesian Coords like: 10i+20j+30k");
    System.out.println(" - Enter Unit Vector like: 120e where e=0.2i+0.7j+0.1k");
    System.out.println(" - Enter Theta and Phi like: 100, 90, 0");
    System.out.println(" - Enter Directional like: 100; 10; -30; 90\n");
 }
public static void results(double[] xyz, String unit) {
    double endfx = xyz[0];
    double endfy = xyz[1];
    double endfz = xyz[2];
    
    double endfr = Math.sqrt(Math.pow(endfx, 2)+Math.pow(endfy, 2)+Math.pow(endfz, 2));
    double endtheta_x = truncate(Math.toDegrees(Math.acos(endfx/endfr)), 3);
    double endtheta_y = truncate(Math.toDegrees(Math.acos(endfy/endfr)), 3);
    double endtheta_z = truncate(Math.toDegrees(Math.acos(endfz/endfr)), 3);
        
    System.out.println("Results: \nPolar Coords: "+truncate(endfr, 2)+unit+", "+endtheta_x+", "+endtheta_y+", "+endtheta_z);
    System.out.println("Cartesian Coords: "+truncate(endfx, 2)+"i + "+truncate(endfy, 2)+"j + "+truncate(endfz, 2)+"k "+unit);
    System.out.println("Unit Vector: "+truncate(endfr, 2)+"e "+unit+", where e is "+truncate(endfx/endfr, 4)+"i + "+truncate(endfy/endfr, 4)+"j + "+truncate(endfz/endfr, 4)+"k");
 }
public static double truncate(double val, int place) {
    return Math.floor(val*Math.pow(10, place)+0.5*Math.pow(10, -place))/Math.pow(10, place);
 }
public static String dimensional_corrector(String input) {
    if (input.indexOf("i")!=-1 && input.indexOf("j")!=-1 && input.indexOf("k")==-1) {
        return input+="+0k";
    }
    if (input.indexOf(",")!=-1 && input.indexOf(",", input.indexOf(",")+1)==-1) {
        return input+=",0";
    }
    if (input.indexOf(";")!=-1) {
        String temp = input.substring(input.indexOf(";")+1);
        temp = temp.substring(temp.indexOf(";")+1);
        if (temp.indexOf(";")==-1) {
            return input+=";0";
        }
    }
    return input;
 }
}