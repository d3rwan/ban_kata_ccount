package fr.carbonit.kata.bankaccount;

/**
 * Amount
 */
public class Amount {

    /**
     * Empty amount
     */
    private static Double EMPTY = 0D;

    /**
     * Initial balance with default value
     */
    public static Amount ZERO = new Amount();

    /**
     * amount value
     */
    private Double value;

    /**
     * Default constructor
     */
    private Amount() {
        value = EMPTY;
    }

    /**
     * Constructor
     *
     * @param value value of the amount
     */
    public Amount(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Amount can't be null");
        }
        if (value < EMPTY) {
            throw new IllegalArgumentException("Amount can't be negative");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value != null ? value.equals(amount.value) : amount.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    /**
     * Add to the amount
     *
     * @param amountToAdd amount to add
     * @return new amount value
     */
    public Amount add(Amount amountToAdd) {
        if (amountToAdd == null) {
            throw new IllegalArgumentException("Null can't be add to the amount");
        }
        return new Amount(value + amountToAdd.value);
    }

    /**
     * Substract to the amount
     *
     * @param amountToSubtract
     * @return new amount value
     */
    public Amount subtract(Amount amountToSubtract) {
        if (amountToSubtract == null) {
            throw new IllegalArgumentException("Null can't be substract to the amount");
        }
        return new Amount(value - amountToSubtract.value);
    }

    /**
     * Get the amount value
     *
     * @return the balance value
     */
    public Double getValue() {
        return value;
    }
}
