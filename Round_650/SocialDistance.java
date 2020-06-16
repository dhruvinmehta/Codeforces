import java.util.Scanner;

public class SocialDistance {
    public static void main(String[] args) {
        SocialDistance socialDistance = new SocialDistance();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            String line = in.next();

            System.out.println(socialDistance.find("0" + line, n, k));
        }
    }

    private int find(String line, int n, int k) {
        int last = -k;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (line.charAt(i) == '1') {
                result += (i - last) / (k + 1) - 1;
                last = i;
            }
        }
        result += (n - last) / (k + 1);
        return result;
    }
}
