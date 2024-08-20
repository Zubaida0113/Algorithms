import java.util.Scanner;

public class right_rotation {
    static void insert(int[] arr, int n, int pos, int element) {
        // Check if the position is valid
        if (pos < 0 || pos > n) {
            System.out.println("Invalid position");
            return;
        }

        // Create a new array with size n + 1
        int[] newArr = new int[n + 1];

        // Copy elements to the new array
        for(int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new element
        newArr[pos] = element;

        // Copy the remaining elements
        for(int i = pos; i < n; i++) {
            newArr[i + 1] = arr[i];
        }

        // Print the new array
       // for (int i = 0; i < newArr.length; i++) {
       //     System.out.print(newArr[i]+" ");
       // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter position to insert: ");
        int pos = sc.nextInt();
        System.out.print("Enter element to insert: ");
        int element = sc.nextInt();
        sc.close();

        int[] arr = { 4, 6, 2, 3, 9 };
        int n = arr.length;

        insert(arr, n, pos, element);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
