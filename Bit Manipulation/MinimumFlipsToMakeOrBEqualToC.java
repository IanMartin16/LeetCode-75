public class MinimumFlipsToMakeOrBEqualToC {

    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 0) {
                flips += bitA + bitB;
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println(minFlips(a1, b1, c1)); // Expected output: 3

        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println(minFlips(a2, b2, c2)); // Expected output: 1

        int a3 = 1, b3 = 2, c3 = 3;
        System.out.println(minFlips(a3, b3, c3)); // Expected output: 0
    }
}


//Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). 
//(bitwise OR operation).
//Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.