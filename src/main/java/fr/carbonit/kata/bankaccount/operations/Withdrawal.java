package fr.carbonit.kata.bankaccount.operations;

import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;
import fr.carbonit.kata.bankaccount.operations.Operation;

/**
 * Withdrawal operation
 */
public class Withdrawal extends Operation {

    /**
     * Constructor
     * @param amount
     */
    public Withdrawal(Amount amount) {
        super(Type.WITHDRAWAL, amount);
    }

    @Override
    public Amount performOn(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account can't be null");
        }
        return account.getBalance().subtract(this.amount);
    }
}
