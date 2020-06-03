import java.util.Scanner;

public class OracAndLCM {
    public static void main(String[] args) {
        OracAndLCM oracAndLCM = new OracAndLCM();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(oracAndLCM.calculate(array, n));
    }

    private long calculate(int[] array, int n) {
        long[] calculatedValues = new long[n];
        long result = 0;

        calculatedValues[n - 1] = array[n - 1];
        for(int i = n - 2; i > 0; i--) {
            calculatedValues[i] = gcd(array[i], calculatedValues[i + 1]);
        }

        for(int i = 0; i < n - 1; i++) {
            calculatedValues[i] = lcm(array[i], calculatedValues[i + 1]);
        }

        for(int i = 0; i < n - 1; i++) {
            result = gcd(result, calculatedValues[i]);
        }

        return result;
    }

    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
