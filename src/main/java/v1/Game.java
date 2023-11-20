package v1;

import java.util.Random;

public class Game {
    int round,win,lose;
    static User player = new User();
    static User dealer = new User();
    Random random = new Random();
    public Game(int round){
        this.round = round;
    }
    public void run(){
        System.out.println("Game " + round);
        draw();
        System.out.println("You   : ["+player.getCardNumber()+"]");
        System.out.println("Dealer: ["+dealer.getCardNumber()+"]");
        judge();
    }

    private void draw(){
        player.setCardNumber(1+random.nextInt(10));
        dealer.setCardNumber(1+random.nextInt(10));
    }

    private void judge(){
        if (player.getCardNumber()>dealer.getCardNumber()){
            System.out.println("당신이 이겼습니다.");
        }
        else if (player.getCardNumber()<dealer.getCardNumber()){
            System.out.println("딜러가 이겼습니다.");
        }
        else{
            System.out.println("비겼습니다.");
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

