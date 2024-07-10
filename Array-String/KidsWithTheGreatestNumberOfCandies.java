import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class KidsWithTheGreatestNumberOfCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result); // Output: [true, true, true, false, true]

        candies = new int[]{4, 2, 1, 1, 2};
        extraCandies = 1;
        result = kidsWithCandies(candies, extraCandies);
        System.out.println(result); // Output: [true, false, false, false, false]

        candies = new int[]{12, 1, 12};
        extraCandies = 10;
        result = kidsWithCandies(candies, extraCandies);
        System.out.println(result); // Output: [true, false, true]
    }
}


//There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, 
//and an integer extraCandies, denoting the number of extra candies that you have.

//Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, 
//they will have the greatest number of candies among all the kids, or false otherwise.

//Note that multiple kids can have the greatest number of candies.