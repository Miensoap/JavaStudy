package v1;
import v1.Game;

public class BlackJackApplication {
    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");
        Game game = new Game();
        game.run();
        System.out.println("게임을 종료합니다.\n" + "플레이해주셔서 감사합니다.");
    }
}
