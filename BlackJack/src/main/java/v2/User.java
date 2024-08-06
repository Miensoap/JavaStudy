package v2;

import  v2.enums.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    int money;
    String userName;
    List<Integer> cards = new ArrayList<>();
    Map<Result,Integer> history = new HashMap<>();

    public User(String name){
        this.userName = name;
        money = 1000;
        history.put(Result.win, 0);
        history.put(Result.lose, 0);
        history.put(Result.tie, 0);
    }

    public String getUserName(){return userName;}

    public int getMoney() { return money; }
    public void setMoney(int money) {
        this.money = money;
    }


    public void initCards(){this.cards = new ArrayList<>();}

    public List<Integer> getCards() {
        return cards;
    }
    public void addCard(int cardNumber) {
        cards.add(cardNumber);
    }

    public int getSumOfCardNumber() {
        return cards.stream().mapToInt(Integer::intValue).sum();
    }

    public int getWin(){
        return history.get(Result.win);
    }
    public int getLose(){
        return history.get(Result.lose);
    }
    public int getTie(){
        return history.get(Result.tie);
    }
    public void addResultCount(Result result){
        history.replace(result, history.get(result)+1);
    }
}
