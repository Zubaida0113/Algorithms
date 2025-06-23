package ARRAYS;

import java.util.HashSet;
import java.util.Set;

public class beautifulfunction {

    public static int beautifulFunction(int n) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        while (n > 0 && !visited.contains(n)) {
            visited.add(n);

            n = n + 1;
            int temp = n % 10;
            int diff = 10 - temp;

            count += diff;
            n = n + diff;
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;  // Try different values
        int result = beautifulFunction(n);
        System.out.println("The result of the beautiful function for n = " + n + " is: " + result);
    }
}
