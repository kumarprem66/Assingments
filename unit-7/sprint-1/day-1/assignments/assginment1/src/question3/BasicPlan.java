package question3;

public class BasicPlan {

    private double subscriptionCharge;
    private int hoursWatched;

    public BasicPlan(double subscriptionCharge, int hoursWatched) {
        this.subscriptionCharge = subscriptionCharge;
        this.hoursWatched = hoursWatched;
    }

    public double getSubscriptionCharge() {
        return subscriptionCharge;
    }

    public void setSubscriptionCharge(double subscriptionCharge) {
        this.subscriptionCharge = subscriptionCharge;
    }

    public int getHoursWatched() {
        return hoursWatched;
    }

    public void setHoursWatched(int hoursWatched) {
        this.hoursWatched = hoursWatched;
    }

    public double getTotalCharges(){
        double extra_charges = 0;
        if(hoursWatched>45){
            int extra_hours = hoursWatched-45;
            extra_charges = extra_hours*1.5;

        }
        return subscriptionCharge+extra_charges;
    }
}
