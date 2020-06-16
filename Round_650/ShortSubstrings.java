import java.util.Scanner;

public class ShortSubstrings {
    public static void main(String[] args) {
        ShortSubstrings shortSubstrings = new ShortSubstrings();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(shortSubstrings.guess(in.next()));
        }
    }

    private String guess(String b) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < b.length(); i += 2) {
            if (i == 0)
                a.append(b.charAt(i));
            a.append(b.charAt(i + 1));
        }
        return a.toString();
    }
}
