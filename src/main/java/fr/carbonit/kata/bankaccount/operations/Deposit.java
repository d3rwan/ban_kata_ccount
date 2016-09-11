package fr.carbonit.kata.bankaccount.operations;

import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;

/**
 * Deposit operation
 */
public class Deposit extends Operation {

    /**
     * Constructor
     * @param amount
     */
    public Deposit(Amount amount) {
        super(Type.DEPOSIT, amount);
    }

    @Override
    public Amount performOn(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account can't be null");
        }
        return account.getBalance().add(this.amount);
    }
}
