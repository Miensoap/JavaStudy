package v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    int round = 1;
    User player;
    User dealer = new User();
    Deck deck = new Deck();

    public Game(User player) {
        this.player = player;
    }

    public String gameRun(){
        deck.setDeck();
        if(!setCardPlayer(player)) return "lose";
        if(!setCardDealer(dealer)) return "win";
        return judge();

    }

    // setCard 하나로 합친다
    private boolean setCardPlayer(User user) {
        draw(user);
        announce(user, "플레이어");
        while (true) {
            if (askToPlayer()) {
                draw(user);
                announce(user, "플레이어");
                if(judgeBust(user)) return false;
            } else break;
        }
        return true;
    }

    private boolean setCardDealer(User user){
        draw(user);
        while (true) {
            if (askToBot(user)) {
                draw(user);
                if(judgeBust(user)) return false;
            } else break;
        }
        return true;
    }

    private void draw(User user) {
        user.setCardNumber(deck.getCard());
    }

    private void announce(User user, String userName) {
        // userName user 멤버로 편입
        List<Integer> Cards = new ArrayList<>(user.getCardNumbers());
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

    private Boolean judgeBust(User user){
        return user.getCardNumber()>21;
    }

    private void announceResult() {
        // 여러명되면 User list  반복
        announce(player, "플레이어");
        announce(dealer, "딜러");
    }

    private String judge() {
        announceResult();
        if (player.getCardNumber() > dealer.getCardNumber()) {
            return "win";
        } else if (player.getCardNumber() < dealer.getCardNumber()) {
            return "lose";
        } else {
            return "tie";
        }
    }
}

