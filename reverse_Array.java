/* Ques - Reverse elements in an array
 * Concept- Here we are using two pointer method toreverse the array by swapping the first and last element at each 
 * iteration along with incrementing low and decrementing high variable till the while condition is valid. 
 * So this reverse approach is in-place, meaning we won't need extra space to to do our operation.
 */
public class reverse_Array {
    public static int[] reverse(int []arr){
        int low=0;
        int high=arr.length-1;
        int temp;
        while(low<high){
            temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int []arr={3,5,7,1,8};
        int []ans=reverse(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
// Time Complexity - O(n)
// Time Complexity - O(1)
