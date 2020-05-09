package se.kth.iv1350.seminar3processsale.model;
/**
 * Register the income to the system after each payment.
 */
public class RegisterIncomeHandler {
    private double incomeAmount;

    /**
     * Register the income to the system after each payment.
     */
    public RegisterIncomeHandler() {
    }

    /**
     * @param amountPaid updates and increase the amount of totalPrice to RegisterIncomeHandler
     */
    public void updateRegisterAmount(double amountPaid) {
        this.incomeAmount +=amountPaid;
    }
}
