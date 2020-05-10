import java.util.*;

public class AverageSuperheroGangPower {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();

		int[] avengers = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			avengers[i] = in.nextInt();
		}

		AverageSuperheroGangPower obj = new AverageSuperheroGangPower();
		System.out.println(obj.findAveragePower(n, k, m, avengers));
		in.close();
	}

	public double findAveragePower(long n, long k, long m, int[] avengers) {
		long sum = 0;
		for (int avenger : avengers) {
			sum += avenger;
		}
		Arrays.sort(avengers);
		double maxPower = (double) (sum + Math.min(m, n * k)) / (double) n;

		for (int i = 1; i <= Math.min(m, n - 1); i++) {
			sum -= avengers[i];
			double powerAfterRemoval = (double) (sum + Math.min(m - i, (n - i) * k)) / (double) (n - i);
			maxPower = Math.max(maxPower, powerAfterRemoval);
		}
		return maxPower;
	}
}