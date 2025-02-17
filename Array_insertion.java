public class Array_insertion {
//This function returns n+1 if insertion is successful, else n.
    static int insertEnd(int arr[], int n, int capacity, int key) {

        if(n==capacity)
            return n;
        
        arr[n]=key;
        return n+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = 20;
        int n = 6;
        int i, keyValue = 26;

        System.out.print("Before Insertion: ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Inserting key
        n = insertEnd(arr, n, capacity, keyValue);

        System.out.print("\n After Insertion: ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
