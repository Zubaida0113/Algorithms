package ARRAYS;

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
        int pivot=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            reverse(arr,0,n-1);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[pivot]){
                swap(arr,i,pivot);
                break;
            }
        }
        reverse(arr,pivot+1,n-1);
    }
    
    void reverse(int []arr,int s,int e){
        while(s<e){
            swap(arr,s++,e--);
        }
    }
    void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}

//{ Driver Code Starts.

public class nextpermutation  {
    public static void main(String[] args) throws Exception {
       int [] arr = {2,4,1,7,5,0};
        Solution obj = new Solution();
        obj.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends