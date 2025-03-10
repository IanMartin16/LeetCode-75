public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums2)); // Output: -1

        int[] nums3 = {2, 1, -1};
        System.out.println(pivotIndex(nums3)); // Output: 0
    }
}


//Given an array of integers nums, calculate the pivot index of this array.

//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of 
//all the numbers strictly to the index's right.

//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
//This also applies to the right edge of the array.

//Return the leftmost pivot index. If no such index exists, return -1.