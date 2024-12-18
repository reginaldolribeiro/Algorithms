package algorithms.sorting.september;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] integers = {64, 25, 12, 22, 11};
        System.out.println("--- INTEGERS ----");
        for(int i: integers){
            System.out.println("Initial array: " + i);
        }
        insertionSortIntegers(integers);
        for(int i : integers){
            System.out.println("FINAL array: " + i);
        }
    }

    private static void insertionSortIntegers(int[] integers) {
        if(integers == null || integers.length <= 1)
            return;

        for (int i = 1; i < integers.length; i++) {
            int current = integers[i];
            int j = i-1;

            while(j >= 0 && integers[j] > current) {
                if (integers[j] > current) {
                    integers[j + 1] = integers[j];
                    j--;
                }
            }

            integers[j+1] = current;
        }
    }
}
