import java.util.Scanner;

/**
 * CS1 Lab B: The Silver Spiral
 * Fill a 2D matrix with Lucas numbers in a counter-clockwise spiral pattern.
 * 
 * @author [Student Name]
 * @version 1.0
 */
public class SilverSpiral {
    
    /**
     * Main method - PROVIDED TO STUDENTS (DO NOT MODIFY)
     */
    public static void main(String[] args) {
        System.out.println("=== Lab B: The Silver Spiral ===");
        System.out.println("Fill a matrix with Lucas numbers in counter-clockwise spiral.");
        
        int n = getMatrixSize();
        
        int[][] spiral = fillCounterClockwiseSpiral(n);
        
        int diagonalSum = calculateDiagonalSum(spiral);
        System.out.println("\nDiagonal Sum (Main + Anti): " + diagonalSum);
    }
    
    // =========================================================================
    // STUDENT IMPLEMENTATION SECTION - COMPLETE THE METHODS BELOW
    // =========================================================================
    

    public static int getMatrixSize() {

    }
    
    public static int getLucas(int n) {

    }

    public static int[][] fillCounterClockwiseSpiral(int n) {

    }
    
    public static int calculateDiagonalSum(int[][] matrix) {

    }
}