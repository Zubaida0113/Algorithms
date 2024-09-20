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