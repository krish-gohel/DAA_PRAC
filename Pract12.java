public class Pract12 {
    
    // Function to calculate the minimum number of multiplications needed
    public static int matrixChainOrder(int[] p, int n) {
        // Create a table to store the minimum number of multiplications
        int[][] dp = new int[n][n];

        // dp[i][j] = minimum number of multiplications needed to multiply matrices Ai...Aj
        // The chain length ranges from 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible positions to split the product
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }

        // The result is in dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // Dimensions of the matrices (A1 = 10x30, A2 = 30x5, A3 = 5x60)
        int[] dimensions = {10, 30, 5, 60};
        int n = dimensions.length - 1; // Number of matrices

        int minMultiplications = matrixChainOrder(dimensions, n);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}
