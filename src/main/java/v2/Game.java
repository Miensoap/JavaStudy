package v2;

import v2.enums.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    User player;
    User dealer = new User();
    Deck deck = new Deck();

    public Game(User player) {
        this.player = player;
    }

    public Result gameRun(){
        deck.setDeck();
        player.initCards();
        dealer.initCards();
        if(!setCardPlayer(player)) return Result.lose;
        if(!setCardDealer(dealer)) return Result.win;
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
                if(judgeBust(user)) {
                    announce(dealer, "딜러");
                    return false;
                }
            } else break;
        }
        return true;
    }

    private void draw(User user) {
        user.addCard(deck.getCard());
    }

    private void announce(User user, String userName) {
        // userName user 멤버로 편입
        List<Integer> Cards = new ArrayList<>(user.getCards());
        System.out.print(userName + ": ");
        while (!Cards.isEmpty()) {
            int cardNumber = Cards.remove(0);
            System.out.print("[" + cardNumber + "]");
        }
        System.out.println();
        System.out.println("총합 : "+user.getSumOfCardNumber());
    }

    private boolean askToPlayer() {
        Exception e = new Exception("잘못입력");
        CheatException ec = new CheatException();

        System.out.print("카드를 더 받겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            if (input.equals("Y")) {
                return true;
            }
            else if(input.equals("codesquad")) {
                cheat();
                throw ec;
            }
            else if (input.equals("N")) return false;
            else {
                throw e;
            }
        } catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            askToPlayer();
        }catch (CheatException e2){
            askToPlayer();
        }
        return false;
    }

    private void cheat() {
        System.out.print("덱의 카드 : ");
        List<Integer> cards = deck.showCards(6);
        while (!cards.isEmpty()){
            System.out.print("["+cards.remove(0)+"]");
        }
        System.out.println();
    }

    private boolean askToBot(User bot){
        return bot.getSumOfCardNumber() < 17;
    }

    private Boolean judgeBust(User user){
        return user.getSumOfCardNumber()>21;
    }

    private void announceResult() {
        announce(dealer, "딜러");
        System.out.println("딜러의 카드 합계는 "+ dealer.getSumOfCardNumber()+"입니다.");
    }

    private Result judge() {
        announceResult();
        if (player.getSumOfCardNumber() > dealer.getSumOfCardNumber()) {
            if(player.getSumOfCardNumber()==21) return Result.blackjack;
            return Result.win;
        } else if (player.getSumOfCardNumber() < dealer.getSumOfCardNumber()) {
            return Result.lose;
        } else {
            return Result.tie;
        }
    }
}

