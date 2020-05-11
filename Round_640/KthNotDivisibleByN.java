import java.util.Scanner;

public class KthNotDivisibleByN {
    public static void main(String[] args) {
        KthNotDivisibleByN kthNotDivisibleByN = new KthNotDivisibleByN();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(kthNotDivisibleByN.find(n, k));
        }
    }

    public int find(int n, int k) {
        int gap = n - 1;
        int group = (int) Math.ceil((double) k / (double) gap);
        int indexInGroup = k - ((group - 1) * (n - 1));
        return n * (group - 1)  + indexInGroup;
    }
}
