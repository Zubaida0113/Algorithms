package Bit_Manipulation;

//Clearing a bit, also known as resetting or unsetting a bit, refers to setting 
//the value of a specific bit in a binary number to 0.


public class ClearBit {

    private static boolean isClearbit(int n,int i){
        int bitmask=1<<i;
        return (n&bitmask) == 0;
    } 

    private static int clearBit(int n,int i){
        int bitmask=1<<i;
        return (n& ~bitmask);
    }
    public static void main(String[] args) {
        int n=10;
        int pos=2;

        if(isClearbit(n,pos)){
            System.out.println("The " + pos + "th bit of " + n + " is already clear.");
        } else {
            System.out.println("The " + pos + "th bit of " + n + " is not clear.");
            n = clearBit(n, pos);
            System.out.println("After clearing the " + pos + "th bit, the new number is: " + n);
        }
    }
}
