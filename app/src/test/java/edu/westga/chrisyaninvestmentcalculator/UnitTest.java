package edu.westga.chrisyaninvestmentcalculator;

import android.widget.Button;

import org.junit.Test;

import dalvik.annotation.TestTargetClass;
import edu.westga.chrisyaninvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void interest_isDouble_isValid() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validInterest = newCalculator.isValidDouble("0.2");
        assertTrue(validInterest);
    }

    @Test
    public void interest_isDouble_notValid() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validInterest = newCalculator.isValidDouble("1.2");
        assertTrue(validInterest);
    }

    @Test
    public void payment_isValidDouble() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validInterest = newCalculator.isValidDouble("100");
        assertTrue(validInterest);
    }

    @Test
    public void interest_isNotValid() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validInterest = newCalculator.isValidDouble("false");
        assertFalse(validInterest);
    }

    @Test
    public void interest_isNotValid_negative() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validInterest = newCalculator.isValidDouble("-0.1");
        assertFalse(validInterest);
    }

    @Test
    public void period_isInteger_isValid() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validPeriod = newCalculator.isValidInt("1");
        assertTrue(validPeriod);
    }

    @Test
    public void period_isInteger_isNotValid_negative() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validPeriod = newCalculator.isValidInt("-1");
        assertFalse(validPeriod);
    }

    @Test
    public void period_isInteger_isNotValid() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        boolean validPeriod = newCalculator.isValidInt("false");
        assertFalse(validPeriod);
    }

    @Test
         public void calculate_interestRate_notZero() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        newCalculator.setInterest(10);
        newCalculator.setPayment(100);
        newCalculator.setPeriods(3);
        double futureValue = newCalculator.calculate();
        assertEquals(331.00, futureValue, 0.1);
    }

    @Test
            public void calculate_future_value() {
        InvestmentCalculator newCalculator = new InvestmentCalculator();
        newCalculator.setInterest(10);
        newCalculator.setPayment(100);
        newCalculator.setPeriods(3);
        double futureValue = newCalculator.calculate();
        assertEquals(331.00,futureValue, 0.1);
    }
}