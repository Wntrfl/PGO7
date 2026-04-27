public abstract class MembershipPlan implements Billable{
   private int planCode;
   private String clientName;
   private double baseMonthlyFee;
   private boolean autoRenew;
   private int planDurationInMonths;

    public MembershipPlan(int planCode, String clientName, double baseMonthlyFee, boolean autoRenew, int planDurationInMonths) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
        this.planDurationInMonths = planDurationInMonths;
    }

    public int getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean getIfAutoRenew() {
        return autoRenew;
    }

    public int getPlanDurationInMonths() {
        return planDurationInMonths;
    }

    public abstract String getPlanType();
    @Override
    public abstract double calculateMonthlyNetPrice();
    @Override
    public double calculateMonthlyGrossPrice(){
        return baseMonthlyFee;
    };

    public double calculateTotalNetPrice(){
        return baseMonthlyFee*planDurationInMonths;
    }

    public final void printSummary(){
        System.out.println("Plan Code: " + planCode);
        System.out.println("Client Name: " + clientName);
        System.out.println("Base Monthly Fee: " + baseMonthlyFee);
        System.out.println ("Monthly Gross price: " + calculateMonthlyGrossPrice());
        System.out.println ("Total Net price: " + calculateTotalNetPrice());

    }

    @Override
    public String toString() {
        return String.format("Plan code: %s |Client Name: %s |Monthly Fee:%s ",
        planCode, clientName, baseMonthlyFee);
    }
}

