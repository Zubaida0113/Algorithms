/*Question -  find the largest element in the array. 
Concept - Here we take a temp variable to store the largest element at each iteration of loop , initially initialized
          with first element.We will transverse array till end checking if the the current element arr[i] is greater 
          then the temp. largest element.If it's the case then we will store the current element and move on,
           otherwise we will skip the iteration.

*/
class largest_element{
    static int largest(int []arr){
        int temp=arr[0];
        for(int i=1;i<arr.length;i++){
            if(temp<arr[i]){
                temp=arr[i];
            }
        }
        return temp;
    }
    public static void main(String[] args){
        int []arr={3,5,7,1,8};
        int ans=largest(arr);
        System.out.println(ans);
    }
}
// Time complexity= O(n)
// Space complexity= O(1)