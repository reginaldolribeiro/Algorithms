package exercises.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        int line = 3;
        int row = 3;
//        List<List<Integer>> matrix = initializeMatrix(line, row);
        List<List<Integer>> matrix = initializeCustomMatrix();
        System.out.println("Matrix " + matrix);

        int sum = diagonalDifference(matrix);
        System.out.println("Total of diagonal difference is " + sum);
    }

    /**
     * Most efficiency. Just ONE Loop
     *
     * Time Complexity: O(n)
     *  This optimized approach has a time complexity of  O(n) , where  n  is the size of the matrix (number of rows or columns).
     *  It iterates through the matrix once to compute both diagonal sums.
     *
     * Space Complexity: O(1)
     *  The space complexity remains  O(1)  as it uses a constant amount of additional space regardless of the input size.
     *
     * @param arr
     * @return
     */
    private static int diagonalDifferenceOptimized(List<List<Integer>> arr){
        int matrixSize = arr.size();
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for(int i=0; i < arr.size(); i++){
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(matrixSize - 1 - i);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    /**
     * BAD efficiency. TWO Loops.
     *
     * Time Complexity:  O(n^2)
     *  Quadratic time complexity due to nested loops iterating over each element of the matrix.
     *
     * Space Complexity:  O(1)
     *  Constant space complexity as the additional space used does not scale with the size of the input matrix.
     *
     * @param arr
     * @return
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int matrixSize = arr.size();

        int totalPrimaryDiagonal = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if(i == j){
                    totalPrimaryDiagonal += arr.get(i).get(j);
                }
            }
        }

        int totalSecondaryDiagonal = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = matrixSize-1; j >= 0; j--) {
                if((matrixSize-1) - i == j){
                    totalSecondaryDiagonal += arr.get(i).get(j);
                }
            }
        }

        return Math.abs(totalPrimaryDiagonal - totalSecondaryDiagonal);
    }


    public static int diagonalDifference1(List<List<Integer>> arr) {
        return Math.abs(primaryDiagonal(arr) - secondaryDiagonal(arr));
    }

    private static int primaryDiagonal(List<List<Integer>> arr) {
        int matrixSize = arr.size();
        int total = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if(i == j){
                    total += arr.get(i).get(j);
                }
            }
        }
        return total;
    }

    private static int secondaryDiagonal(List<List<Integer>> arr) {
        int matrixSize = arr.size();
        int total = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = matrixSize-1; j >= 0; j--) {
                if((matrixSize-1) - i == j){
                    total += arr.get(i).get(j);
                }
            }
        }
        return total;
    }

    private static List<List<Integer>> initializeCustomMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );
        return matrix;
    }


    private static List<List<Integer>> initializeMatrix(int line, int row) {
        List<List<Integer>> matrix = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < line; i++) {
            List<Integer> rowArr = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                count++;
                rowArr.add(count);
            }
            matrix.add(rowArr);
        }
        return matrix;
    }


    private static int[][] initializeMatrixPrimitive(int line, int row) {
        int[][] matrix = new int[line][row];
        int count = 0;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = count+1;
                count++;
            }
        }
        return matrix;
    }


}
