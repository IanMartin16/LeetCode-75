public class LongestSubarrayAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            // Incrementa zeroCount si encontramos un 0 en la ventana actual
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Si zeroCount es mayor que 1, significa que hemos encontrado más de un 0 en la ventana
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculamos la longitud de la ventana actual
            maxLength = Math.max(maxLength, right - left);

            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1};
        System.out.println(longestSubarray(nums1)); // Output: 3

        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums2)); // Output: 5

        int[] nums3 = {1, 1, 1};
        System.out.println(longestSubarray(nums3)); // Output: 2

        int[] nums4 = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums4)); // Output: 4

        int[] nums5 = {0, 0, 0};
        System.out.println(longestSubarray(nums5)); // Output: 0
    }
}


//Given a binary array nums, you should delete one element from it.

//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.