package design_pattern.p5_tik_tak_toe;

public class TikTokToe {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("game winner is: " + game.startGame());

    }
}
