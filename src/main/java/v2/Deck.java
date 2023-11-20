package v2;

class Deck {
    int[] numOfCards = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 12};

    public void setNumOfCards(int cardNumber, int numOfCards) {
        this.numOfCards[cardNumber - 1] = numOfCards;
    }

    public int getNumOfCards(int cardNumber) {
        return this.numOfCards[cardNumber - 1];
    }
}
