package v2;

import v2.enums.Result;

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

    public void settle(Result result){
        int nowMoney = player.getMoney();
        if (result.equals(Result.win)){
            System.out.print("당신의 승리입니다.");
            player.setMoney(nowMoney+money);
            player.addResultCount(Result.win);
        } else if(result.equals(Result.blackjack)){
            System.out.print("당신의 승리입니다.");
            player.setMoney(nowMoney+money*2);
            player.addResultCount(Result.win);
        } else if (result.equals(Result.lose)) {
            player.setMoney(nowMoney-money);
            System.out.print("당신의 패배입니다.");
            player.addResultCount(Result.lose);}
        else{
            System.out.print("무승부입니다.");
            player.addResultCount(Result.tie);
        }
        System.out.println("현재 재산: " +player.getMoney());
    }
}
