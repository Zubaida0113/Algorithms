/*This question describes a cipher strategy for encrypting strings. Here's a breakdown of the problem:
You're given a string of lowercase letters and a cipher strategy.
The cipher assigns each letter in the alphabet a number from 1 to 26.
There are special characters () that modify the value assigned to a letter:
'a' is assigned 1
'b' is assigned 2
'c' is assigned 3
and so on...
The special character adds a value x to the letter's assigned number.
If is placed after a letter, it would add x to that letter's value.
Sample test case:
Input string: "aczbc"
x = 10
Output: 1133623 */

/*ALGORITHM
 * 1. Initialize an empty result string
2. Set i = 0 (index for iterating through the input string)
3. While i < length of input string:
    a. Get current character c at index i
    b. If c is a letter:
        i. Convert c to its numeric value (1-26)
        ii. If next character is '*':
            - Add x to the numeric value
            - Increment i to skip the '*'
        iii. Append the final numeric value to result string
    c. Increment i
4. Return the result string
 */
public class string1 {
    
    public static String encryptString(String input, int x) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                int value = letterToNumber(c);
                
                // Check for '*' and adjust value
                if (i + 1 < input.length() && input.charAt(i + 1) == '*') {
                    value += x;
                    i++; // Skip the '*'
                }
                
                result.append(value);
            }
            i++;
        }
        
        return result.toString();
    }

    private static int letterToNumber(char letter) {
        return Character.toLowerCase(letter) - 'a' + 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        String input = "a*cz*bc";
        int x = 10;
        System.out.println(encryptString(input, x)); // Should output: 1133623
    }
}