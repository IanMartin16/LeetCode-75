public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // Plant a flower here
                    n--; // Reduce the number of flowers we need to plant
                    if (n == 0) {
                        return true; // All required flowers have been planted
                    }
                }
            }
        }
        return n <= 0; // Check if we managed to plant all required flowers
    }

    public static void main(String[] args) {
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println(canPlaceFlowers(flowerbed1, n1)); // Output: true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println(canPlaceFlowers(flowerbed2, n2)); // Output: false

        int[] flowerbed3 = {0, 0, 1, 0, 0};
        int n3 = 1;
        System.out.println(canPlaceFlowers(flowerbed3, n3)); // Output: true
    }
}


//You have a long flowerbed in which some of the plots are planted, and some are not. However, 
//flowers cannot be planted in adjacent plots.

//Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
//return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.