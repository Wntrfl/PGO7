public class GymMembershipPlan extends MembershipPlan implements Freezable{
   private int entriesPerMonth;
   private boolean saunaAccess;

   public GymMembershipPlan (int planCode, String clientName, int entriesPerMonth, boolean saunaAccess,
                              double baseMonthlyFee, boolean autoRenew, int planDurationInMonths) {
       super(planCode, clientName, baseMonthlyFee, autoRenew);
       this.entriesPerMonth = entriesPerMonth;
       this.saunaAccess = saunaAccess;
   }

   @Override
    public String getPlanType(){
       return "Gym Membership Plan";
   }

   @Override
    public double calculateMonthlyNetPrice(){
       double netPrice = getBaseMonthlyFee()+(this.entriesPerMonth*4);
       if (saunaAccess){
           netPrice+=25;
       }
       if (getIfAutoRenew()){
           netPrice-=10;
       }
       return netPrice;
   }

   @Override
    public boolean canFreeze(){
       if (getPlanDurationInMonths()>= 3){
           return true;
       }
       return false;
   }

   @Override
    public String toString(){
       return String.format ("Plan code: %s |Client Name: %s |Monthly Fee:%s| Entries per Month:%s ",
               getPlanCode(), getClientName(), getBaseMonthlyFee(), this.entriesPerMonth);
   }






}
