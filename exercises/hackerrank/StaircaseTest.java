package exercises.hackerrank;

public class StaircaseTest {

    public static void main(String[] args) {
        int n = 3;
//        staircase(n);
        staircaseOptimized(n);
    }

    private static void staircaseOptimized(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("N must be greater than zero.");

        String space = " ";
        String symbol = "#";
        for (int i = 1; i <= n; i++) {
            String spaces = space.repeat(n - i);
            String symbols = symbol.repeat(i);
            System.out.println(spaces + symbols);
        }
    }

    private static void staircase(int n) {
        String space = " ";
        String symbol = "#";
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) { // O(n)
            int spaces = n - i;
            for (int j = 1; j <= n; j++) {
                if(j <= spaces){
                    result.append(space);
                }else{
                    result.append(symbol);
                }
            }
            System.out.println(result.toString());
            result.setLength(0);
        }
    }

}
