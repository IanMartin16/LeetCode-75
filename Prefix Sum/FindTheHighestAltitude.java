public class FindTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain1)); // Output: 1

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain2)); // Output: 0

        int[] gain3 = {2, 3, -1, 2, -2, -2, 1};
        System.out.println(largestAltitude(gain3)); // Output: 6
    }
}


//There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. 
//The biker starts his trip on point 0 with altitude equal 0.

//You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
//Return the highest altitude of a point.