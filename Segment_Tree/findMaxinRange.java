package Segment_Tree;
// Find the maximum value in the range [left, right]
// We can use the segment tree to find the maximum in O(log n) time

public class findMaxinRange {
    static int[] segmentTree= new int[4*10000];
    private static void buildSegmentTree(int index, int start, int end, int[] arr) {
        // Build the segment tree from the array
        //Base case: when the range has only one element => the start and end index are same 
        //we assign the value to the segment node and return
        if(start == end){
            segmentTree[index] = arr[start];
            return;
        }

        // Step 1: find mid of range
        int mid=(start+end)/2;
        //Step 2: divide the range into 2 part left and right sub-tree and we will do till we reach the leaf nodes.
        buildSegmentTree(2 * index + 1, start, mid, arr);
        buildSegmentTree(2 * index + 2, mid+1, end, arr);

        //perform max operation and backtract (here we can modify the operation based ont he question requirement)ˀ
        segmentTree[index]= Math.max(segmentTree[2*index+1],segmentTree[2*index+2]);
    }
    private static int findMaxInRange(int index,int start,int end,int left, int right, int[] arr) {
        // first we ALWAYS check the node range is in the query range or not.
        
        //NODE RANGE: [start, end]
        //QUERY RANGE: [left, right]

        // Case 1: If the range is invalid, return Integer.MIN_VALUE 
        if(end<left || start>right){
            return Integer.MIN_VALUE;
        }
        // Case 2: Is the entire segment [start, end] completely inside the query range [left, right]? 
        // If yes, we return the value stored in the segment tree at this index
        if(left<=start && end<=right){
            return segmentTree[index];
        }
        // Case 3: If the range is partially within the segment, we need to check both left and right subtrees
        int mid = (start + end) / 2;
        int leftMax = findMaxInRange(2 * index + 1, start, mid, left, right, arr);
        int rightMax = findMaxInRange(2 * index + 2, mid+1, end, left, right, arr);
        // Return the maximum of the two
        return Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
       int [] arr = {1, 3, 5, 7, 9, 11};
       int n = arr.length;
       buildSegmentTree(0, 0, n - 1, arr);

       int left = 1; // inclusive
       int right = 3; // inclusive
       int max= findMaxInRange(0,0,n-1,left, right, arr);
       System.out.println("Maximum value in range [" + left + ", " + right + "] is: " + max);
    }
}
