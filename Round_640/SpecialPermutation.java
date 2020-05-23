import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SpecialPermutation {
    public static void main(String[] args) {
        SpecialPermutation specialPermutation = new SpecialPermutation();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> result = specialPermutation.find(in.nextInt());
            result.forEach(number -> System.out.print(number + " "));
            System.out.println();
        }
    }

    private List<Integer> find(int n) {
        if (n < 4) {
            return Collections.singletonList(-1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = n; i > 0; i--)
            if ((i & 1) == 1) result.add(i);

        result.add(4);
        result.add(2);

        for (int i = 6; i <= n; i += 2)
            result.add(i);

        return result;
    }
}
