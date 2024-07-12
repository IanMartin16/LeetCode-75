import java.util.Arrays;

public class SuccessfulPairs {
    
    public static int[] successfulPairs(int[] spells, int[] potions, int success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        
        // Sort the potions array
        Arrays.sort(potions);
        
        // For each spell, count the number of successful pairs
        for (int i = 0; i < n; i++) {
            int spellStrength = spells[i];
            pairs[i] = countSuccessfulPairs(spellStrength, potions, success);
        }
        
        return pairs;
    }

    // Helper method to count the number of successful pairs for a given spell strength
    private static int countSuccessfulPairs(int spellStrength, int[] potions, int success) {
        int left = 0;
        int right = potions.length - 1;
        
        // Binary search to find the first potion that forms a successful pair
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) spellStrength * potions[mid] >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // All potions from 'left' to the end of the array form successful pairs
        return potions.length - left;
    }

    public static void main(String[] args) {
        int[] spells = {10, 20, 30};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 50;
        
        int[] result = successfulPairs(spells, potions, success);
        
        // Output the result
        System.out.println(Arrays.toString(result)); // Expected output: [3, 4, 5]
    }
}


//You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

//You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

//Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.