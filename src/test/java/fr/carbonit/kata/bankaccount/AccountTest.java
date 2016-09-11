package fr.carbonit.kata.bankaccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void whenAccountIsCreatedWithoutInitialAmountThenTheBalanceIsZero() {
        // when
        Account myAccount = new Account();

        // then
        assertEquals(myAccount.getBalance(), Amount.ZERO);
    }

    @Test
    public void whenAccountIsCreatedWithAnInitialAmountThenTheBalanceIsEqualToThisAmount() {
        // given
        Amount initialAmount = new Amount(1000D);

        // when
        Account myAccount = new Account(initialAmount);

        // then
        assertEquals(myAccount.getBalance(), initialAmount);
    }

    @Test
    public void whenMakeADepositThenTheAmountIsAddedToTheAccount() {
        // given
        Amount initialAmount = new Amount(1000D);
        Amount amountToDeposit = new Amount(400D);
        Amount expectedAmount = new Amount(1400D);
        Account myAccount = new Account(initialAmount);

        // when
        myAccount.deposit(amountToDeposit);

        // then
        assertEquals(myAccount.getBalance(), expectedAmount);
    }

    @Test
    public void whenMakeAWithdrawalThenTheAmountIsSubstractedFromTheAccount() {
        // given
        Amount initialAmount = new Amount(1000D);
        Amount amountToWithdraw = new Amount(400D);
        Amount expectedAmount = new Amount(600D);
        Account myAccount = new Account(initialAmount);

        // when
        myAccount.withdraw(amountToWithdraw);

        // then
        assertEquals(myAccount.getBalance(), expectedAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMakeAWithdrawalBiggerThanMySavingThenThrowIllegalArgumentException() {
        // given
        Amount initialAmount = new Amount(1000D);
        Amount amountToWithdraw = new Amount(1400D);
        Account myAccount = new Account(initialAmount);

        // when
        myAccount.withdraw(amountToWithdraw);
    }
}