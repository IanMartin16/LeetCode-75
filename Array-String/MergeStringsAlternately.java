public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        int maxLength = Math.max(length1, length2);

        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                mergedString.append(word1.charAt(i));
            }
            if (i < length2) {
                mergedString.append(word2.charAt(i));
            }
        }

        return mergedString.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        String result = mergeAlternately(word1, word2);
        System.out.println(result); // Output: "apbqcr"

        word1 = "ab";
        word2 = "pqrs";
        result = mergeAlternately(word1, word2);
        System.out.println(result); // Output: "apbqrs"

        word1 = "abcd";
        word2 = "pq";
        result = mergeAlternately(word1, word2);
        System.out.println(result); // Output: "apbqcd"
    }
}


//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. 
//If a string is longer than the other, 
//append the additional letters onto the end of the merged string.

//Return the merged string.