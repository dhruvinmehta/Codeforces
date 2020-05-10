import java.util.Scanner;

public class Parity {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[k];

		for (int i = 0; i < k; i++) {
			a[i] = in.nextInt();
		}

		Parity parity = new Parity();
		System.out.println(parity.checkParity(b, k, a));
		in.close();
	}

	public String checkParity(int b, int k, int[] a) {
		int countOdd = 0;
		boolean isBaseOdd = false;
		if ((b & 1) == 1) {
			isBaseOdd = true;
		}

		for (int i = 0; i < k - 1; i++) {
			if ((a[i] & 1) == 1 && isBaseOdd) {
				countOdd++;
			}
		}

		if ((a[k - 1] & 1) == 1) {
			countOdd++;
		}

		if ((countOdd & 1) == 1) {
			return "odd";
		}
		return "even";
	}
}