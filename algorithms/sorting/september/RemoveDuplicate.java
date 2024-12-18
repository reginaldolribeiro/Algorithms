package algorithms.sorting.september;

public class RemoveDuplicate {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,0,1,1,1,2};
        // {0,0,1,1,1,2}
        // {0,1,1,1,1,2}
        int result = removeDuplicates(nums);
        System.out.println("\nResult " + result);
    }

    // Remover os elementos duplicados (logicamente)
    // Manter a ordem
    // Deixar os elementos nao duplicados no comeco do array
    // Retornar a quantidade de elementos nao duplicados
    private static int removeDuplicates(int[] nums){
        if(nums == null || nums.length <= 1)
            return 0;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        for(Integer i : nums){
            System.out.print(nums[i] + " o");
        }
        return count++;
    }
}
