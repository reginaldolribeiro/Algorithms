package algorithms.sorting.september;

public class BinarySearchPractice {
    public static void main(String[] args) {
        int[] array = new int[5];
        int target = 5;
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
//        int index = Arrays.binarySearch(array, target);
        int index = binarySearch(array, target);
        if(index == -1){
            System.out.println("Target " + target + " not found");
        }else{
            System.out.println("Target found at: " + index);
        }
    }

    // target=7, array=1,2,3,4,5,6 ... start=0, end=5
    // 7 == 3 ? NAO
    // 7 < 3 ? NAO, start=2,end=5
    // array=3,4,5,6 meio = 5
    //
    // 7 < 5, NAO, start=4, end=5
    // array=5,6 .. meio=6
    // 7 < 6, NAO, start=5, end=5
    // meio=5 que eh o valor 6
    // 7 < 6, start=5, end=5
    private static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int middle = start + (end - start) / 2;
//            int middle = (start + end + 1) / 2;
            int value = array[middle];
            if(target < value){
                end = middle-1;
            }else if(target > value){
                start = middle+1;
            }else{
                return middle;
            }
        }

        return -1;
    }



}
