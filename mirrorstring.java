// Idea - if the lcs of str and its reverse str is same then it has a palindromic subsequence.
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, rev);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Bottom-up dynamic programming approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testString = "bbbab"; // Example input
        int result = solution.longestPalindromeSubseq(testString);
        System.out.println("Longest Palindromic Subsequence Length: " + result);
    }
}