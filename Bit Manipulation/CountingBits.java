public class CountingBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[] result1 = countBits(n1);
        System.out.println(java.util.Arrays.toString(result1)); // Expected output: [0, 1, 1, 2, 1, 2]
        
        int n2 = 10;
        int[] result2 = countBits(n2);
        System.out.println(java.util.Arrays.toString(result2)); // Expected output: [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]
    }
}


//Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.