package exercises.turing;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {1};
        int[] arr3 = {1,2};
        int[] arr4 = {1,2,3};
        int[] arr5 = {1,2,3,4};
        System.out.println("REsult 1: " + countingElements(arr1));
        System.out.println("REsult 2: " + countingElements(arr2));
        System.out.println("REsult 3: " + countingElements(arr3));
        System.out.println("REsult 4: " + countingElements(arr4));
        System.out.println("REsult 5: " + countingElements(arr5));
    }

    /**
     * Approach 2: Reducing Time Complexity
     * 	1. Iterate through the array, adding each element to a Set.
     * 	2. Iterate through the array again, adding +1 to each element and checking if the result exists in the Set:
     * 	    - If it exists, increment the counter.
     * 	    - If it does not exist, continue to the next element.
     * 	3. After completing the second loop, the counter will represent the number of elements in the array
     * 	    for which element + 1 also exists in the array.
     *
     * @param arr
     * @return
     */
    private static int countingElements(int[] arr){
        // Handle edge cases: null or empty array
        if(arr == null || arr.length == 0)
            return 0;

        // Add all elements to a HashSet for quick lookups
        Set<Integer> set = new HashSet<>();
        for(int value : arr)
            set.add(value);

        // Check if the sum (value + 1) exists in the set
        int counter = 0;
        for(int value : arr){
            int sum = value + 1;
            if(set.contains(sum))
                counter++;
        }
        return counter;
    }







    /**
     * Option 1:
     *  Brute force com 2 loops
     *  1. Inicia o primeiro loop pegando o element atual e o valor da soma dele +1
     *  2. Inicia o segundo loop procurando se existe um elemento com o valor da soma anterior
     *      - Se SIM, incrementa um contador
     *      - Se NAO, passa para o proximo
     *  3. Quando o segundo loop terminar, vamos voltar para o primeiro loop e repetir o passo 1 para o segundo element
     *      e assim por diante ate terminar a iteracao em todos os loops.
     *  4. Ao final teremos o valor acumulado no contador, que significa a quantidade de numeros que temos no array onde tambem temos o valor dele somado +1.
     *
     * Option 2:
     *
     * @param arr
     * @return
     */
    private static int countingElementsBruteForce(int[] arr){
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i] + 1;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == sum) {
                    counter++;
                    break; // Avoid passing here multiple times
                }
            }
        }
        return counter;
    }
}
