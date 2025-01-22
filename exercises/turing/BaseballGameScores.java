package exercises.turing;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameScores {
    public static void main(String[] args) {
//        String[] ops = {"5","2","C","D","+"};
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+","+"};
//        String[] ops = {"-60","D","-36","30","13","C","C","-33","53","79"};
        System.out.println("Result " + calcPoints(ops));
    }


    /**
     * Option 3: BEST OPTION
     *  Use an index to track the last valid element and maintain a running total without an additional array.
     *  Big O Notation:
     *      - Time: O(n)
     *      - Space: O(1)
     *
     * Se nao sobrescrever os valores validos no ELSE o codigo vai acabar tentando somar int com letras (C ou D)
     * gerando erro.
     *
     * @param operations
     * @return
     */
    private static int calcPoints(String[] operations){
        int result = 0; // The total sum
        int index = 0; // Tracks the position for valid scores

        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")){
                int sum = Integer.parseInt(operations[index-1]) + Integer.parseInt(operations[index-2]);
                operations[index] = String.valueOf(sum);
                result += sum;
                index++;
            } else if(operations[i].equals("D")){
                int sum = 2 * Integer.parseInt(operations[index-1]);
                operations[index] = String.valueOf(sum);
                result += sum;
                index++;
            } else if(operations[i].equals("C")){
                index--;
                result -= Integer.parseInt(operations[index]);
            } else {
                operations[index] = operations[i]; // Store valid score
                result += Integer.parseInt(operations[i]);
                index++;
            }
        }
        return result;
    }

    /**
     * Option 2:
     *  Create another array to store valid integers, use an additional index to track valid entries, and maintain a running total during iteration.
     *  Big O Notation:
     *      - Time: O(n)
     *      - Space: O(n)
     *
     * @param operations
     * @return
     */
    private static int calcPoints3(String[] operations){
        int result = 0; // The total sum
        int index = 0; // Tracks the position for valid scores
        int[] scores = new int[operations.length]; // Fixed-size array for scores

        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")){
                scores[index] = scores[index-2] + scores[index-1];
                result += scores[index];
                index++;
            } else if(operations[i].equals("D")){
                scores[index] = 2 * scores[index-1];
                result += scores[index];
                index++;
            } else if(operations[i].equals("C")){
                index--;
                result -= scores[index];
                scores[index] = 0;
            } else {
                scores[index] = Integer.parseInt(operations[i]);
                result += scores[index];
                index++;
            }
        }
        return result;
    }


    private static int calcPoints5(String[] operations){
        int index = 0; // Tracks the position for valid scores
        int result = 0; // Total score
        int[] scores = new int[operations.length]; // Fixed-size array for scores

        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("C")){
                result = result - scores[i-1];
//                scores[i] = 0;
//                scores[i-1] = 0;
                index--;
            } else if(operations[i].equals("D")){
                scores[index] = 2 * scores[index-1];
                result += scores[index];
                index++;
            } else if(operations[i].equals("+")){
                scores[index] = scores[index-2] + scores[index-1];
                result += scores[index];
                index++;
            } else {
                scores[index] = Integer.parseInt(operations[i]);
                result += scores[index];
                index++;
            }
        }
        return result;
    }


    /**
     * Option 1:
     *  Create another array to store valid integers, perform deletions for “C” and calculate the total sum in a separate loop.
     *  Bad due to costly of deletions in an array.
     *  Big O Notation:
     *      - Time: O(n)
     *      - Space: O(n)
     *
     * @param operations
     * @return
     */
    private static int calcPoints111(String[] operations){
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")){
                int lastScore = scores.get(scores.size()-1);
                int secondLastScore = scores.get(scores.size()-2);
                scores.add(lastScore + secondLastScore);
            } else if(operations[i].equals("D")){
                int lastScore = scores.get(scores.size()-1);
                scores.add(2 * lastScore);
            } else if(operations[i].equals("C")){
                scores.remove(scores.size()-1);
            } else {
                scores.add(Integer.parseInt(operations[i]));
            }
        }
        int result = 0;
        for(Integer score : scores){
            result += score;
        }
        return result;
    }

    /**
     * Option 1:
     *  Create another array to store valid integers, perform deletions for “C” and calculate the total sum in a separate loop.
     *  Bad due to costly of deletions in an array.
     *  Big O Notation:
     *      - Time: O(n)
     *      - Space: O(n)
     *
     * @param operations
     * @return
     */
    private static int calcPoints2(String[] operations){
        List<Integer> scores = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")){
                int lastScore = scores.get(scores.size()-1);
                int secondLastScore = scores.get(scores.size()-2);
                scores.add(lastScore + secondLastScore);
                result += scores.get(scores.size()-1);
            } else if(operations[i].equals("D")){
                int lastScore = scores.get(scores.size()-1);
                scores.add(2 * lastScore);
                result += scores.get(scores.size()-1);
            } else if(operations[i].equals("C")){
                result -= scores.get(scores.size()-1);
                scores.remove(scores.size()-1);
            } else {
                scores.add(Integer.parseInt(operations[i]));
                result += scores.get(scores.size()-1);
            }
        }
        return result;
    }
}
