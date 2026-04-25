public class BackupSystem {
    public static void main(String[] args) {

        System.out.println("=== SCENARIO 1: Simple Save & Exact Fills (Tests T18, T19, T30) ===");
        HardDrive[] drives1 = { new HardDrive(1, 100, 100) };
        
        // File size 40. Fits easily in a 100 capacity drive.
        // Expected: Part 40.0 -> Drive 1 \n File Saved.
        DataFile file1 = new DataFile(40);
        file1.saveToDrives(drives1);

        // File size 60. Fits EXACTLY in the remaining 60 capacity of Drive 1.
        // Expected: Part 60.0 -> Drive 1 \n File Saved.
        DataFile file2 = new DataFile(60);
        file2.saveToDrives(drives1);

        // File size 0.0. Edge case, should save immediately.
        // Expected: File Saved.
        DataFile file3 = new DataFile(0);
        file3.saveToDrives(drives1);


        System.out.println("\n=== SCENARIO 2: Fragmentation Across Multiple Drives (Tests T21, T22, T29) ===");
        HardDrive[] drives2 = {
            new HardDrive(2, 50, 100),
            new HardDrive(3, 50, 100),
            new HardDrive(4, 100, 100) // This drive will be left untouched (Stop Iteration test)
        };
        
        // File size 80. Fills Drive 2 completely, puts remaining 30 in Drive 3.
        // Expected: Part 50.0 -> Drive 2 \n Part 30.0 -> Drive 3 \n File Saved.
        DataFile file4 = new DataFile(80);
        file4.saveToDrives(drives2);


        System.out.println("\n=== SCENARIO 3: Health Checks - Skips and Exact 70 (Tests T23, T24, T25) ===");
        HardDrive[] drives3 = {
            new HardDrive(5, 100, 69), // Health < 70 (Skip)
            new HardDrive(6, 100, 70)  // Health exactly 70 (Keep)
        };

        // File size 50. Should skip Drive 5 and successfully write to Drive 6.
        // Expected: Skip Drive 5 \n Part 50.0 -> Drive 6 \n File Saved.
        DataFile file5 = new DataFile(50);
        file5.saveToDrives(drives3);


        System.out.println("\n=== SCENARIO 4: Null Safety & Empty Arrays (Tests T26, T27, T28) ===");
        HardDrive[] drives4 = {
            null,
            new HardDrive(7, 50, 40), // Unhealthy (Skip)
            null,
            new HardDrive(8, 100, 100) // Healthy (Keep)
        };

        // File size 50. Skips nulls and unhealthy drive, writes to Drive 8.
        // Expected: Skip Drive 7 \n Part 50.0 -> Drive 8 \n File Saved.
        DataFile file6 = new DataFile(50);
        file6.saveToDrives(drives4);

        // Empty array test
        HardDrive[] emptyDrives = new HardDrive[0];
        // Expected: File Incomplete. Left: 10.0
        DataFile file7 = new DataFile(10);
        file7.saveToDrives(emptyDrives);


        System.out.println("\n=== SCENARIO 5: Not Enough Space / Incomplete (Tests T20, T34) ===");
        HardDrive[] drives5 = { new HardDrive(9, 40, 100) };
        
        // File size 50. Writes 40 to Drive 9, leaves 10 unsaved.
        // Expected: Part 40.0 -> Drive 9 \n File Incomplete. Left: 10.0
        DataFile file8 = new DataFile(50);
        file8.saveToDrives(drives5);

        System.out.println("\n--- Final Status of All Drives ---");
        printDriveStatus(drives1);
        printDriveStatus(drives2);
        printDriveStatus(drives3);
        printDriveStatus(drives4);
        printDriveStatus(drives5);
    }

    // Helper method to safely print drive statuses
    private static void printDriveStatus(HardDrive[] drives) {
        for(int i = 0; i < drives.length; i++) {
            if(drives[i] != null) System.out.println(drives[i].toString());
        }
    }
}