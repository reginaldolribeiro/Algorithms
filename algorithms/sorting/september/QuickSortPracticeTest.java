package algorithms.sorting.september;

public class QuickSortPracticeTest {
    /**
     * quick sort = moves smaller elements to left of a pivot.
     *              recursively divide array in 2 partitions
     *
     * run-time complexity = Best case O(n log(n))
     *                       Average case O(n log(n))
     *                       Worst case O(n^2) if already sorted
     *
     * Space complexity = 0(log(n)) due to recursion
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Initial: ");

        int[] integers = {8,2,4,7,1,3,9,6,5};
//        int[] integers = {2,8,4,7,1};
//        int[] integers = {5,8,2,3,7};
//        int[] integers = {6,1,5,3,2,4};
//        int[] integers = {1,2,3,4};

        for (int i : integers) {
            System.out.println(i);
        }

        quickSort(integers, 0, integers.length-1);

        System.out.println("Final: ");
        for (int i : integers) {
            System.out.println(i);
        }
    }

    // 1. Recebe o array de int
    // 2. Define o pivot sendo o ultimo elemento do array
    // 3. Coloca os numeros menor que o pivot a esquerda
    // 4. Ao final troca o pivot para a ultima posicao do "i" (meio do array)
    // 5. Retorna esse meio array como sendo o novo pivot


    private static void quickSort(int[] integers, int start, int end) {
        // Condicao de parada
        // Base case
        if(end <= start) return;

        int pivot = partition(integers, start, end);
        quickSort(integers, 0, pivot-1);
        quickSort(integers, pivot+1, end);

    }

    private static int partition(int[] integers, int start, int end){
        int pivot = integers[end];
        int i = start-1;
        for (int j = start; j < end; j++) {
            if(integers[j] < pivot){
                i++;
                int temp = integers[i];
                integers[i] = integers[j];
                integers[j] = temp;
            }
        }
        i++;
        int temp = integers[i];
        integers[i] = integers[end];
        integers[end] = temp;
        return i;
    }

//    private static int partition(int[] integers, int start, int end) {
//        int pivot = integers[end];
//        int j = start;
//        int i = j-1;
//        while(j < end){
//            if(integers[j] < pivot){
//                i++;
//                int temp = integers[i];
//                integers[i] = integers[j];
//                integers[j] = temp;
//            }
//            j++;
//        }
//        i++;
//        int temp = integers[i];
//        integers[i] = integers[j];
//        integers[j] = temp;
//        return i;
//    }

    // {6,1,5,3,2,4};
    // {1,6,5,3,2,4}; i =0, j=2
    // {1,6,5,3,2,4}; i =0, j=3
    // {1,3,5,6,2,4}; i =0, j=4
    // {1,3,2,6,5,4}; i =0, j=4

}
