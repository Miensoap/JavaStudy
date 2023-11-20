package v2;

import java.util.ArrayList;
import java.util.List;

class User {
    List<Integer> cardNumbers = new ArrayList<>();
    int money = 1000;

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
