import java.util.*;

public class AlexAndRhombus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		AlexAndRhombus rhombus = new AlexAndRhombus();
		System.out.println(rhombus.calculateSquares(n));
	}

	public int calculateSquares(int n) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 5;
		}

		return 4 * (n - 1) + calculateSquares(n - 1);
	}
}
