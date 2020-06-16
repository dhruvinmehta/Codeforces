import java.util.Scanner;

public class EvenArray {
    public static void main(String[] args) {
        EvenArray evenArray = new EvenArray();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            System.out.println(evenArray.minimumMoves(array));
        }
    }

    private int minimumMoves(int[] array) {
        int zeros = 0, ones = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i & 1) != (array[i] & 1)) {
                if ((i & 1) == 0)
                    zeros++;
                else
                    ones++;
            }
        }
        if (ones != zeros)
            return -1;
        else
            return ones;
    }
}
