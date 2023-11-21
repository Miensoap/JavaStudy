package v2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    int round = 1;
    User player;
    User dealer = new User();
    Deck deck = new Deck();
    Betting betting;
    Random random = new Random();

    public Game(User player) {
        this.player = player;
    }

    public void run() {
        gameStart();
        if(!setCardPlayer(player)) return;
        if(!setCardDealer(dealer)) return;
        reGame();
        gameEnd();
    }

    private void gameStart() {
        betting = new Betting(player);
        betting.bet();
        System.out.println("\nGame " + round);
    }

    private void gameEnd() {
        int win = player.getWin();
        int lose = player.getLose();
        int tie = player.getTie();

        String result = judge();
        if (tie == 0) System.out.println("현재 전적: " + win + "승 " + lose + "패");
        else System.out.println("현재 전적: " + win + "승 " + tie + "무 " + lose + "패");
        betting.settle(result);
    }


    private void draw(User user) {
        while (true) {
            int cardNumber = 1 + random.nextInt(11);
            if (deck.getNumOfCards(cardNumber) > 0) {
                deck.setNumOfCards(cardNumber, deck.getNumOfCards(cardNumber) - 1);
                user.setCardNumber(cardNumber);
                break;
            }
        }
    }

    // setCard 하나로 합친다
    private boolean setCardPlayer(User user) {
        draw(user);
        announce(user, "플레이어");
        while (true) {
            if (askToPlayer()) {
                draw(user);
                announce(user, "플레이어");
                if(judgeBust(user, "플레이어")) return false;
            } else break;
        }
        return true;
    }

    private boolean setCardDealer(User user){
        draw(user);
        while (true) {
            if (askToBot(user)) {
                draw(user);
                if(judgeBust(user, "딜러")) return false;
            } else break;
        }
        return true;
    }

    private void announce(User user, String userName) {
        // userName user 멤버로 편입
        List<Integer> Cards = user.getCardNumbers();
        System.out.print(userName + ": ");
        while (!Cards.isEmpty()) {
            int cardNumber = Cards.remove(0);
            System.out.print("[" + cardNumber + "]");
        }
        System.out.println();
    }

    private boolean askToPlayer() {
        System.out.print("카드를 더 받겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) return false;
            else {
                Exception e = new Exception("잘못입력");
                throw e;
            }
        } catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            askToPlayer();
        }
        return false;
    }

    private boolean askToBot(User bot){
        return bot.getCardNumber() < 17;
    }

    private boolean judgeBust(User user,String userName){
        if(user.getCardNumber()>21){
            if(userName.equals("player")) {
                user.lose += 1;
                betting.settle("lose");
            }
            else betting.settle("win");
            return true;
        }
        return false;
    }


    private String judge() {
        gameResult();
        if (player.getCardNumber() > dealer.getCardNumber()) {
            player.win += 1;
            return "win";
        } else if (player.getCardNumber() < dealer.getCardNumber()) {
            player.lose += 1;
            return "lose";
        } else {
            player.tie += 1;
            return "tie";
        }
    }

    private void gameResult() {
        // 여러명되면 User list  반복
        announce(player, "플레이어");
        announce(player, "딜러");
    }

    private boolean reGame() {
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            if (input.equals("Y")) {
                this.round += 1;
                run();
            } else if (input.equals("N")) return false;
            else {
                Exception e = new Exception("잘못입력");
                throw e;
            }
        } catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            reGame();
        }
        return false;
    }
}

