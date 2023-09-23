package question3;

public class BasicPlanWithGoldDiamondAddOn extends BasicPlanWithGoldAddOn{

    private double diamondAddOnCharges;


    public BasicPlanWithGoldDiamondAddOn(double subscriptionCharge, int hoursWatched, double goldAddOnCharges,double diamondAddOnCharges) {
        super(subscriptionCharge, hoursWatched, goldAddOnCharges);
        this.diamondAddOnCharges = diamondAddOnCharges;
    }

    @Override
    public double getTotalCharges() {

        double extra_hours_charges = 0;
        double basic_charges_with_gold_and_diamond = super.getSubscriptionCharge()+super.getGoldAddOnCharges()+this.diamondAddOnCharges;
        int hours_watched = super.getHoursWatched();
        if(hours_watched>120){
            extra_hours_charges = (hours_watched-120)*0.9;
        }
        return basic_charges_with_gold_and_diamond+extra_hours_charges;
    }
}
