import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SameParitySummands {
    public static void main(String[] args) {
        SameParitySummands sameParitySummands = new SameParitySummands();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            List<Integer> result = sameParitySummands.summands(in.nextInt(), in.nextInt());
            System.out.println(result.isEmpty() ? "NO" : "YES");
            result.forEach(number -> System.out.print(number + " "));
            if(!result.isEmpty()) System.out.println();
        }
    }

    public List<Integer> summands(int number, int n) {
        List<Integer> result = new ArrayList<>();
        int requiredNumberForAllOdd = number - (n - 1);
        if((requiredNumberForAllOdd & 1) == 1 && requiredNumberForAllOdd > 0) {
            for(int i = 0; i < n - 1; i++) result.add(1);
            result.add(requiredNumberForAllOdd);
            return result;
        }

        int requiredNumberForAllEven = number - 2 * (n - 1);
        if((requiredNumberForAllEven & 1) == 0 && requiredNumberForAllEven > 0) {
            for(int i = 0; i < n - 1; i++) result.add(2);
            result.add(requiredNumberForAllEven);
            return result;
        }
        return result;
    }
}
