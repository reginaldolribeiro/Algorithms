package algorithms.search;

public class BinarySearchTest {
    public static void main(String[] args) {
//        int[] array = new int[1000000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
//        int target = 777777;

//        int[] array = {1,2,3,4,5,6,7,8,9};
        int[] array = {1,2,3,4,5,6};
        int target = 5;
//        int index = Arrays.binarySearch(array, 3);
        int index = binarySearch(array, target);

        if(index != -1){
            System.out.println("Element found at index " + index);
        }else{
            System.out.println("Element not found!");
        }
    }

    private static int binarySearch(int[] array, int target){
        if(array == null || array.length == 0)
            return -1;

        int low = 0;
        int high = array.length-1;

        while(low <= high){
            // para encontrarmos corretamente o meio precisamos considerar que
            // o valor de 'low' pode nao ser mais zero, ou seja, temos que
            // fazer a diferenca entre high e low, dividir por 2 e depois somar
            // o valor de 'low' nisso, pois senao estaremos contando a partir do zero
            // estaremos considerando que o 'low' eh zero, quando pode nao ser
            // First, we calculate the difference between the last position (high) and the first position (low).
            // Then, we divide that difference by 2 to find the middle point.
            // At this point, we're calculating the position relative to zero, not taking into account the starting point 'low'.
            // That's why we need to add 'low' to get the actual middle position in the array.
            int middle = low + (high-low)/2;
            int value = array[middle];

            if(target < value){
                high = middle-1;
            } else if(target > value){
                low = middle+1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
