public class GuessNumberHigherorLower {
    private int pick; // This is the number to be guessed, set it for testing purposes.

    // Constructor to set the number to be guessed
    public GuessGame(int pick) {
        this.pick = pick;
    }

    // Pre-defined API to simulate the guessing process
    public int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    // Method to find the number picked using binary search
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid; // Found the number
            } else if (result == -1) {
                right = mid - 1; // The number is lower, search in the left half
            } else {
                left = mid + 1; // The number is higher, search in the right half
            }
        }
        return -1; // If the number is not found
    }

    // Main method for testing
    public static void main(String[] args) {
        GuessGame game = new GuessGame(10); // Pick a number for testing
        int n = 20; // Define the range
        System.out.println("The number picked is: " + game.guessNumber(n));
    }
}


//We are playing the Guess Game. The game is as follows:

//I pick a number from 1 to n. You have to guess which number I picked.

//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

//You call a pre-defined API int guess(int num), which returns three possible results:

//-1: Your guess is higher than the number I picked (i.e. num > pick).
//1: Your guess is lower than the number I picked (i.e. num < pick).
//0: your guess is equal to the number I picked (i.e. num == pick).
//Return the number that I picked.