package fr.carbonit.kata.bankaccount.operations;

import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;
import org.junit.Test;

import static org.junit.Assert.*;

public class WithdrawalTest {

    @Test
    public void whenCalculateBalanceAfterThenBalanceIsLessThanBefore() {
        // given
        Withdrawal withdrawal = new Withdrawal(new Amount(40D));
        Account account = new Account(new Amount(500D));
        Amount expected = new Amount(460D);

        // when
        Amount balanceAfter = withdrawal.performOn(account);

        // then
        assertEquals(balanceAfter, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalculateBalanceOnNullAccountThenThrowIllegalArgumentException() {
        // given
        Withdrawal withdrawal = new Withdrawal(new Amount(30D));

        // when
        withdrawal.performOn(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalculatedBalanceIsNegativeThenThrowIllegalArgumentException() {
        // given
        Withdrawal withdrawal = new Withdrawal(new Amount(100D));
        Account account = new Account(new Amount(50D));

        // when
        withdrawal.performOn(account);
    }
}