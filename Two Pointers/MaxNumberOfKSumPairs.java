import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;

            if (countMap.getOrDefault(complement, 0) > 0) {
                // We have found a pair
                operations++;
                // Decrement the frequency of the complement
                countMap.put(complement, countMap.get(complement) - 1);
            } else {
                // Otherwise, increment the frequency of the current number
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println(maxOperations(nums1, k1)); // Output: 2

        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(maxOperations(nums2, k2)); // Output: 1
    }
}


//You are given an integer array nums and an integer k.

//In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

//Return the maximum number of operations you can perform on the array.