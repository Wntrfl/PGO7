
    public class Main {
        public static void main(String[] args) {
            MembershipPlan[] plans = new MembershipPlan[] {
                    new GymMembershipPlan(111, "Anna Kowalska", 3, true, 5, true, 6),
                    new GymMembershipPlan(222, "Piotr Nowak", 6, false, 7, false, 3),
                    new PersonalTrainingPlan(3, 3, true, 555, "Hana", 4, true, 7),
                    new PersonalTrainingPlan(5, 2, false, 777, "Aice", 8, false, 9),
                    new OnlineCoachingPlan(6, true, true, 999, "Vera", 2, true, 12),
                    new OnlineCoachingPlan(4, false, false, 756, "Maria", 1, false, 3),
                    new CorporateWellnessPlan(77, 4, true, 123, "Alla", 25, true, 6),
                    new CorporateWellnessPlan(88, 6, false, 456, "Ivan", 14, false, 6)
            };

            double totalMonthlyNet = 0.0;
            double totalMonthlyGross = 0.0;
            double totalContractNet = 0.0;

            System.out.println("=== MEMBERSHIP PLANS ===");

            for (MembershipPlan plan : plans) {
                plan.printSummary();

                totalMonthlyNet += plan.calculateMonthlyNetPrice();
                totalMonthlyGross += plan.calculateMonthlyGrossPrice();
                totalContractNet += plan.calculateTotalNetPrice();

                if (plan instanceof RemoteAcces) {
                    RemoteAcces remoteAccess = (RemoteAcces) plan;
                    System.out.println("Online access: " + remoteAccess.hasOnlineAccess());
                }

                if (plan instanceof Freezable) {
                    Freezable freezable = (Freezable) plan;
                    System.out.println("Can freeze: " + freezable.canFreeze());
                }

                System.out.println(plan);
                System.out.println("-----");
            }

            System.out.println("Total monthly net: " + totalMonthlyNet);
            System.out.println("Total monthly gross: " + totalMonthlyGross);
            System.out.println("Total contract net: " + totalContractNet);

            Billable billable = new OnlineCoachingPlan(4, true, true, 111, "Hanna", 15, false, 6);
            System.out.println("Billable net: " + billable.calculateMonthlyNetPrice());
            System.out.println("Billable gross: " + billable.calculateMonthlyGrossPrice());
        }
    }