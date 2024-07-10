import java.util.Arrays;

public class DetermineIfTwoCloseStrings {
    
    public static boolean closeStrings(String word1, String word2) {
        // Paso 1: Verificar si ambas cadenas tienen la misma longitud
        if (word1.length() != word2.length()) {
            return false;
        }

        // Paso 2: Verificar si ambas cadenas tienen el mismo conjunto de caracteres
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] charSet1 = new boolean[26];
        boolean[] charSet2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            charSet1[c - 'a'] = true;
        }
        
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            charSet2[c - 'a'] = true;
        }

        // Verificar si ambos conjuntos de caracteres son iguales
        for (int i = 0; i < 26; i++) {
            if (charSet1[i] != charSet2[i]) {
                return false;
            }
        }

        // Paso 3: Comparar las frecuencias de caracteres
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}


//Two strings are considered close if you can attain one from the other using the following operations:

//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb
//Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
//You can use the operations on either string as many times as necessary.

//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.