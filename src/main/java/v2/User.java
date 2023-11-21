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

    public void Win() {
        this.win +=1;
    }

    public int getLose() {
        return lose;
    }

    public void Lose() {
        this.lose +=1;
    }

    public int getTie() {
        return tie;
    }

    public void Tie() {
        this.tie +=1;
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

    public void initCardNumbers(){this.cardNumbers = new ArrayList<>();}
}
