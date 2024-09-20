class arrangecoins {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }
    class Solution {
        public int arrangeCoinss(int n) {
            long left = 0;
            long right = n;
            
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long totalCoins = mid * (mid + 1) / 2;
                
                if (totalCoins == n) {
                    return (int) mid;
                } else if (totalCoins < n) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            return (int) right;
        }
    }
    public static void main(String[] args) {
        arrangecoins ac = new arrangecoins();
        Solution solution = ac.new Solution();
        System.out.println(ac.arrangeCoins(8));
        System.out.println(solution.arrangeCoinss(8));
    }
}