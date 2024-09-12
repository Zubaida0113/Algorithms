/*Ques- To check if an Array is Sorted or not(Iterative approach)
 * Concept- 1. If length of array is less than equal to 1 , array is already sorted -> no need to follow loop
 *             -> Getting best case O(N). (Eg.- arr[]={5} ) 
 *          2. We create flag variable with assumption that array is sorted, and use the for loop to check the condition.
 *          3. Now for the loop we need to check if the current element is greater than next or adjacent element.
 *             If 'true' -> flag variable becomes false -> break out of loop ->return flag.(unsorted)
 *             If 'false' -> i variable will check till end of array -> returns flag==true.(sorted)
 */
public class check_sorted_array {
// ITERATIVE APPROACH 
    static boolean sorted_check(int[] arr){
        int n=arr.length;
        boolean flag=true;
        
        if(n==0||n==1){
            return flag;
        }

        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
// RECURSIVE APPROACH -O(N) for both time and space complexity
    static boolean arraySortedOrNot(int a[], int n)
    {
        if (n == 1 || n == 0)
            return true;
        // check if present index and index  previous to it are in correct orderand rest of the array is also sorted
        // if true then return true else return false
        //eg. 3>5==No(sorted) && 5>6==No(sorted) && 6>8==No(sorted)
        //                    |    Comes from recursive function   |
        //     true && true && true (logical operator AND is used here)
        //    => true
        return a[n - 1] >= a[n - 2] && arraySortedOrNot(a, n - 1);
    }
    public static void main(String[] args) {
        int []arr={3,5,6,8};
        int n=arr.length;
        boolean ans=sorted_check(arr);
        boolean res=arraySortedOrNot(arr,n);
        System.out.println(ans);
        System.out.println(res);
    }
}
/* Time complexity = O(N)(Worst case), O(1)(best case)
 * Space complexity = O(1) ,as we use only flag variable to store a boolean value
 */