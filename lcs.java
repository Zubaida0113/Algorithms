class lcs{
    // This id a Recursive approach
    public static int common(String s1,String s2,int n,int m){
        // int n=s1.length();
        // int m=s2.length();
        // base condition - ifthe length of any string becomes 0 or empty string return 0
        if(m==0||n==0){
            return 0;
        }
        //We start checking from last character and then moves prior
        // if character mactches, add 1 and recall the function for prior characters(n-1,m-1) and return ans
        if(s1.charAt(n-1)==s2.charAt(m-1)){
           return 1+common(s1,s2,n-1,m-1);
        }
        //if character doesn't match , we check first by removing last character from s1 and then remove last character from s2
        // the ans here will go to the if loop if the initial step had common character otherwise it will return the ans here.
        else{
            return Math.max(common(s1,s2,n-1,m),common(s1,s2,n,m-1));
        }
    }
    // time complexity = O(2^N)
    // space complexity = O(N)

    // Topdown solution
    public static int LCSdynamic(String s1,String s2,int n,int m,int dp[][]){  
        if(m==0||n==0){
            return 0;
        }
        if(dp[n][m]!= -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
           return dp[n][m]=1+LCSdynamic(s1,s2,n-1,m-1,dp);
        }
        else{
            return dp[n][m] = Math.max(LCSdynamic(s1,s2,n-1,m,dp),LCSdynamic(s1,s2,n,m-1,dp));
        }
    }
    // tabulation solution
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
        String s1="ABCAB";
        String s2="AECB";
        int n=s1.length();
        int m=s2.length();
        int ans=common(s1,s2,s1.length(),s2.length());
        int dp[][]=new int [n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1; // Initialize all values to -1
            }
        }
        int ns=LCSdynamic(s1,s2,s1.length(),s2.length(),dp);
        System.out.println();
        System.out.println("RECURSION "+ ans);
        System.out.println("DYNAMIC "+ns);
    }
}