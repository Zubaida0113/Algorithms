package Segment_Tree;

import java.util.Scanner;

public class RangeSum {
    static int n=200001; // Size of the array
    static int arr[]=new int[n]; // Number of queries
    static long seg[] = new long[4 * n];

    // Function to build the segment tree
    //low=0 idx=0 high=n-1
    static void build_St(int idx, int low, int high){
        if(low==high){
            seg[idx]=arr[low];
            return;
        }
        int mid=high+(high-low)/2;
        build_St(2*idx+1,low,mid);
        build_St(2*idx+2,mid+1,high);
        seg[idx]= seg[2*idx+1] + seg[2*idx+2];
    }
    // Function to get the sum in the range [l, r]
    static long query_Range_Sum(int idx,int low,int high,int l,int r){
        if(l<=low && high<=r){
            return seg[idx]; // (low,high) completely inside the query range [l, r]
        }
        else if(high<l || r<low){
            return 0;  // (low,high) completely outside the query range [l, r]
        }
        else{ // (low,high) partially inside the query range [l, r]
            // We need to check both left and right subtrees
            int mid=low+(high-low)/2;
            long leftSum =  query_Range_Sum(2*idx+1,low,mid,l,r);
            long rightSum = query_Range_Sum(2*idx+2,mid+1,high,l,r);
            return leftSum + rightSum;
        }
    }

    //update the value at index idx to val
    static void update(int idx,int low,int high,int i,int nv){
        if(low==high){
            seg[idx]=nv; // Update the value at the leaf node
            return;
        }
        int mid=low+(high-low)/2;
        if(i<=mid){
            update(2*idx+1,low,mid,i,nv); // Update in the left subtree
        }else{
            update(2*idx+2,mid+1,high,i,nv); // Update in the right subtree
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2]; // Update the parent node
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int q = sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        build_St(0,0,n-1); // Build the segment tree
        while(q-->0){
            // Read the type of query
            int type = sc.nextInt();
            if(type==2){ // Query for range sum
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(query_Range_Sum(0,0,n-1,a,b));
            }else{ // Update the value at index i
                int k = sc.nextInt();
                int u = sc.nextInt();
                update(0,0,n-1,k,u);
            }
        }
        sc.close();

    }

}
