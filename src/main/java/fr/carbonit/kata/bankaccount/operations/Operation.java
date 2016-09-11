package fr.carbonit.kata.bankaccount.operations;

import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;

import java.time.LocalDateTime;

/**
 * Operation
 */
public abstract class Operation {

    /**
     * Operation type
     */
    public enum Type {
        DEPOSIT,
        WITHDRAWAL
    }

    /**
     * type
     */
    protected Type type;

    /**
     * amount of the operation
     */
    protected Amount amount;

    /**
     * Constructor
     *
     * @param type   type of the operation
     * @param amount amount of the operation
     */
    protected Operation(Type type, Amount amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Perform operation on an account
     *
     * @param account account
     */
    public abstract Amount performOn(Account account);

    /**
     * Get the type of the operation
     *
     * @return the type of the operation
     */
    public Type getType() {
        return type;
    }

    /**
     * Get the amount of the operation
     *
     * @return the amount of the operation
     */
    public Amount getAmount() {
        return amount;
    }
}
