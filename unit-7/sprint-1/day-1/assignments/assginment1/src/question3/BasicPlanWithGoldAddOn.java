package question3;

public class BasicPlanWithGoldAddOn extends BasicPlan{

    private double goldAddOnCharges;

    public BasicPlanWithGoldAddOn(double subscriptionCharge, int hoursWatched,double goldAddOnCharges) {
        super(subscriptionCharge, hoursWatched);
        this.goldAddOnCharges = goldAddOnCharges;
    }

    public double getGoldAddOnCharges() {
        return goldAddOnCharges;
    }

    @Override
    public double getTotalCharges() {

        double extra_hours_charges = 0;
        double basic_charges_with_gold = super.getSubscriptionCharge()+this.goldAddOnCharges;
        int hours_watched = super.getHoursWatched();
        if(hours_watched>75){
            extra_hours_charges = (hours_watched-75)*1.2;
        }
        return basic_charges_with_gold+extra_hours_charges;


    }
}
