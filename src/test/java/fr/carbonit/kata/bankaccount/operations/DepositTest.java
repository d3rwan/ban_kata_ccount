package fr.carbonit.kata.bankaccount.operations;

import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepositTest {

    @Test
    public void whenCalculateBalanceAfterThenBalanceIsGreaterThanBefore() {
        // given
        Deposit deposit = new Deposit(new Amount(40D));
        Account account = new Account(new Amount(500D));
        Amount expected = new Amount(540D);

        // when
        Amount balanceAfter = deposit.performOn(account);

        // then
        assertEquals(balanceAfter, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalculateBalanceOnNullAccountThenThrowIllegalArgumentException() {
        // given
        Deposit deposit = new Deposit(new Amount(30D));

        // when
        deposit.performOn(null);
    }
}