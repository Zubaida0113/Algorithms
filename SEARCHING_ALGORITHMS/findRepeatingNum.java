package SEARCHING_ALGORITHMS;

import java.util.HashSet;

class findReapeatingNum{

    // Function to find the repeating number
    //BRUTE FORCE - O(n^2)
    //Algo - 1. Use of two for loops - outer and inner
    //       2. Outer loop keeps track for all elements
    //       3. Inner loop checks for the repeating element
    //       4. If found, return the element, otherwise return -1

    public static int findRepeating(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    //OPTIMIZED (HashSet)- O(n)

    //Algo - 1. Use of HashSet to store the elements
    //       2. minIndex - variable to keep track of index of repeating number that appeaars first  
    //       2. Traverse the array and check if the element is already present in the HashSet
    //       3. If present, return the minIndex, otherwise add it to the HashSet

    public static int findRepeatingOptimized(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        int minIndex = Integer.MAX_VALUE;

        for (int i = n-1; i >=0; i--) {
            if (set.contains(arr[i])) {
                minIndex = Math.min(minIndex, i);
            } 
            set.add(arr[i]);
        }

        return minIndex == Integer.MAX_VALUE ? -1 : arr[minIndex];
    }
    public static void main(String[] args) {
        int[] arr= {1, 2, 5, 3, 4, 5, 3};
        int n = arr.length;
        int result = findRepeating(arr, n);
        if (result != -1) {
            System.out.println("The repeating number is: " + result);
        } else {
            System.out.println("No repeating number found.");
        }
        int resultOptimized = findRepeatingOptimized(arr, n);   
        if (resultOptimized != -1) {
            System.out.println("The repeating number is: " + resultOptimized);
        } else {
            System.out.println("No repeating number found.");
        }
    }
}
