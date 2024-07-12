class Solution {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        } 
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sum = 0, maxScore = 0;

        for(int i = 0; i < n; i++) {
            int currentNum2 = pairs[i][0];
            int currentNum1 = pairs[i][1];

            sum += currentNum1;
            minHeap.add(currentNum1);

            if(minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if(minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * currentNum2);
            }
        }
        return maxScore;
    }   
    public static void main(String [] args) {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));
    } 
}


//You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

//For chosen indices i0, i1, ..., ik - 1, your score is defined as:

//The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
//It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
//Return the maximum possible score.