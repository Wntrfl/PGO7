public class CorporateWellnessPlan extends MembershipPlan implements RemoteAcces, Freezable{
    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    public CorporateWellnessPlan(int employeeCount, int workshopsPerMonth, boolean onlineDashboard,
                                 int planCode, String clientName, double baseMonthlyFee, boolean autoRenew, int planDurationInMonths) {

        super(planCode, clientName, baseMonthlyFee, autoRenew, planDurationInMonths);
        this.employeeCount=employeeCount;
        this.workshopsPerMonth=workshopsPerMonth;
        this.onlineDashboard=onlineDashboard;


    }

    @Override
    public String getPlanType(){
        return "CorporateWellness";
    }

    @Override
    public double calculateMonthlyNetPrice(){
       double netPrice= getBaseMonthlyFee()+ this.employeeCount*18+ this.workshopsPerMonth*220;
       if(employeeCount>=20){
           netPrice-=netPrice*0.12;

       }
       if(onlineDashboard){
           netPrice+=80;
       }
       return netPrice;

    }

    @Override
    public boolean hasOnlineAccess(){
        return this.onlineDashboard;
    }

    @Override
    public boolean canFreeze(){
        if (getPlanDurationInMonths()>=6 && this.workshopsPerMonth==0) {
            return true;
        }
        return false;
    }





}
