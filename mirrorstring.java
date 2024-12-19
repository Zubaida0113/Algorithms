public class mirrorstring {
    public static int common(String s1, String s2, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + common(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(common(s1, s2, n - 1, m), common(s1, s2, n, m - 1));
        }
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

    public static void main(String[] args) {
        String s1 = "SEA";
        String s2 = "EAT";
        String r1 = reverseString(s1);
        String r2 = reverseString(s2);
        int lcs = common(s1, s2, s1.length(), s2.length());
        int revlcs = common(r1, r2, r1.length(), r2.length());
        
        System.out.println("LCS of original strings: " + lcs);
        System.out.println("LCS of reversed strings: " + revlcs);
        
        // Check if the original strings are palindromes
        boolean isS1Palindrome = isPalindrome(s1);
        boolean isS2Palindrome = isPalindrome(s2);
        
        // Print palindrome results
        System.out.println(s1 + " is palindrome: " + isS1Palindrome);
        System.out.println(s2 + " is palindrome: " + isS2Palindrome);
        
        // Check if LCS values indicate palindrome-like behavior
        if (lcs == revlcs ) {
            System.out.println("Both strings are palindromes and LCS is: " + lcs);
        } else {
            System.out.println("Strings are not palindromes or LCS values do not match.");
        }
    }
}
