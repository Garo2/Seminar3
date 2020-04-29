package se.kth.iv1350.progExe.model;

public class RegisterIncomeHandler {
    private double incomeAmount;

    public RegisterIncomeHandler() {
        this.incomeAmount = 0;
    }

    public void updateRegisterAmount(double amountPaid) {
        this.incomeAmount +=amountPaid;
    }
}