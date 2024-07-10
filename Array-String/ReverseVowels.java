import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello")); // Output: holle
        System.out.println(reverseVowels("leetcode")); // Output: leotcede
        System.out.println(reverseVowels("aA")); // Output: Aa
    }
}


//Given a string s, reverse only all the vowels in the string and return it.

//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.