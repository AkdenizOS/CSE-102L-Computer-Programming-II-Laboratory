public class PortSimulation {
    public static void main(String[] args) {
        
        System.out.println("=== SCENARIO 1: Best Fit Logic & Mixed Types (Tests T18, T27) ===");
        // We have three ships. 
        // Ship 1: Type 1, Capacity 50.0 (Free: 50.0)
        // Ship 2: Type 2, Capacity 100.0 (Free: 100.0)
        // Ship 3: Type 1, Capacity 120.0 (Free: 120.0)
        Ship[] port1 = new Ship[3];
        port1[0] = new Ship(1, 1, 50);  
        port1[1] = new Ship(2, 2, 100); 
        port1[2] = new Ship(3, 1, 120); 

        // Container (60.0, Type 1). 
        // Ship 1 is type 1 but too small (50.0 < 60.0).
        // Ship 2 is big enough but wrong type (Type 2 != Type 1).
        // Ship 3 is type 1 and has enough space (120.0 >= 60.0).
        // Expected Output: Container 60.0 -> Ship 3
        Container c1 = new Container(60, 1);
        c1.assignToShip(port1);

        System.out.println("\n=== SCENARIO 2: Type Mismatch (Test T19) ===");
        // Ship is Type 2, Container is Type 1.
        Ship[] port2 = new Ship[]{new Ship(4, 2, 100)};
        // Expected Output: Container 40.0 -> Failed
        Container c2 = new Container(40, 1);
        c2.assignToShip(port2);

        System.out.println("\n=== SCENARIO 3: Capacity Limit & Exact Capacity (Tests T20, T21) ===");
        Ship[] port3 = new Ship[2];
        port3[0] = new Ship(5, 1, 50);
        port3[0].addLoad(20); // Ship 5 now has 30.0 free space
        port3[1] = new Ship(6, 1, 50); // Ship 6 has 50.0 free space

        // Container (40.0, Type 1). 
        // Ship 5 fails (30.0 < 40.0). Ship 6 succeeds (50.0 > 40.0).
        // Expected Output: Container 40.0 -> Ship 6
        Container c3 = new Container(40, 1);
        c3.assignToShip(port3);

        // Container (50.0, Type 1).
        // Ship 6 only has 10.0 left. Ship 5 only has 30.0 left. 
        // Both fail.
        // Expected Output: Container 50.0 -> Failed
        Container c4 = new Container(50, 1);
        c4.assignToShip(port3);

        // Container (30.0, Type 1).
        // Ship 5 has EXACTLY 30.0 left. Fits perfectly.
        // Expected Output: Container 30.0 -> Ship 5
        Container c5 = new Container(30, 1);
        c5.assignToShip(port3);

        System.out.println("\n=== SCENARIO 4: Null Ships & Empty Arrays (Tests T22, T23, T24) ===");
        // Array with only null values
        Ship[] port4 = new Ship[3]; 
        // Expected Output: Container 10.0 -> Failed
        Container c6 = new Container(10, 1);
        c6.assignToShip(port4);

        // Adding one valid ship to the array surrounded by nulls
        port4[1] = new Ship(7, 1, 100); 
        // Expected Output: Container 30.0 -> Ship 7
        Container c7 = new Container(30, 1);
        c7.assignToShip(port4);

        // Completely empty array (length 0)
        Ship[] emptyPort = new Ship[0];
        // Expected Output: Container 10.0 -> Failed
        Container c8 = new Container(10, 1);
        c8.assignToShip(emptyPort);

        System.out.println("\n=== SCENARIO 5: Multiple Assignments Correct Load & Exceeding (Tests T25, T26) ===");
        // Ship with 80.0 capacity
        Ship[] port5 = new Ship[]{new Ship(8, 1, 80)};
        
        // First container takes 50.0 space. (30.0 left)
        // Expected Output: Container 50.0 -> Ship 8
        Container c9 = new Container(50, 1);
        c9.assignToShip(port5);

        // Second container needs 40.0 space. Fails because only 30.0 is left.
        // Expected Output: Container 40.0 -> Failed
        Container c10 = new Container(40, 1);
        c10.assignToShip(port5);

        System.out.println("\n--- Final Status of All Used Ships ---");
        printPortStatus(port1);
        printPortStatus(port2);
        printPortStatus(port3);
        printPortStatus(port4);
        printPortStatus(port5);
    }

    // Helper method to print ship statuses cleanly without null pointer exceptions
    private static void printPortStatus(Ship[] port) {
        for(int i = 0; i < port.length; i++) {
            if(port[i] != null) {
                System.out.println(port[i].toString());
            }
        }
    }
}