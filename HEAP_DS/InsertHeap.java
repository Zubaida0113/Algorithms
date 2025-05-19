package HEAP_DS;
//this is example of insetion and deletion in MAX heap
public class InsertHeap {
//TOP DOWN HEAPIFY where we start from the root(parent) and go downwards(child)
//FOR DELETION AND BUILD HEAP
    static void TopDownheapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            TopDownheapify(arr, n, largest);
        }
    }

    // Function to build a Max-Heap from the given array
    static void buildMaxHeap(int arr[], int n) {
        // Index of last non-leaf node
        int lastNonLeafNode = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = lastNonLeafNode; i >= 0; i--) {
            TopDownheapify(arr, n, i);
        }
    }
    //BOTTOM UP HEAPIFY where we start from the child and go upwards(parent)
    static void BottomUPheapify(int [] arr,int n,int i){
        int parent=(i-1)/2;
        //till we reach the root
        if(parent>=0){
            // For Max-Heap
            // If current node is greater than its parent
            // Swap both of them and call heapify again
            // for the parent
            if(arr[parent]<arr[i]){
                int temp=arr[parent];
                arr[parent]=arr[i];
                arr[i]=temp;
                BottomUPheapify(arr,n,parent);
            }
        }
    }
        
    static void printHeap(int arr[], int n) {
        // System.out.println("Array representation of Heap is:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static int insert(int[]arr,int n,int key){
        // Increase the size of Heap by 1
        n = n + 1;
        // Insert the element at end of Heap
        arr[n - 1] = key;
        // Heapify the new node following a Bottom-up approach
        BottomUPheapify(arr, n, n - 1);
        // return new size of Heap
        return n;
    }
    static int delete(int[]arr,int n)
    {
        int lastElement = arr[n - 1]; // Store the last element
        arr[0] = lastElement; // Move the last element to the root
        n=n-1; // Reduce the size of the heap
        TopDownheapify(arr, n, 0); // Heapify the root element
        return n; // Return the new size of the heap
    }
    public static void main(String[] args) {
        int[] arr1 = {4, 10, 3, 5, 1};
        int n1 = arr1.length;
        buildMaxHeap(arr1, n1);
        System.out.println("Max Heap:");
        printHeap(arr1, n1);
        n1=delete(arr1, n1);
        System.out.println("Max Heap after deletion:");
        printHeap(arr1, n1);
        int[]arr=new int[10];
        arr[0]=4;
        arr[1]=10;
        arr[2]=3;
        arr[3]=5;
        arr[4]=1;
        int n = 5;
        System.out.println("Heap before insertion:");
        printHeap(arr, n);
        int key=15;
        System.out.println("Heap after insertion:");
        n=insert(arr,n,key);
        printHeap(arr, n);
    }
}
// | Version                                       | Purpose           | Direction            | Use Case                         |
// | --------------------------------------------- | ----------------- | -------------------- | -------------------------------- |
// | `heapify_bottom_up` (your first version here) | Bottom-up heapify | From child to parent | ✅ **Insertion**                  |
// | `heapify_top_down` (second version)           | Top-down heapify  | From parent to child | ✅ **Deletion**, ✅ **Build-Heap** |
