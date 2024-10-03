class missingNumber {
    public int missingNum(int[] nums) {
        int n = nums.length;
        int sum1 = (n * (n + 1)) / 2;
        int missingdiff,sum2=0;
        for (int i = 0; i < n; i++) {
            sum2 += nums[i];
        }
        missingdiff = sum1 - sum2;
        return missingdiff;
    }
    public static void main(String[] args) {
        missingNumber mn = new missingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(mn.missingNum(nums));
    }
}