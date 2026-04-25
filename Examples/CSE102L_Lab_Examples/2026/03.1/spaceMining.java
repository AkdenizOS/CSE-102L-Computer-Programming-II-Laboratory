public class spaceMining {
    public static void main(String[] args) {

        // TEST 1:
        System.out.println("[Sector Alpha]");
        double[][] sector1 = {
            {15.0, 15.0, 3.0, 40.0},
            {80.0, 80.0, 10.0, 200.0},
            {8.0, 6.0, 1.0, 25.0}
        };
        PlasmaMiner miner1 = new PlasmaMiner(0.0, 0.0, 25.0, 12, 6, 2);
        int cleared1 = miner1.processMinerals(sector1);
        System.out.println("Rocks Completely Cleared: " + cleared1 + " / 3");
        System.out.println("Remaining Energy Level: " + miner1.getEnergyLevel() + "\n");

        // TEST 2:
        System.out.println("[Sector Beta]");
        double[][] sector2 = {
            {5.0, 5.0, 50.0, 500.0}
        };
        PlasmaMiner miner2 = new PlasmaMiner(0.0, 0.0, 25.0, 12, 6, 2);
        int cleared2 = miner2.processMinerals(sector2);
        System.out.println("Rocks Completely Cleared: " + cleared2 + " / 1");
        System.out.println("Remaining Energy Level: " + miner2.getEnergyLevel() + "\n");

        // TEST 3:
        System.out.println("[Sector Gamma]");
        double[][] sector3 = {
            {10.0, 0.0, 2.0, 15.0},
            {-10.0, 0.0, 2.0, 15.0},
            {0.0, 10.0, 2.0, 15.0},
            {0.0, -10.0, 2.0, 15.0}
        };
        PlasmaMiner miner3 = new PlasmaMiner(0.0, 0.0, 25.0, 12, 6, 2);
        int cleared3 = miner3.processMinerals(sector3);
        System.out.println("Rocks Completely Cleared: " + cleared3 + " / 4");
        System.out.println("Remaining Energy Level: " + miner3.getEnergyLevel());
    }
}
class MiningRig {
    private double x, y ,maxRadius ;
    private int baseExtraction ;

    public MiningRig(double x, double y, double maxRadius, int baseExtraction){
        this.x=x;
        this.y=y;
        this.maxRadius=maxRadius;
        this.baseExtraction=baseExtraction;
    }

    public double calculateDistance(double targetX, double targetY){
        return Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));  
    }

    public boolean canReach(double targetX, double targetY){
        if(calculateDistance(targetX, targetY) <= maxRadius){
            return true;
        }        return false;
    }

    public int getBaseExtraction(){
        return baseExtraction;
    }


}
class PlasmaMiner extends MiningRig{

    private int energyLevel ,overchargeMultiplier ,drillCycles ;

    public PlasmaMiner(double x, double y, double maxRadius, int baseExtraction, int energyLevel, int overchargeMultiplier){
        super(x, y, maxRadius, baseExtraction);
        this.energyLevel=energyLevel;
        this.overchargeMultiplier=overchargeMultiplier;
        this.drillCycles=0;
    }

    public int extract(double targetX, double targetY, int rockHardness){
        if(canReach(targetX, targetY)){
            if(energyLevel <= 0){
                return 0;
            }
        
        
        
        }
    


}