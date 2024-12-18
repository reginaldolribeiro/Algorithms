package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortGpt {

//    public static void main(String[] args) {
////        int[] numbers = {7, 5, 10, 6, 8};
//        int[] numbers = {12, 3, 15, 2, 5, 6, 9, 8};
//        System.out.println("Initial List: " + getList(numbers));
//
//        bubbleSort(numbers);
//
//        // Imprimir os números ordenados
//        System.out.print("Números ordenados: ");
//
//        List<Integer> list = new ArrayList<Integer>();
//
//        for (int number : numbers) {
//            System.out.print(number + " ");
//            list.add(number);
//        }
//
//        System.out.println("\nFINAL List: " + list);
//    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 10, 6, 8};
//        int[] arr = {12, 3, 15, 2, 5, 6, 9, 8};

        System.out.println("\nArray original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort(arr);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int iterations = 0;

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
//                System.out.println("\n");
                System.out.println("Processed List " + j + " time(s): " + getList(arr));
            }

            System.out.println("\n-----------------\n");

            iterations++;
            // Se não houve troca nesta passagem, a lista já está ordenada
            if (!swapped) break;
        }
        System.out.println("\n iterations: " + iterations);

    }

    private static List<Integer> getList(int[] array) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int number : array) {
            numbers.add(number);
        }
        return numbers;
    }
}

