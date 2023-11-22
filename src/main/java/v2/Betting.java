package v2;

import java.util.Scanner;

public class Betting {
    User player;
    int money;
    public Betting(User player){
        this.player = player;
    }
    public void bet(){
        Exception e = new Exception();
        System.out.print("얼마를 거시겠습니까? ");
        Scanner sc = new Scanner(System.in);

        try{
            int input = sc.nextInt();
            if (input > player.money || input%100 !=0){
                throw e;
            }
            money = input;
        }catch (Exception e1) {
            System.out.println("잘못 입력하셨습니다.");
            bet();
        }

    }

    public void settle(String result){
        int nowMoney = player.getMoney();
        if (result.equals("win")){
            player.setMoney(nowMoney+money);
            System.out.print("당신의 승리입니다.");
            player.Win();
        } else if (result.equals("lose")) {
            player.setMoney(nowMoney-money);
            System.out.print("당신의 패배입니다.");
            player.Lose();
        } else if(result.equals("blackjack")){
            player.setMoney(nowMoney+money*2);
            player.Win();
        }
        else{
            System.out.print("무승부입니다.");
            player.Tie();
        }
        System.out.println("현재 재산: " +player.getMoney());
    }
}
