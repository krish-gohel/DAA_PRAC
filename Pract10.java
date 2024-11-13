import java.util.Scanner;

public class Pract10 {
    
    // Function to find the minimum number of coins needed for change
    public static int minCoins(int[] coins, int amount) {
        // Array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a large value (amount + 1)
        // This indicates that the amount is initially unreachable
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // Set to an unreachable value
        }

        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Loop through each coin
        for (int coin : coins) {
            // Update the dp array for all amounts from coin to amount
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        // If dp[amount] is still unreachable, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example denominations
        int[] coins = {1, 5, 10, 25}; // Denominations: pennies, nickels, dimes, quarters
        
        System.out.print("Enter the amount you want to change: ");
        int amount = scanner.nextInt();
        
        int result = minCoins(coins, amount);
        
        if (result == -1) {
            System.out.println("It's not possible to make change for the given amount with the available denominations.");
        } else {
            System.out.println("Minimum coins needed to make change for " + amount + ": " + result);
        }
        
        scanner.close();
    }
}
