package easy;

/*
    Alice and Bob take turns playing a game, with Alice starting first.
    Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

    Choosing any x with 0 < x < N and N % x == 0.
    Replacing the number N on the chalkboard with N - x.
    Also, if a player cannot make a move, they lose the game.

    Return True if and only if Alice wins the game, assuming both players play optimally.
 */

public class DivisorGame {

    public static void main(String... args) {

        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(2));
        System.out.println(divisorGame.divisorGame(3));
    }

    public boolean divisorGame(int N) {
        return false;
    }

}
