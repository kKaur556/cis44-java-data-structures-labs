import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            //Generating a random array and time both algorithms.
            int[] test = generateRandomArrayWithNegatives(n);
            
            //time brute force algorithm
            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            long durationBF = endTime - startTime;
            int maxSumBF = MaxSubarraySolver.bruteForceMaxSum(test);
            System.out.printf(" Brute Force (Sum: %d): %,d ns%n", maxSumBF, durationBF);
            
            //time kaden's algorithm
            startTime = System.nanoTime();
            endTime = System.nanoTime();
            long durationK = endTime - startTime;
            int maxSumK = MaxSubarraySolver.bruteForceMaxSum(test);
            System.out.printf(" Kaden's (Sum: %d): %,d ns%n", maxSumK, durationK);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        Random rand = new Random();
        
        for(int i = 0; i < size; i++)
        {
            arr[i] = rand.nextInt(2 * size) - size;
        }
        return arr;
    }
}
