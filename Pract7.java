import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pract7 {
    
    public static void makeChange(int amount, int[] denominations) {
        List<Integer> coinsUsed = new ArrayList<>();
        
        // Sort denominations in descending order (assumed to be pre-sorted in this example)
        for (int i = 0; i < denominations.length; i++) {
            while (amount >= denominations[i]) {
                amount -= denominations[i];
                coinsUsed.add(denominations[i]);
            }
        }
        
        if (amount > 0) {
            System.out.println("Exact change cannot be made with the given denominations.");
        } else {
            System.out.println("Coins used to make the change: " + coinsUsed);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Example denominations (assuming they are sorted in descending order)
        int[] denominations = {25, 10, 5, 1}; // Denominations: quarters, dimes, nickels, pennies
        
        System.out.print("Enter the amount you want to change: ");
        int amount = scanner.nextInt();
        
        makeChange(amount, denominations);
        
        scanner.close();
    }
}
