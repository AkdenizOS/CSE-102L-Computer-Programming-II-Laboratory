public class Main {
    public static void main(String[] args) {
        
        LaserBeam[] lasers = {
            new LaserBeam(30.0, 100.0),
            new LaserBeam(45.0, 100.0),
            new LaserBeam(60.0, 100.0)
        };

        OpticalElement[][] facilityGrid = {
            { new FrostedGlass("Glass1"), new Prism("Prism1"), new Mirror("Mirror1"), new FrostedGlass("Glass2") },
            { new Prism("Prism2"), new Prism("Prism3"), new Mirror("Mirror2"), new Mirror("Mirror3") },
            { new FrostedGlass("Glass3"), new FrostedGlass("Glass4"), new FrostedGlass("Glass5"), new Mirror("Mirror4") }
        };

        OpticalFacility facility = new OpticalFacility(facilityGrid, lasers);

        System.out.println("--- SIMULATION STARTING ---\n");
        facility.fireBeams();

        System.out.println("--- STATISTICS ---");
        double totalAbsorbed = facility.calculateTotalAbsorbedEnergy();
        System.out.println("Total Energy Absorbed by the Entire Facility: " + totalAbsorbed);
        
        double validation = lasers[0].getEnergy() + lasers[1].getEnergy() + lasers[2].getEnergy() + totalAbsorbed;
        System.out.println("System Validation (Total Entering Energy 300.0 = Outputs + Absorbed): " + validation);
    }
}