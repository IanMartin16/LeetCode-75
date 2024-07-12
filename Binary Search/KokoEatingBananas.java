public class KokoEatingBananas {
    
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    // Helper method to determine if Koko can finish all bananas at a given eating speed
    private static boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Equivalent to Math.ceil(pile / (double) k)
            if (hoursNeeded > h) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        
        int result = minEatingSpeed(piles, h);
        
        // Output the result
        System.out.println(result); // Expected output: 4
    }
}


//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
//The guards have gone and will come back in h hours.

//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
//If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

//Return the minimum integer k such that she can eat all the bananas within h hours.