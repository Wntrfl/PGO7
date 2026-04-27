public class PersonalTrainingPlan extends MembershipPlan {
    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public PersonalTrainingPlan(int sessionsPerMonth, int trainerLevel, boolean dietConsultationIncluded,
                                int planCode, String clientName, double baseMonthlyFee,
                                boolean autoRenew, int planDurationInMonths ) {
        super(planCode, clientName, baseMonthlyFee, autoRenew, planDurationInMonths);
        this.sessionsPerMonth=sessionsPerMonth;
        if (trainerLevel<1 || trainerLevel>3) {
            throw new IllegalArgumentException("Trainer level must be between 1 and 3");
        }
        this.trainerLevel=trainerLevel;
        this.dietConsultationIncluded=dietConsultationIncluded;
    }
    @Override
    public String getPlanType(){
        return "PersonalTrainingPlan";
    }

    @Override
    public double calculateMonthlyNetPrice(){
       double NetPrice= getBaseMonthlyFee()+ (this.sessionsPerMonth*70);
       if (this.trainerLevel==2){
           NetPrice+=90;
       }
       if(this.trainerLevel==3){
           NetPrice+=180;
       }
       if(this.dietConsultationIncluded){
           NetPrice+=50;
       }
       if (getIfAutoRenew()){
           NetPrice-=15;
       }
       return NetPrice;

    }

    @Override

    public String toString(){
        return String.format ("Plan code: %s |Client Name: %s |Monthly Fee:%s| Sessions per Month:%s ",
                getPlanCode(), getClientName(), getBaseMonthlyFee(), this.sessionsPerMonth);
    }




}
