import java.util.Scanner;

public class OracAndMedians {
    public static void main(String[] args) {
        OracAndMedians oracAndMedians = new OracAndMedians();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            System.out.println(oracAndMedians.canConvert(a, n, k));
        }
    }

    private String canConvert(int[] a, int n, int k) {
        boolean isKPresent = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                isKPresent = true;
                break;
            }
        }

        if (!isKPresent)
            return "no";
        if (n == 1)
            return "yes";

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n && j - i <= 2; j++)
                if (a[i] >= k && a[j] >= k)
                    return "yes";

        return "no";
    }
}
