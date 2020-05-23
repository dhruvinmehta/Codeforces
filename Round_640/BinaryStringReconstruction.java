import java.util.Scanner;

public class BinaryStringReconstruction {
    public static void main(String[] args) {
        BinaryStringReconstruction binaryStringReconstruction = new BinaryStringReconstruction();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n0 = in.nextInt();
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            System.out.println(binaryStringReconstruction.create(n0, n1, n2));
        }
    }

    private String create(int n0, int n1, int n2) {
        StringBuilder result = new StringBuilder();
        if (n1 == 0) {
            if (n0 != 0) {
                for (int i = 0; i <= n0; i++)
                    result.append("0");
            } else {
                for (int i = 0; i <= n2; i++)
                    result.append("1");
            }
        } else {
            boolean zero = true;
            for (int i = 0; i <= n1; i++) {
                result.append(zero ? "0" : "1");
                zero = !zero;
            }

            for (int i = 0; i < n0; i++)
                result.insert(0, "0");

            for (int i = 0; i < n2; i++)
                result.insert(result.lastIndexOf("1"), "1");
        }
        return result.toString();
    }
}
