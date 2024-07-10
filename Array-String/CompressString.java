public class CompressString {
    public static int compress(char[] chars) {
        int index = 0; // index to place the compressed character
        int i = 0; // index to iterate through chars

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the number of occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Place the current character in the compressed array
            chars[index++] = currentChar;

            // If the count is more than 1, place the count as well
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd'};

        System.out.println(compress(chars1)); // Output: 6, chars = ["a","2","b","2","c","3"]
        System.out.println(compress(chars2)); // Output: 1, chars = ["a"]
        System.out.println(compress(chars3)); // Output: 7, chars = ["a","b","2","c","4","d"]
    }
}


//Given an array of characters chars, compress it using the following algorithm:

//Begin with an empty string s. For each group of consecutive repeating characters in chars:

//If the group's length is 1, append the character to s.
//Otherwise, append the character followed by the group's length.
//The compressed string s should not be returned separately, but instead, be stored in the input character array chars. 
//Note that group lengths that are 10 or longer will be split into multiple characters in chars.

//After you are done modifying the input array, return the new length of the array.

//You must write an algorithm that uses only constant extra space.