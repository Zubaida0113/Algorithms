public class moveZeroes {
    public static void moveZero(int[] a) {
        int n = a.length;
        int i = 0;
        int j=0;
       while(j<n){
        if(a[j]==0){
            j++;
        }
        else{
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j++;
        }
    } 
    }
    public static void main(String[] args) {
        
        int[] a = {0, 1, 0, 3, 12};
        moveZero(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

