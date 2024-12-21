import java.util.*;
public class fibonacci_DP {
    static final long MOD = 1000000007; // Use modulus to handle large values.

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return topDownHelper(n, dp);
    }

    static long topDownHelper(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = (topDownHelper(n - 1, dp) % MOD + topDownHelper(n - 2, dp) % MOD) % MOD;
        return dp[n];
    }

    static long bottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                
                long topDownans = topDown(n);
                long bottomUpans = bottomUp(n);
                if (topDownans != bottomUpans)
                    System.out.println("Not equal"+ (-1));
                else
                    System.out.println("Answer "+topDownans);

                System.out.println("~");
            }
        }
    }
}
