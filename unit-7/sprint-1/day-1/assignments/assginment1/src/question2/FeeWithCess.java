package question2;

public class FeeWithCess extends FeeExpenses{

    private double cess;
    public FeeWithCess(double tuitionFee, double serviceTax,double cess) {
        super(tuitionFee, serviceTax);
        this.cess = (tuitionFee*cess)/100;
    }

    @Override
    public double getTotalFee() {
        double previous_total = super.getTotalFee();
        return previous_total + cess;

    }
}
