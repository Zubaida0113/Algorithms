package INFOSYS.SlidingWindowplusHashing;

//ques : to find count of anagrams in the main string
public class countAnagrams {
    public static int countTheAnagrams(String a, String b) {
        int main = a.length();
        int sub = b.length();
        if (main < sub)
            return 0;
        int[] subfreq = new int[26];
        int[] mainfreq = new int[26];

        for (char c : b.toCharArray()) {
            subfreq[c - 'a']++;
        }
        for (int i = 0; i < sub; i++) {
            mainfreq[a.charAt(i) - 'a']++;
        }
        int count = 0;
        if (areEqual(subfreq, mainfreq))
            count++;
        for (int i = sub; i < main; i++) {
            mainfreq[a.charAt(i) - 'a']++;
            mainfreq[a.charAt(i - sub) - 'a']--;
            if (areEqual(subfreq, mainfreq))
                count++;
        }
        return count;
    }

    private static boolean areEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String mainString = "forxxorfxdofr";
        String pattern = "for";
        System.out.println(countTheAnagrams(mainString, pattern));

    }
}
/*
 * Time Complexity = O(n)
 * Space = O(1) (just 2 arrays of size 26)
 */