public class towerDefense {
    public static void main(String[] args) {

        // TEST 1
        System.out.println("[Wave 1]");
        double[][] wave1 = {
            {10.5, 20.0, 2.0, 50.0},
            {50.0, 50.0, 5.0, 100.0},
            {5.0, 5.0, 0.0, 30.0}
        };
        SniperTower tower1 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated1 = tower1.engageEnemies(wave1);
        System.out.println("Enemies Defeated: " + defeated1 + " / 3");
        System.out.println("Remaining Ammo: " + tower1.getAmmo() + "\n");

        // TEST 2
        System.out.println("[Wave 2]");
        double[][] wave2 = {
            {10.0, 10.0, 50.0, 100.0}
        };
        SniperTower tower2 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated2 = tower2.engageEnemies(wave2);
        System.out.println("Enemies Defeated: " + defeated2 + " / 1");
        System.out.println("Remaining Ammo: " + tower2.getAmmo() + "\n");

        // TEST 3
        System.out.println("[Wave 3]");
        double[][] wave3 = {
            {0.0, 5.0, 1.0, 10.0},
            {0.0, -5.0, 1.0, 10.0},
            {5.0, 0.0, 1.0, 10.0},
            {-5.0, 0.0, 1.0, 10.0}
        };
        SniperTower tower3 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated3 = tower3.engageEnemies(wave3);
        System.out.println("Enemies Defeated: " + defeated3 + " / 4");
        System.out.println("Remaining Ammo: " + tower3.getAmmo());
    }
}