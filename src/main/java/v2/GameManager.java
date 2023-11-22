package v2;

import java.util.Scanner;

public class GameManager {
    int round = 0;
    User player;
    Game game;
    Betting betting;
    public GameManager(User player){
        this.player = player;
    }

    public void managing() {
        gameStart();
        String result = game.gameRun();
        gameEnd(result);
        reGame();
    }

    public void makeGame(){
        game = new Game(player);
    }

    private void gameStart() {
        betting = new Betting(player);
        betting.bet();
        round+=1;
        System.out.println("\nGame " + round);
    }

    private void gameEnd(String result) {
//        history(win, lose, tie);
        betting.settle(result);
    }

    private void history() {
        int win = player.getWin();
        int lose = player.getLose();
        int tie = player.getTie();
        if (tie == 0) System.out.println("현재 전적: " + win + "승 " + lose + "패");
        else System.out.println("현재 전적: " + win + "승 " + tie + "무 " + lose + "패");
    }


    private void reGame() {
        if(player.getMoney()==0) return;
        Exception e = new Exception("잘못입력");
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            if (input.equals("Y") || input.equals("y")) {
                managing();
            }
            else if (input.equals("N") || input.equals("n"));
            else{
                throw e;
            }
        } catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            reGame();
        }
    }
}
