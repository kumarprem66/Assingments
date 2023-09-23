import question1.FixedDepositAccount;
import question1.LoanAgainstFixedDepositAccount;
import question2.FeeExpenses;
import question2.FeeWithCess;
import question3.BasicPlan;
import question3.BasicPlanWithGoldAddOn;
import question3.BasicPlanWithGoldDiamondAddOn;
import question4.EPFOAccount;
import question4.Employee;

public class Main {
    public static void main(String[] args) {

        FixedDepositAccount fd = new FixedDepositAccount(10000,10);
        System.out.println(fd.calculateMaturityValue());

        LoanAgainstFixedDepositAccount loanAgainstFixedDepositAccount = new LoanAgainstFixedDepositAccount(10000,10,5000,15);
        System.out.println(loanAgainstFixedDepositAccount.calculateTotalPayment());

        System.out.println("==========================================================");

        FeeExpenses feeExpenses = new FeeExpenses(1000,10);
        System.out.println(feeExpenses.getTotalFee());
        FeeWithCess fee = new FeeWithCess(1000,10,5);
        System.out.println(fee.getTotalFee());

        System.out.println("==========================================================");

        BasicPlan basicPlan = new BasicPlan(99,50);
        System.out.println(basicPlan.getTotalCharges());

        BasicPlanWithGoldAddOn basicPlanWithGoldAddOn = new BasicPlanWithGoldAddOn(99,80,50);
        System.out.println(basicPlanWithGoldAddOn.getTotalCharges());

        BasicPlanWithGoldDiamondAddOn basicPlanWithGoldDiamondAddOn = new BasicPlanWithGoldDiamondAddOn(99,130,50,40);
        System.out.println(basicPlanWithGoldDiamondAddOn.getTotalCharges());

        System.out.println("==========================================================");


        EPFOAccount epfoAccount = new EPFOAccount("A1234",5000);
        Employee employee = new Employee(1,"prem",50000,epfoAccount);
        System.out.println(employee);


    }
}