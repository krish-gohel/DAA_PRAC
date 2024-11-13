public class Pract13 {

    // Function to calculate the length of the longest common subsequence
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a 2D array to store lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp array in a bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum of excluding one character
                }
            }
        }

        // Length of LCS is found at dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int length = lcs(X, Y);
        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
