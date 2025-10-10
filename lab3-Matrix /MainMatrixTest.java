public class MainMatrixTest {

    public static void main(String[] args) {
        Matrix m1 = new Matrix(4, 3);
        
        int[][] array = {{ 2, 3, 4}, {2, 3, 4}, {2, 3, 4}, {2, 3, 4}};
        Matrix m2 = new Matrix(array);
        //populating the matrix
        m1.populateRandom();
        
        //printing out the matrix
        System.out.println("m1: ");
        System.out.println(m1.toString());
        System.out.println();
        System.out.println("m2: ");
        System.out.println(m2.toString());
        System.out.println();
        
        //testing with same dimesion array
        System.out.println("Elements added: ");
        System.out.println(m1.add(m2));
        System.out.println();
        System.out.println("Elements multiplied: ");
        System.out.println(m1.multiply(m2));
        
        /* System throws exception
        //testing with different dimension arrays
        //an array with not same dimensions
        int[][] array2 = {{2, 3, 4}, {2, 3, 4}};
        Matrix m3 = new Matrix(array2);
        System.out.println("Elements added: ");
        System.out.println(m1.add(m3));
        System.out.println();
        System.out.println("Elements multiplied: ");
        System.out.println(m1.multiply(m3));
        
        */
        
    }
}//end main class
