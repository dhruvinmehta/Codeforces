import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumRoundNumbers {
    public static void main(String[] args) {
        SumRoundNumbers sumRoundNumbers = new SumRoundNumbers();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            List<Integer> result = sumRoundNumbers.summands(in.nextInt());
            System.out.println(result.size());
            result.forEach(number -> System.out.print(number + " "));
            System.out.println();
        }
    }

    public List<Integer> summands(int number) {
        List<Integer> result = new ArrayList<>();
        int length = (int) (Math.log10(number) + 1);
        for(int i = 0; i < length; i++) {
            int summand = number % (int) Math.pow(10, i + 1);
            if(summand != 0)
                result.add(0, summand);
            number -= summand;
        }
        return result;
    }
}