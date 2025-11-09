import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Call your test methods for Average, Best, and Worst cases.
            int[] avgArr = generateRandomArray(n);
            int[] bestArr = generateSortedArray(n);
            int[] worstArr = generateReverseSortedArray(n);
            
            long startTime, endTime;
            
            
            int[] selSort = Arrays.copyOf(avgArr, n);
            int[] insSort = Arrays.copyOf(avgArr, n);
            int[] mergeSort = Arrays.copyOf(avgArr, n);
            
            //Average case
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(selSort);
            endTime = System.nanoTime();
            
            long timeSelAvg = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(insSort);
            endTime = System.nanoTime();
            
            long timeSortAvg = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(mergeSort);
            endTime = System.nanoTime();
            
            long timeMergeAvg = (endTime - startTime) /1000000;
            
            System.out.printf("%-10d %15s %-15d %-15d %-15d\n", n, "Average", timeSelAvg, timeSortAvg, timeMergeAvg);
            
            //Best case
            selSort = Arrays.copyOf(bestArr, n);
            insSort = Arrays.copyOf(bestArr, n);
            mergeSort = Arrays.copyOf(bestArr, n);
            
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(selSort);
            endTime = System.nanoTime();
            
            long timeSelBest = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(insSort);
            endTime = System.nanoTime();
            
            long timeSortBest = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(mergeSort);
            endTime = System.nanoTime();
            
            long timeMergeBest = (endTime - startTime) /1000000;
            
            System.out.printf("%-10d %15s %-15d %-15d %-15d\n", n, "Best", timeSelBest, timeSortBest, timeMergeBest);
            
            //worst case
            selSort = Arrays.copyOf(worstArr, n);
            insSort = Arrays.copyOf(worstArr, n);
            mergeSort = Arrays.copyOf(worstArr, n);
            
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(selSort);
            endTime = System.nanoTime();
            
            long timeSelWorst = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(insSort);
            endTime = System.nanoTime();
            
            long timeSortWorst = (endTime - startTime) /1000000;
            
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(mergeSort);
            endTime = System.nanoTime();
            
            long timeMergeWorst = (endTime - startTime) /1000000;
            
            System.out.printf("%-10d %15s %-15d %-15d %-15d\n", n, "Worst", timeSelWorst, timeSortWorst, timeMergeWorst);
        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        
        for(int i = 0; i< size; i++)
        {
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        
        for(int i = 0; i< size; i++)
        {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];

        for(int i = 0; i< size; i++)
        {
            arr[i] = size - i;
        }
        return arr;
    }
}
