import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();  // The top asteroid on the stack explodes
                } else if (stack.peek() == -asteroid) {
                    stack.pop();  // Both asteroids explode
                    exploded = true;
                    break;
                } else {
                    exploded = true;  // The current asteroid explodes
                    break;
                }
            }
            
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids1 = {5, 10, -5};
        int[] result1 = asteroidCollision(asteroids1);
        System.out.println(java.util.Arrays.toString(result1));  // Output: [5, 10]

        int[] asteroids2 = {8, -8};
        int[] result2 = asteroidCollision(asteroids2);
        System.out.println(java.util.Arrays.toString(result2));  // Output: []

        int[] asteroids3 = {10, 2, -5};
        int[] result3 = asteroidCollision(asteroids3);
        System.out.println(java.util.Arrays.toString(result3));  // Output: [10]

        int[] asteroids4 = {-2, -1, 1, 2};
        int[] result4 = asteroidCollision(asteroids4);
        System.out.println(java.util.Arrays.toString(result4));  // Output: [-2, -1, 1, 2]
    }
}


//We are given an array asteroids of integers representing asteroids in a row.

//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, 
//negative meaning left). Each asteroid moves at the same speed.

//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
//If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.