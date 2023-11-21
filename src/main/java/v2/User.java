package v2;

import java.util.ArrayList;
import java.util.List;

class User {
    List<Integer> cardNumbers = new ArrayList<>();
    int money = 1000;
    int win, lose, tie = 0;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Integer> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumber(int cardNumber) {
        cardNumbers.add(cardNumber);
    }

    public int getCardNumber() {
        return cardNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
