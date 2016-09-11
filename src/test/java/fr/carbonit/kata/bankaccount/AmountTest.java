package fr.carbonit.kata.bankaccount;

import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {

    @Test
    public void whenAmountIsCreatedWithSpecificValueThenAmountValueIsThisSpecificValue() {
        // given
        Double inputValue = 100D;

        // when
        Amount myAmount = new Amount(inputValue);

        // then
        assertEquals(myAmount.getValue(), inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAmountValueIsNullThenThrowIllegalArgumentException() {
        new Amount(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAmountValueIsNegativeThenThrowIllegalArgumentException() {
        new Amount(-500D);
    }

    @Test
    public void whenTwoAmountHaveSameValueThenTwoAmountAreEquals() {
        // given
        Amount firstAmount = new Amount(500D);
        Amount secondAmount = new Amount(500D);

        // then
        assertEquals(firstAmount, secondAmount);
    }

    @Test
    public void whenAmountAddedThenAmountValueIsGreaterThanInitial() {
        // given
        Amount currentAmount = new Amount(4000D);
        Amount amountToAdd = new Amount(600D);
        Amount expectedAmount = new Amount(4600D);

        // when
        Amount afterAdd = currentAmount.add(amountToAdd);

        // then
        assertEquals(afterAdd, expectedAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenValueToAddIsNullThenThrowIllegalArgumentException() {
        Amount amount = new Amount(300D);
        amount.add(null);
    }

    @Test
    public void whenAmountSubstractedThenAmountValueIsLessThanInitial() {
        // given
        Amount currentAmount = new Amount(4000D);
        Amount amountToSubstract = new Amount(600D);
        Amount expectedAmount = new Amount(3400D);

        // when
        Amount afterSubstract = currentAmount.subtract(amountToSubstract);

        // then
        assertEquals(afterSubstract, expectedAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenValueToSubstractIsNullThenThrowIllegalArgumentException() {
        Amount amount = new Amount(400D);
        amount.subtract(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAmountIsNegativeAfterSubstractionThenThrowIllegalArgumentException() {
        Amount amount = new Amount(50D);
        amount.subtract(new Amount(300D));
    }
}