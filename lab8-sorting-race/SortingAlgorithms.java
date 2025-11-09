public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement the Selection Sort algorithm.
       
        for(int i = 0; i < arr.length - 1; i++)
        {
            //finding minimum element index in unsorted array
            int min = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[min]) min = j;
            }
            
            //swapping the found element with first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        // TODO: Implement the Insertion Sort algorithm.
        
        for(int i = 1; i < arr.length; ++i)
        {
            int key = arr[i];
            int j = i -1;
            
            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
                
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        // TODO: Implement the recursive logic for Merge Sort.
        if(left < right)
        {
            //finding middle
            int mid = left + (right - left)/2;
            
            //sorting the halves
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid+1, right);
            
            //merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // TODO: Implement the merge logic for Merge Sort.
        System.arraycopy(arr, left, temp, left, right-left + 1);
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while(i <= mid && j <= right)
        {
            if(temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }
        
        while(i <= mid) arr[k++] = temp[i++];
    }
}
