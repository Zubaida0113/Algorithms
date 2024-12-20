public class knapsack_DP {
// this is a recursive solution with O(2^N) time complexity. To reduce the time complexity we do this via Memoization(top-down) or Tabulation(bottom-up) approach which is  a DP Solution.
    int maxProfit(int[] wt,int[] val, int W,int n){
        if(n==0||W==0){
            return 0;
        }
        if(wt[n-1]<W){
            return Math.max(val[n-1]+maxProfit(wt, val, W-wt[n-1], n-1),maxProfit(wt, val, W, n-1));
        }
        else{
            return maxProfit(wt, val, W, n-1);
        }
    }
    // How to check for DP ? 
    // 1. CHOICE (koi choice ho yes or no mai) 2. OPTMAL kuchh pucha ho (max,min ,largest)
    // DP - Method to solve Enhanced Recursion (Recursive Calls + Overlapping subproblems)
    // DP is used to convert exponential time complexity to polynomial time complexity.
    public static void main(String[] args) {
        int wt[]={1,3,4,5};
        int val[]={1,4,5,7};
        int W=7;
        int n=wt.length;
        knapsack_DP knapsack = new knapsack_DP(); 
        System.out.println(knapsack.maxProfit(wt,val,W,n));
    }
}