package ARRAYS;

public class leftRotation {
    
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n=arr.length;
        d%=n;
        //first copy elements after d elements into temp arr b[]
        reverse(arr,d,n-1);
        for(int i=0;i<n;i++){
              System.out.print(arr[i]+" ");
            }
            System.out.println();
        // for(int i=d;i<n;i++){
        //     reverse()
        // }
        //second copy first d elements into temp arr b[]
        reverse(arr,0,d-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
          }
          System.out.println();
        // for(int i=0;i<=d-1;i++){
        //     b[j++]=arr[i];
        // }
        //for copying b[] to arr[]
        reverse(arr,0,n-1);
        // for(int i=0;i<n;i++){
        //     arr[i]=b[i];
        // }
    }
    static void reverse(int [] arr,int i,int j){
       
        while (i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            
            i++;
            j--;
            
        }

    }
    public static void main (String[] args) {
        /* code */
        int arr[]={10,20,30,40,50};
        int d=2;
        rotateArr(arr,d);
        for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
        }
        
    }
}
