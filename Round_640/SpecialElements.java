import java.util.Scanner;

public class SpecialElements {
    public static void main(String[] args) {
        SpecialElements specialElements = new SpecialElements();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            System.out.println(specialElements.count(array, n));
        }
    }

    private int count(int[] array, int n) {
        int ans = 0;
        int[] count = new int[n + 1];
        for (int i : array) {
            count[i]++;
        }

        for (int l = 0; l < n; l++) {
            int sum = array[l];
            for (int r = l + 1; r < n; r++) {
                sum += array[r];
                if (sum <= n) {
                    ans += count[sum];
                    count[sum] = 0;
                }
            }
        }
        return ans;
    }
}
