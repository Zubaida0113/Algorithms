public class houseRobber {
    
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return nums[0]; // Only one house
        }
        if(n==2){
            return Math.max(nums[0],nums[1]); // Two houses, pick the max
        }
        return Math.max(nums[n-1]+robMax(nums,n-3),robMax(nums,n-2));
    }
    int robMax(int []nums,int i){
        if(i<0){
            return 0;// No houses left to rob
        }
        return Math.max(nums[i]+robMax(nums,i-2),robMax(nums,i-1));
    }

static  public int robDP(int[] nums,int[] dp) {
        int n=nums.length;
        if (n == 0) {
            return 0; // No houses to rob
        }
        if(n<=1){
            return nums[0]; // Only one house
        }
        if(n==2){
            return Math.max(nums[0],nums[1]); // Two houses, pick the max
        }
        
         return robMaxDP(nums, n - 1, dp);
    }
    static int robMaxDP(int []nums,int i,int[]dp){
        if(i<0){
            return 0;// No houses left to rob
        }
        if(dp[i]!=0){
            return dp[i];
        }
        return dp[i] = Math.max(nums[i] + robMaxDP(nums, i - 2, dp), robMaxDP(nums, i - 1, dp));
        
    }

    public int robBottomDP(int[] nums) {
        int n=nums.length;
        int []dp=new int[n+1];
        if (n == 0) {
            return 0; // No houses to rob
        }
        if(n==1){
            return nums[0]; // Only one house
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    } 
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        int n=nums.length;
        int dp[]=new int[n+1];
        System.out.println(robDP(nums, dp));
    }
}
