import java.util.*;

public class AllVowelsPlease {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		getAllVowels(k);
		in.close();
	}

	public static void getAllVowels(int k) {
		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
		int n = 0;
		int m = 0;
		int z = 0;
		if (k < 25) {
			System.out.println("-1");
			return;
		}

		for (int i = 5; i <= Math.sqrt(k); i++) {
			int ans = k / i;
			int rem = k % i;
			if (rem == 0 && ans >= 5) {
				n = ans;
				m = i;
				break;
			}
		}

		if (n >= 5 && m >= 5) {
			StringBuilder[] result = new StringBuilder[n];

			for (int i = 0; i < n; i++) {
				result[i] = new StringBuilder();
				if (i == 0)
					result[i].append("aeiou");
				else if (i == 1)
					result[i].append("eioua");
				else if (i == 2)
					result[i].append("iouae");
				else if (i == 3)
					result[i].append("ouaei");
				else if (i == 4)
					result[i].append("uaeio");
				else
					result[i].append("aeiou");
			}

			for (int i = 0; i < n; i++) {
				for (int j = 5; j < m; j++) {
					result[i].append(vowel[z]);
				}
				z = (z + 1) % 5;
				System.out.print(result[i]);
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
}