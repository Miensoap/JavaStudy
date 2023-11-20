package v2;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    int round=1;
    int win,lose,tie=0;
    User player;
    User dealer = new User();
    Deck deck = new Deck();
    Betting betting;
    Random random = new Random();

    public Game(User player){
        this.player = player;
    }

    public void run(){
        betting = new Betting(player);
        betting.bet();
        System.out.println("\nGame " + round);
        setCard(player);
        setCard(dealer);
        String result = judge();
        if(tie==0) System.out.println("현재 전적: "+win+"승 "+lose+"패");
        else System.out.println("현재 전적: "+win+"승 "+tie+"무 "+lose+"패");
        betting.settle(result);
        reGame();
        exit();
    }

    private void draw(User user){
        while (true) {
            int cardNumber = 1 + random.nextInt(11);
            if (deck.getNumOfCards(cardNumber) > 0) {
                deck.setNumOfCards(cardNumber, deck.getNumOfCards(cardNumber) - 1);
                user.setCardNumber(cardNumber);
                break;
            }
        }
    }

    private void setCard(User user) {
        draw(user);
        ask();
    }

    private boolean ask(){
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
            ask();
        }
        return false;
    }

    private void gameResult(){
        List<Integer> yourCards = player.getCardNumbers();
        System.out.print("플레이어: ");
        while (!yourCards.isEmpty()) {
            int cardNumber = yourCards.remove(0);
            System.out.print("[" + cardNumber + "]");
        }
        System.out.println();
        List<Integer> dealersCards = dealer.getCardNumbers();
        System.out.print("딜러: ");
        while (!dealersCards.isEmpty()) {
            int cardNumber = dealersCards.remove(0);
            System.out.print("[" + cardNumber + "]");
        }
    }

    private String judge(){
        gameResult();
        if (player.getCardNumber()>dealer.getCardNumber()){
            this.win+=1;
            return "win";
        }
        else if (player.getCardNumber()<dealer.getCardNumber()){
            this.lose+=1;
            return "lose";
        }
        else{
            this.tie+=1;
            return "tie";
        }
    }

    private void reGame(){
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try{
            if (input .equals("Y")){
                this.round+=1;
                run();
            }
            else if (input.equals("N"));
            else {
                Exception e = new Exception("잘못입력");
                throw e;
            }
        }catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            reGame();
        }
    }

    private void exit(){
        System.out.println(win+"승 "+tie+"무 "+lose+"패로 "+ player.getMoney()+"원의 자산이 남았습니다.");
    }


}

