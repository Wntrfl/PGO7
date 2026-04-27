public class OnlineCoachingPlan extends MembershipPlan implements RemoteAcces {
    private int VideoConsultation;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan (int VideoConsultation, boolean mealPlanIncluded, boolean recordedLibraryAccess, int planCode,
                               String clientName, double baseMonthlyFee, boolean autoRenew, int planDurationInMonths) {
        super(planCode, clientName, baseMonthlyFee, autoRenew, planDurationInMonths);
        this.VideoConsultation = VideoConsultation;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;

    }
    @Override
    public String getPlanType(){
        return "Gym Membership Plan";
    }

    @Override
    public double calculateMonthlyNetPrice(){
        double netPrice= getBaseMonthlyFee()+ this.VideoConsultation*45;
        if(this.mealPlanIncluded){
            netPrice+=60;

        }
        if(recordedLibraryAccess){
            netPrice+=20;
        }
        if (getIfAutoRenew()){
            netPrice-=12;
        }
        return netPrice;

    }

    @Override
    public boolean hasOnlineAccess(){
        return true;
    }

    @Override
    public String toString(){
        return String.format ("Plan code: %s |Client Name: %s |Monthly Fee:%s| Videos:%s ",
                getPlanCode(), getClientName(), getBaseMonthlyFee(), this.VideoConsultation);
    }




}
