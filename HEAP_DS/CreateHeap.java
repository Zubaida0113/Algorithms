package HEAP_DS;
import java.util.Arrays;

public class CreateHeap {

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. N is size of heap
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

    static void minheapify(int arr[], int n, int i){
        int smallest=i;
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        
        if(l<n && arr[l]<arr[smallest]){
            smallest=l;
        }
         if(r<n && arr[r]<arr[smallest]){
            smallest=r;
        }
        
        if(smallest!=i){
            int swap=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=swap;
            minheapify(arr,n,smallest);
        }
    }
    // Function to build a Max-Heap from the given array
    static void buildMinHeap(int arr[], int n) {
        // Index of last non-leaf node
        int lastNonLeafNode = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = lastNonLeafNode; i >= 0; i--) {
            minheapify(arr, n, i);
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

    // Driver Code
    public static void main(String[] args) {
        // Binary Tree Representation
        // of input array
        //             4
        //           /    \
        //         10       3
        //       /  \     
        //     5      1  
          
        int arr[] = {4,10,3,5,1};
        int arr2[]=Arrays.copyOf(arr,arr.length);

        int n = arr.length;

        // Function call
        buildMaxHeap(arr, n);
        printHeap(arr, n);

        buildMinHeap(arr2, n);
        printHeap(arr2, n);

        // Final Max Heap:
        //             10
        //           /    \
        //         5       3
        //       /  \     
        //     4      1  

        // Final Min Heap:
        //             1
        //           /    \
        //         4       3
        //       /  \     
        //     5      10 
    }
}