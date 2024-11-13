import java.util.Random;
import java.util.Scanner;

public class Pract4s {

    // Sequential Search (Linear Search) method
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target element
            }
        }
        return -1; // Target element not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Create an array with 1,000,000 elements
        int[] arr = new int[1000000];

        // Fill the array with random integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000000); // Numbers between 0 and 999,999
        }

        // Input the target element
        System.out.println("Enter the element to search for:");
        int target = scanner.nextInt();

        // Perform Sequential Search
        long startTime = System.nanoTime();
        int result = sequentialSearch(arr, target);
        long endTime = System.nanoTime();

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }

        // Calculate and print time taken
        System.out.println("Time taken (Sequential Search): " + (endTime - startTime) / 1e6 + " ms");

        scanner.close();
    }
}
