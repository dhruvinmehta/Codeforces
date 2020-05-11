import java.util.Scanner;

public class AliceBobAndCandies {
    public static void main(String[] args) {
        AliceBobAndCandies aliceBobAndCandies = new AliceBobAndCandies();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] candies = new int[n];
            for(int j = 0; j < n; j++) {
                candies[j] = in.nextInt();
            }
            System.out.println(aliceBobAndCandies.totalSize(candies, n));
        }
    }

    private String totalSize(int[] candies, int n) {
        Player alice = new Player(0, 0);
        Player bob = new Player(n - 1, 0);
        int move = 0;

        while(alice.position <= bob.position) {
            if((move & 1) == 0) {
                alice.candySize = 0;
                while(alice.position <= bob.position && alice.candySize <= bob.candySize) {
                    alice.total += candies[alice.position];
                    alice.candySize += candies[alice.position];
                    alice.position++;
                }
            } else {
                bob.candySize = 0;
                while(alice.position <= bob.position && bob.candySize <= alice.candySize) {
                    bob.total += candies[bob.position];
                    bob.candySize += candies[bob.position];
                    bob.position--;
                }
            }
            move++;
        }
        return move + " " + alice.total + " " + bob.total;
    }

    private static class Player {
        int position;
        int candySize;
        int total;

        Player(int position, int candySize) {
            this.position = position;
            this.candySize = candySize;
            total = 0;
        }
    }
}
