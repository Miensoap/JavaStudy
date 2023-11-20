package v1;

import java.util.Random;
import java.util.Scanner;

public class Game {
    int round=1;
    int win,lose=0;
    static User player = new User();
    static User dealer = new User();
    Random random = new Random();
    public void run(){
        System.out.println("Game " + round);
        draw();
        System.out.println("You   : ["+player.getCardNumber()+"]");
        System.out.println("Dealer: ["+dealer.getCardNumber()+"]");
        judge();
        System.out.println("현재 전적: "+win+"승 "+lose+"패");
        reGame();
    }

    private void draw(){
        player.setCardNumber(1+random.nextInt(10));
        dealer.setCardNumber(1+random.nextInt(10));
    }

    private void judge(){
        if (player.getCardNumber()>dealer.getCardNumber()){
            this.win+=1;
            System.out.println("당신이 이겼습니다.");
        }
        else if (player.getCardNumber()<dealer.getCardNumber()){
            System.out.println("딜러가 이겼습니다.");
            this.lose+=1;
        }
        else{
            System.out.println("비겼습니다.");
        }
    }

    private void reGame(){
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try{
            if (input .equals("Y")) run();
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


}
class User{
    int cardNumber;
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

}

