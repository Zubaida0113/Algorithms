package Bit_Manipulation;

//Algo - 1. find the ith bit of a number
//        2. create a bitmask by left shifting 1 by i positions
//        3. use bitwise OR operator to check if the ith bit is set or not
//        4. if the ith bit is set then return true else false
//        5. return the number after setting the ith bit if true.
// Example - n=10, i=2
//          10 = 1010
//          2 = 0010
//          1<<2 = 0100
//          10|0100 = 1010
//          1010 == 1010 => true

// Time complexity - O(1)
// Space complexity - O(1)
public class SetBit {
   //fun to check if bit is set or not
    private static boolean isBitSet(int n, int i) {
        //create a bitmask by left shifting 1 by i positions
        int bitmask = 1<<i;
        return (n|bitmask) == n;
        // returns true if the ith bit is set(1)
        // returns false if the ith bit is not set(0)
    }

    //fun to set the ith bit
    private static int SettheBit(int n,int i){

        int bitmask = 1<<i;
        return (n|bitmask);
       
    }

    public static void main(String[] args) {
        int n = 5; // Example number
        int i = 2; // Bit position to check

        if (isBitSet(n, i)) {
            System.out.println("The " + i + "th bit of " + n + " is already set.");
        } else {
            System.out.println("The " + i + "th bit of " + n + " is not set.");
            n = SettheBit(n, i);
            System.out.println("After setting the " + i + "th bit, the new number is: " + n);
        }
    }
}
