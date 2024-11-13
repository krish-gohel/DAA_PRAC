import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pract4b {

    // Binary Search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
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

        // Sort the array before performing Binary Search
        Arrays.sort(arr);

        // Input the target element
        System.out.println("Enter the element to search for:");
        int target = scanner.nextInt();

        // Perform Binary Search
        long startTime = System.nanoTime();
        int result = binarySearch(arr, target);
        long endTime = System.nanoTime();

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }

        // Calculate and print time taken
        System.out.println("Time taken (Binary Search): " + (endTime - startTime) / 1e6 + " ms");

        scanner.close();
    }
}
