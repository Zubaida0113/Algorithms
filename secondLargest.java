/* Ques- Find SecondLargest Element in the array ()
 * Concept 1 (ONE TRANSVERSAL)- 
 *          1. Initialize the first as 0(i.e, index of arr[0] element
 *          2. Start traversing the array from array[1]
 *          3. If the current element in array say arr[i] is greater than first,  ->Then update first and second 
 *  //O(N)     as, second = first and first = arr[i]
 *          4. If the current element is in between first and second, then update second to store 
 *             the value of current variable as second = arr[i]
 *          5. Return the value stored in second.    
 * 
 * Concept 2 (TWO TRANSVERSAL)-
 *          1. Initialize two variable for Largest and secondLargest element  
 *   //O(N) 2. In the first traversal, find the maximum element (Largest)
 *          3. In the second traversal, find the greatest element excluding the previous greatest.(secondLargest)
 */
public class secondLargest {
    // Concept-2
    static int SecLargest(int[] arr) {
        int Largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        if (arr.length < 2) {
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            Largest = Math.max(Largest, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != Largest) {
                secondLargest = Math.max(secondLargest, arr[i]);
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    // concept-1
    static int Sec2Largest(int[] arr) {
        int Largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int i;
        if (arr.length < 2) {
            return arr[0];
        }
        for (i = 0; i < arr.length; i++) {
            /*
             * If current element is greater than
             * first then update both first and second
             */
            if (arr[i] > Largest) {
                secondLargest = Largest;
                Largest = arr[i];
            }

            /*
             * If arr[i] is in between first and
             * second then update second
             */
            else if (arr[i] > secondLargest && arr[i] != Largest)
                secondLargest = arr[i];
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;//this is to check if there are duplicate elements
    }

    public static void main(String[] args) {
        int[] arr = { 9,0,8,6};
        int Second = SecLargest(arr);
        int Second2 = Sec2Largest(arr);
        System.out.println(Second);
        System.out.println(Second2);
    }
}
/*
 * Time Complexity: O(n), where n is the size of input array.
 * Auxiliary space: O(1), as no extra space is required.
 */