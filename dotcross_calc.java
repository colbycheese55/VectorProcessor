import java.util.Scanner;
public class dotcross_calc {
    public static void main(String[] args) {
        vector_converter3D.instruction_block();
        System.out.println("Enter your first vector");
        Scanner scan = new Scanner(System.in);
        String vector1 = scan.nextLine().replace(" ", "");
        System.out.println("Enter your next vector");
        String vector2 = scan.nextLine().replace(" ", "");
        
        double[] dot = dot(vector1, vector2);
        System.out.println("\n\nDot (Scalar) Product Results:");
        System.out.println("Scalar value: "+vector_converter3D.truncate(dot[0], 3));
        System.out.println("Angle: "+vector_converter3D.truncate(dot[1], 2));
        
        double[] cross = cross(vector1, vector2);
        System.out.print("\nCross (Vector) Product ");
        vector_converter3D.results(cross, "");
    }
    public static double[] cross(String vector1, String vector2) {
        double[] v1 = vector_converter3D.refine(vector1);
        double[] v2 = vector_converter3D.refine(vector2);
        
        double[] xyz = new double[3];
        xyz[0] = v1[1]*v2[2]-v1[2]*v2[1];
        xyz[1] = v1[2]*v2[0]-v1[0]*v2[2];
        xyz[2] = v1[0]*v2[1]-v1[1]*v2[0];
        return xyz;
    }
    public static double[] dot(String vector1, String vector2) {
        double[] v1 = vector_converter3D.refine(vector1);
        double[] v2 = vector_converter3D.refine(vector2);
        
        double result = v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2];
        double mag1 = Math.sqrt(Math.pow(v1[0], 2)+Math.pow(v1[1], 2)+Math.pow(v1[2], 2));
        double mag2 = Math.sqrt(Math.pow(v2[0], 2)+Math.pow(v2[1], 2)+Math.pow(v2[2], 2));
        double theta = Math.toDegrees(Math.acos(result/(mag1*mag2)));

        double[] combo = {result, theta};
        return combo;
    }
}