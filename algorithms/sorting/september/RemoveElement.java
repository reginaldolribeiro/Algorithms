package algorithms.sorting.september;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
//        int[] nums = {3,1,2,3,4};
//        int[] nums = {};
        for(int n : nums){
            System.out.print(n + " ");
        }
        int result = removeElement(nums, 3);
        System.out.println("\nResult: " + result);
    }

    // Somente contar os elementos que nao sao iguais ao VAL
    // newSize=0, i=0
    // newsize=0, i=1 {2,3,2,3}
    // newsize=1, i=2 {2,2,3,3}
    // newsize=2, i=3
    public static int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    // Trocar o valor do numero "val" por -1
    // Fazer loop contando quantos -1 tem no array
    // Subtrair o total de -1 no array pelo tamanho do array
//    public static int removeElement(int[] nums, int val){
//        if(nums == null || nums.length == 0) return 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == val){
//                nums[i] = -1;
//            }
//        }
//        System.out.println("\n *** ");
//        for(int n : nums){
//            System.out.print(n + " ");
//        }
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == -1) count++;
//        }
//        return nums.length - count;
//    }
}
