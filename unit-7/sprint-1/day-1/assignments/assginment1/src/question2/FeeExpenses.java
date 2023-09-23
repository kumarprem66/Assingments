package question2;

public class FeeExpenses {

    private double tuitionFee;
    private double serviceTax;

    public FeeExpenses(double tuitionFee, double serviceTax) {
        this.tuitionFee = tuitionFee;
        this.serviceTax = serviceTax;
    }

    public double getTotalFee(){
        double totalFee = tuitionFee + (tuitionFee*serviceTax)/100;

        return Double.parseDouble(String.format("%.2f",totalFee));
    }

}
