import java.util.*;

public class SashaAndMagneticMachines {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			sum += a[i];
		}
		Arrays.sort(a);
		SashaAndMagneticMachines machines = new SashaAndMagneticMachines();
		System.out.println(machines.minimumPower(a, sum));

		in.close();
	}

	public int minimumPower(int[] a, int sum) {
		Set<Integer> visited = new HashSet<>();
		int minimumPower = sum;
		for (int i = a.length - 1; i > 0; i--) {
			if (!visited.contains(a[i])) {
				visited.add(a[i]);
				for (int j = 2; j < a[i]; j++) {
					if (a[i] % j == 0) {
						for (int k = 0; k < i && a[k] < a[i]; k++) {
							minimumPower = Math.min(sum - a[i] - a[k] + (a[i] / j) + (a[k] * j), minimumPower);
						}
					}
				}
			}
		}
		return minimumPower;
	}
}