package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
//        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);
        System.out.println("\nInitial List: " + integers + "\n");

//        myBubbleSort(integers);
        mySecondBubbleSort(integers);
//        bubbleSortElemar(integers);

        System.out.println("FINAL List: " + integers);


    }

    private static void bubbleSortElemar(List<Integer> integers) {
        int iterations = 0;

        for(int i = integers.size()-1; i > 0; i--){

            int changes = 0;

            for(int j=0; j<i; j++){
                if(integers.get(j) > integers.get(j+1)){
                    int first = integers.get(j);
                    int second = integers.get(j+1);
                    integers.set(j,second);
                    integers.set(j+1,first);
                    changes++;
                }
                System.out.println("Processed List " + j + " time(s): " + integers);
            }

            System.out.println("\n-----------------");

            iterations++;

            if(changes <= 1) break;
        }

        System.out.println("\n iterations: " + iterations);
    }

    private static List<Integer> myBubbleSort(List<Integer> integers) {
        boolean swapped = true;
        int n = integers.size()-1;
        int iterations = 0;

        while(swapped){
            swapped = false;

            for(int i=0; i < n; i++){
                if(integers.get(i) > integers.get(i+1)){
                    int temp = integers.get(i);
                    integers.set(i, integers.get(i+1));
                    integers.set(i+1,temp);
                    swapped = true;
                }
                System.out.println("Processed List " + i + " time(s): " + integers);
            }

            System.out.println("\n-----------------\n");

            iterations++;
//            if(!swapped) break;
            n--;
        }

        System.out.println("\n iterations: " + iterations);
        return integers;
    }

    private static List<Integer> mySecondBubbleSort(List<Integer> numbers){
        int n = numbers.size() - 1;
        boolean swipped;
        int iterations = 0;

        do {
            swipped = false;
            for(int i = 0; i < n; i++){
                if (numbers.get(i) > numbers.get(i+1)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i+1));
                    numbers.set(i+1, temp);
                    swipped = true;
                }
                System.out.println("Processed List " + i + " time(s): " + numbers);
            }

            System.out.println("\n-----------------\n");

            iterations++;
            n--; // After each loop, the biggest element is inputed in the right position
        } while (swipped);

        System.out.println("\n iterations: " + iterations);
        return numbers;
    }

    public static void bubbleSortGpt(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Últimos i elementos já estão no lugar
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca arr[j] e arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se não houve troca nesta passagem, a lista já está ordenada
            if (!swapped) break;
        }
    }

//    private static List<Integer> bubbleSortTest(List<Integer> integers) {
//        boolean swapped = true;
//        int n = integers.size()-1;
//
//        while(swapped){
//            System.out.println("Passing here...");
////            for(int i=0; i<integers.size()-1; i++){
//            for(int i=0; i < n; i++){
//                swapped = false;
//                if(integers.get(i) > integers.get(i+1)){
//                    swapped = true;
//                    int first = integers.get(i);
//                    int second = integers.get(i+1);
//                    integers.set(i,second);
//                    integers.set(i+1,first);
//                }
//                System.out.println("Processed List " + i + " time(s): " + integers);
//            }
//            n--;
//        }
//
//        return integers;
//    }

    public void stuffs(){
        //        List<Integer> arr = new ArrayList<Integer>();
//        arr.add(7);
//        arr.add(5);
//        System.out.println(arr);
    }

}
