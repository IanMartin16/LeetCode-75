public class MaxVowelsInSubstring {
    // Método para verificar si un carácter es una vocal
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;

        // Contar el número de vocales en los primeros k caracteres
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // Usar la técnica de la ventana deslizante para encontrar el máximo número de vocales
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(maxVowels(s1, k1)); // Output: 3

        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(maxVowels(s2, k2)); // Output: 2

        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(maxVowels(s3, k3)); // Output: 2
    }
}


//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.