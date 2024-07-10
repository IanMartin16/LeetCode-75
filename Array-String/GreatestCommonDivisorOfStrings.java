public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        // If one string is not the prefix of the other, there is no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Find the greatest common divisor of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Return the substring of str1 from 0 to gcdLength
        return str1.substring(0, gcdLength);
    }

    // Helper method to find the greatest common divisor of two integers
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "ABC"

        str1 = "ABABAB";
        str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "AB"

        str1 = "LEET";
        str2 = "CODE";
        System.out.println(gcdOfStrings(str1, str2)); // Output: ""
    }
}


//For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t 
//(i.e., t is concatenated with itself one or more times).

//Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.