public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int zerosCount = 0;

        while (right < nums.length) {
            // Expandir la ventana hacia la derecha
            if (nums[right] == 0) {
                zerosCount++;
            }

            // Si la ventana tiene más de k ceros, reducirla desde la izquierda
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            // Calcular la longitud máxima de la ventana
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(longestOnes(nums1, k1)); // Output: 6

        int[] nums2 = {0, 0, 1, 1, 1, 0, 0};
        int k2 = 0;
        System.out.println(longestOnes(nums2, k2)); // Output: 3

        int[] nums3 = {0, 0, 0, 0, 0};
        int k3 = 1;
        System.out.println(longestOnes(nums3, k3)); // Output: 1
    }
}


//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.