package algorithms.search;

public class LinearSearch {

    /**
     * linear search = Iterate through a collection one element at a time
     *
     *     runtime complexity: 0(n)
     *
     *     Disadvantages:
     *      - Slow for large data sets
     *
     *     Advantages:
     *      - Fast for searches of small to medium data sets
     *      - Does not need to sorted
     *      - Useful for data structures that do not have random access (Linked List)
     *
     */
    public static void main(String[] args) {
        int[] array = {4,3,5,6,8,1,2};

        int index = linearSearch(array, 3);

        if(index != -1){
            System.out.println("Element found at index " + index);
        }else{
            System.out.println("Element not found!");
        }
    }

    private static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }
}
