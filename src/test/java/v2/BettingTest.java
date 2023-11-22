package v2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class BettingTest {
    User player = new User();
    @Test
    void bet() {
    }

    @Test
    void settleWin() {
        // given
        Betting betting = new Betting(player);
        player.setMoney(1000);
        betting.money = 100;

        //when
        betting.settle("win");

        //then
        assertEquals(player.getMoney(), 1100);
    }

    @Test
    void settleLose() {
        // given
        Betting betting = new Betting(player);
        player.setMoney(1000);
        betting.money = 100;

        //when
        betting.settle("lose");

        //then
        assertEquals(player.getMoney(), 900);
    }

    @Test
    void settleBlackJack() {
        // given
        Betting betting = new Betting(player);
        player.setMoney(1000);
        betting.money = 100;

        //when
        betting.settle("blackjack");

        //then
        assertEquals(player.getMoney(), 1200);
    }

    @Test
    void settleTie() {
        // given
        Betting betting = new Betting(player);
        player.setMoney(1000);
        betting.money = 100;

        //when
        betting.settle("tie");

        //then
        assertEquals(player.getMoney(), 1000);
    }
}