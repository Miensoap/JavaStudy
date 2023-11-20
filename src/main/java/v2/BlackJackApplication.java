package v2;

public class BlackJackApplication {
    public static void main(String[] args) {
        User player = new User();

        System.out.println("간단 카드 게임을 시작합니다.");
        Game game = new Game(player);
        game.run();
        System.out.println("플레이 해 주셔서 감사합니다.");
    }
}
