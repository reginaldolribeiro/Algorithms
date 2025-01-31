package exercises;

/**
 * A simple program to demonstrate working with 2D arrays in Java.
 * This program initializes a 2D array, assigns values to its elements,
 * and iterates through the array to print the rows and columns.
 */
public class Array2D {
    public static void main(String[] args) {
        // Initialize a 2D array with 3 rows and 2 columns
        int[][] arr2D = new int[3][2];
        int i, j = 0;

        // Assign values to the elements of the 2D array
        arr2D[0][0] = 1;
        arr2D[0][1] = 3;

        arr2D[1][0] = 2;
        arr2D[1][1] = 3;

        arr2D[2][0] = 3;
        arr2D[2][1] = 1;

        // Example: Uncomment this line to print a specific value
        // System.out.println(arr2D[0][0]); // Prints the value at row 0, column 0

        // Iterate over the rows of the 2D array
        for (int line = 0; line < arr2D.length; line++) {
            // Print the current row index
            System.out.println("Line: " + line);

            // Iterate over the columns of the current row
            for (int column = 0; column < arr2D[line].length; column++) {
                // Print the current column index
                System.out.println(" -> Column: " + column);
            }
        }
    }
}
