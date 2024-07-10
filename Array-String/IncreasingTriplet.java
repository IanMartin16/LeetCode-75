public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;  // num is smaller than or equal to the smallest seen so far
            } else if (num <= second) {
                second = num;  // num is larger than first but smaller than or equal to second
            } else {
                return true;  // num is larger than both first and second, we found our triplet
            }
        }

        return false;  // No triplet found
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {2, 1, 5, 0, 4, 6};

        System.out.println(increasingTriplet(nums1)); // Output: true
        System.out.println(increasingTriplet(nums2)); // Output: false
        System.out.println(increasingTriplet(nums3)); // Output: true
    }
}


//Given an integer array nums, return true if there exists a triple of 
//indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.