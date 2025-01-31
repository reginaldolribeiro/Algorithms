package exercises.leetcode;

/**
 * A class that solves the "Number of Islands" problem using Depth-First Search (DFS).
 *
 * Problem Description:
 * Given a 2D grid of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are surrounded by water.
 *
 * Example:
 * Input:
 *  [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 *  ]
 * Output: 1
 *
 * Big O Notation:
 * - Time Complexity: O(rows * columns) — Every cell is visited once.
 * - Space Complexity: O(rows * columns) — Due to recursive DFS calls in the worst case.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        // Example test case
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        // Compute and print the number of islands
        int result = numberOfIslands(grid);
        System.out.println("Number of Islands: " + result);
    }

    /**
     * Counts the number of islands in the given grid.
     *
     * Algorithm:
     * 1. Iterate through each cell in the grid.
     * 2. When a '1' is found, increment the island count and perform DFS to mark
     *    all connected '1's as visited by changing them to '0'.
     * 3. Continue the iteration until all cells are processed.
     *
     * Edge Cases:
     * - Null or empty grid: Returns 0.
     * - Grid with no '1's: Returns 0.
     *
     * Big O Notation:
     * - Time Complexity: O(rows * columns) — Every cell is visited once.
     * - Space Complexity: O(rows * columns) — Due to the recursive stack for DFS.
     *
     * @param grid The 2D grid of '1's (land) and '0's (water).
     * @return The total number of islands.
     */
    private static int numberOfIslands(char[][] grid) {
        // Handle edge case: Null or empty grid
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int totalIslands = 0; // To count the number of islands
        int rows = grid.length;
        int columns = grid[0].length;

        // Iterate through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // When a '1' is found, it indicates a new island
                if (grid[row][column] == '1') {
                    totalIslands++; // Increment the island count
                    dfs(grid, row, column); // Mark all connected land as visited
                }
            }
        }
        return totalIslands;
    }

    /**
     * Performs Depth-First Search (DFS) to mark all connected '1's as visited.
     *
     * Algorithm:
     * 1. Base Case: Stop if the current cell is out of bounds or is '0' (water).
     * 2. Mark the current cell as visited by changing it to '0'.
     * 3. Recursively visit all four adjacent cells (up, down, left, right).
     *
     * @param grid   The 2D grid.
     * @param row    The current row index.
     * @param column The current column index.
     */
    private static void dfs(char[][] grid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Base Case: Stop if out of bounds or the current cell is water
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] == '0') {
            return;
        }

        // Mark the current cell as visited by setting it to '0'
        grid[row][column] = '0';

        // Visit all adjacent cells
        dfs(grid, row - 1, column); // Above
        dfs(grid, row + 1, column); // Below
        dfs(grid, row, column - 1); // Left
        dfs(grid, row, column + 1); // Right
    }
}