package v2;

import java.util.Scanner;

public class GameManager {
    Game game;
    User player;
    Betting betting;
    public GameManager(Game game){
        this.game = game;
        this.player = game.player;
    }

    public void managing() {
        gameStart();
        String result = game.gameRun();
        gameEnd(result);
        reGame();
    }

    private void gameStart() {
        betting = new Betting(player);
        betting.bet();
        System.out.println("\nGame " + game.round);
    }

    private void gameEnd(String result) {
        int win = player.getWin();
        int lose = player.getLose();
        int tie = player.getTie();

        if (tie == 0) System.out.println("현재 전적: " + win + "승 " + lose + "패");
        else System.out.println("현재 전적: " + win + "승 " + tie + "무 " + lose + "패");
        betting.settle(result);
    }

    private void reGame() {
        Exception e = new Exception("잘못입력");
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            if (input.equals("Y")) {
                game.round += 1;
                managing();
            }
            else if (input.equals("N"));
            else{
                throw e;
            }
        } catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            reGame();
        }
    }


}
