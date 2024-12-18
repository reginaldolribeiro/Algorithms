package exercises.hackerrank;

public class Staircase {

    public static void main(String[] args) {
        int n = 3;
        staircase(n);
        staircaseOptimized(n);
    }

    /**
     * Both versions here have a time complexity of O(n^2),
     * because they involve nested loops where each loop runs up to n times (n is the height of the staircase).
     *
     * Using StringBuilder would be more efficient for appending characters in a loop. ( better than .concat() )
     *
     * @param n
     */
    private static void staircase(int n) {
        String space = " ";
        String symbol = "#";
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) { // O(n)
            int quantityOfSpaces = n - i;
            for (int j = 1; j <= n; j++) { // O(n)
                if(j <= quantityOfSpaces){
                    result.append(space);
                } else {
                    result.append(symbol);
                }
            }
            System.out.println(result);
            result.setLength(0);
        }
    }


    /**
     * Big O(n^2) - quadratic
     *
     * Both versions here have a time complexity of  O(n^2),
     * because they involve nested loops where each loop runs up to n times (n is the height of the staircase).
     *
     * Using concat() can be inefficient because strings are immutable. Each concatenation creates a new string object.
     * Using StringBuilder would be more efficient for appending characters in a loop.
     *
     * @param n
     **/
    private static void staircase1(int n) {
        String space = " ";
        String symbol = "#";
        String result = "";

        for (int i = 1; i <= n; i++) { // O(n)
            int quantityOfSpaces = n - i;
            for (int j = 1; j <= n; j++) { // O(n)
                if(j <= quantityOfSpaces){
                    result = result.concat(space);
                } else {
                    result = result.concat(symbol);
                }
            }
            System.out.println(result);
            result = "";
        }
    }

    /**
     * Big O Notation
     *  time O(n^2)
     *  space O(n)
     *
     *  lines - i = quantity of spaces
     *  i = quantity of hashes
     *
     * @param lines
     */
    private static void staircaseOptimized(int lines) {
        for(int i=1; i <= lines; i++){
            String spaces = " ".repeat(lines - i);
            String hashes = "#".repeat(i);
            System.out.println(spaces + hashes);
        }
    }

}
