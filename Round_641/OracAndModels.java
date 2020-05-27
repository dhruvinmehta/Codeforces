import java.util.Arrays;
import java.util.Scanner;

public class OracAndModels {
    public static void main(String[] args) {
        OracAndModels oracAndModels = new OracAndModels();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] models = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                models[j] = in.nextInt();
            }
            System.out.println(oracAndModels.findMaxBeautiful(models, n));
        }
    }

    private int findMaxBeautiful(int[] models, int n) {
        int result = 0;
        int[] count = new int[n + 1];
        Arrays.fill(count, 1);

        for (int i = 1; i <= n / 2; i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (models[i] < models[j]) {
                    count[j] = Math.max(count[j], count[i] + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, count[i]);
        }

        return result;
    }
}
