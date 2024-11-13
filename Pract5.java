import java.util.Arrays;

public class Pract6 {
    
    // Partition function to arrange elements around pivot
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
    
    // Quick sort function
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            
            quickSort(array, low, pi - 1); // Sort the left part
            quickSort(array, pi + 1, high); // Sort the right part
        }
    }
    
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        
        System.out.println("Given Array: " + Arrays.toString(array));
        
        quickSort(array, 0, array.length - 1);
        
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
