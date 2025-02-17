public class Array_insertion {
    // This function returns n+1 if insertion is successful, else n.
    static int insertEnd(int arr[], int n, int capacity, int key) {

        if (n == capacity)
            return n;

        arr[n] = key;
        return n + 1;
    }

    static void insertAtAnyPosition(int arr[], int n, int x,
            int pos) {
        // shift elements to the right
        // which are on the right side of pos
        for (int i = n - 1; i >= pos; i--)
            arr[i + 1] = arr[i];
        arr[pos] = x;
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
int pos=2;
        // Inserting key at specific position
        insertAtAnyPosition(arr, n, keyValue, pos);
        n += 1;

        System.out.print("\n\nAfter Insertion: ");
        for (int j = 0; j < n; j++)
            System.out.print(arr[j] + " ");
    }
}
