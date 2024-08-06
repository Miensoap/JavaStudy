package v2;

public class BlackJackApplication {
    static User player;
    static GameManager gameManager;
    public static void main(String[] args) {
        player = new User("플레이어");
        welcome();
        gameManager = new GameManager(player);
        gameManager.makeGame();
        gameManager.managing();
        exit();
    }

    private static void welcome() {
        System.out.println("간단 카드 게임을 시작합니다.");
        System.out.println("현재 재산 : "+player.getMoney());
    }

    private static void exit() {
        System.out.println("\n플레이 해 주셔서 감사합니다.");
        System.out.println(player.getWin() + "승 " + player.getTie() + "무 " + player.getLose() + "패로 " + player.getMoney() + "원의 자산이 남았습니다.");
    }

}
