package HEAP_DS;

//Q: You're given an array of integers. Implement Heap Sort to sort the array in ascending order 
//using a Max Heap, without using any comparator or built-in heap utilities like priority_queue.

public class HeapSort {
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. N is size of heap

    //TOP-DOWN HEAPIFY where we start from the root(parent) and go downwards(child)
    static void maxheapify(int arr[], int n, int i) {
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
            maxheapify(arr, n, largest);
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
            maxheapify(arr, n, i);
        }
    }
    static void heapSort(int arr[]) {
        int n = arr.length;
        // Step 1: Build max heap
        buildMaxHeap(arr, n);

        // Step 2: One by one extract elements from heap
        // Move current root(which is max element) to end node 
        //and add it to the end of the unsorted array
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Call maxheapify on the reduced heap
            maxheapify(arr, i, 0);
        }
    }


    // A utility function to print the array
    // representation of Heap
    static void printHeap(int arr[], int n) {
        System.out.println("Array representation of Heap is:");

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
public static void main(String[] args) {
        // Binary Tree Representation
        // of input array
        //             4
        //           /    \
        //         10       3
        //       /  \     
        //     5      1  
          
        int arr[] = {4,10,3,5,1};
        int n = arr.length;
        heapSort(arr);
        printHeap(arr, n);
    }
}
