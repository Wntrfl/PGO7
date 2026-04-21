public abstract class MembershipPlan {
    int planCode;
    String clientName;
    int months;
    double baseMonthlyFee;
    boolean autoRenew;

    public MembershipPlan(int planCode, String clientName, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
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

    public abstract String getPlanType();

    public abstract double calculateMonthlyNetPrice();

    public double calculateMonthlyGrossPrice(){
        return calculateMonthlyGrossPrice();
    };

    public double calculateTotalNetPrice(){
        return calculateTotalNetPrice();
    }

    public final void printSummary(){
        System.out.println("Plan Code: " + planCode);
        System.out.println("Client Name: " + clientName);
        System.out.println("Base Monthly Fee: " + baseMonthlyFee);
        System.out.println ("Monthly Gross price: " + calculateMonthlyGrossPrice());
        System.out.println ("Total Net price: " + calculateTotalNetPrice());

    }
}

