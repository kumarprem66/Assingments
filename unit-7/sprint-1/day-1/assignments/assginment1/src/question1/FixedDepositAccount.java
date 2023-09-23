package question1;

public class FixedDepositAccount {

    private double depositAccount;
    private double fdInterestRate;

    public FixedDepositAccount(double depositAccount, double fdInterestRate) {
        this.depositAccount = depositAccount;
        this.fdInterestRate = fdInterestRate;
    }

    public double calculateMaturityValue(){
        double am = depositAccount*(1+fdInterestRate/100);

        String formattedValue = String.format("%.2f", am);
        return Double.parseDouble(formattedValue);

    }

    public double getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(double depositAccount) {
        this.depositAccount = depositAccount;
    }

    public double getFdInterestRate() {
        return fdInterestRate;
    }

    public void setFdInterestRate(double fdInterestRate) {
        this.fdInterestRate = fdInterestRate;
    }
}
