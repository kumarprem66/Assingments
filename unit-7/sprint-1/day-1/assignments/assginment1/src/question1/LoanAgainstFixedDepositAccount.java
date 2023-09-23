package question1;

public class LoanAgainstFixedDepositAccount extends FixedDepositAccount{

    private double loanAmount;
    private double loanInterestRate;


    public LoanAgainstFixedDepositAccount(double depositAccount, double fdInterestRate,double loanAmount,double loanInterestRate) {
        super(depositAccount, fdInterestRate);
        this.loanAmount = loanAmount;
        this.loanInterestRate = loanInterestRate;
    }

    public double calculateTotalPayment(){

        double total = loanAmount+(loanAmount*loanInterestRate)/100;
        String formattedValue = String.format("%.2f", total);
        return Double.parseDouble(formattedValue);
    }

}
