import java.util.Scanner;

public class OracAndFactors {
    public static void main(String[] args) {
        OracAndFactors oracAndFactors = new OracAndFactors();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            System.out.println(oracAndFactors.findSumOfFactors(n, k));
        }
    }

    private int findSumOfFactors(int n, int k) {
        if ((n & 1) == 0) {
            return n + (2 * k);
        } else {
            return n + findSmallestDivisor(n) + (2 * (k - 1));
        }
    }

    private int findSmallestDivisor(int n) {
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }
}
