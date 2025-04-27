package Bit_Manipulation;

//Mathematical observation - All the even nos have 0 in the last bit 
//                           while all the odd nos have 1 in the last bit.
// So we can use bitwise operator to check if the no is even or odd.

// Algo - 1.find bitwise AND of the 'n' and 1.
//        2. if the result is 0 then the no is even else odd
//        3. otherwise its odd.
// Example - 10 & 1 = 0 => even
//          11 & 1 = 1 => odd
// Time complexity - O(1)
// Space complexity - O(1)

public class EvenOdd {

    private static boolean isEvenorOdd(int n){
        int res= n & 1;
        if(res==0){
            return true; // even
        }
        else{
            return false; // odd
        }
    }
    public static void main(String[] args) {
        int n = 1101;
        if(isEvenorOdd(n)){
            System.out.println(n+" is Even");
        }
        else{
            System.out.println(n+" is Odd");
        }
    }
}
