package edu.westga.chrisyaninvestmentcalculator.model;

/**
 * Created by Chris on 3/7/2016.
 */
public class InvestmentCalculator {
    private double payment;
    private double interest;
    private int periods;

    public InvestmentCalculator() {

    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest / 100;
    }

    public boolean isValidDouble(String input) {
        try{
            double parsedRate = Double.parseDouble(input);
            if(parsedRate < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isValidInt(String input) {
        try{
            int parsedInput = Integer.parseInt(input);
            if(parsedInput < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public double calculate() {
        double futureValue;
        if (this.interest == 0) {
            return this.payment * this.periods;
        } else {
            futureValue = ((Math.pow(1 + this.interest, this.periods) - 1) / this.interest) * this.payment;
        }
        return futureValue;
    }
}
