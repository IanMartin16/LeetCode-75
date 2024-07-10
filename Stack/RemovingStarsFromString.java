import java.util.Stack;

public class RemovingStarsFromString {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Dado que estamos construyendo el resultado desde el final hacia el inicio, necesitamos invertirlo
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "leet**cod*e";
        System.out.println(removeStars(s1)); // Output: "lecoe"

        String s2 = "erase*****";
        System.out.println(removeStars(s2)); // Output: ""
    }
}


//You are given a string s, which contains stars *.

//In one operation, you can:

//Choose a star in s.
//Remove the closest non-star character to its left, as well as remove the star itself.
//Return the string after all stars have been removed.

//Note:

//The input will be generated such that the operation is always possible.
//It can be shown that the resulting string will always be unique.