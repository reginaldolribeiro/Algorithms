package exercises.leetcode;

public class MissingNumber {
    public static void main(String[] args) {
//        int[] nums = {3,4,1,2};
//        int[] nums = {3, 0, 1};
        int[] nums = {-1,-3};
//        int[] nums = {9,6,4,2,3,5,7,0,1};
        int result = missingNumber(nums);
        System.out.println(result);
    }

    public static int missingNumber(int[] A) {
        int n = A.length;

        // Place each number in its correct position if it's in the range [1, n]
        int i = 0;
        while (i < n && A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
            if(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]){

            }
            int temp = A[A[i] - 1];
            A[A[i] - 1] = A[i];
            A[i] = temp;
            i++;
        }

        // Find the first missing positive number
        for (int j = 0; j < n; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }

        // If all numbers [1, n] are present, the missing number is n + 1
        return n + 1;
    }

    /**
     * Para o caso de array com inteiros positivos onde o maior valor no array é exatamente o tamanho deste array,
     * podemos usar a tecnica In-Place Hashing para reordenar o array fazendo o seguinte:
     * - Valor do array - 1 é igual o Index que ele deveria estar
     *  Exemplo: valor = 3 , index = 2 -> Posiciona o valor 3 no index 2
     *
     *
     * @param A
     * @return
     */
    // Este loop posiciona cada número no índice correto no array, ou seja,
    // para um número nums[i], ele será colocado na posição nums[i] - 1,
    // desde que esteja no intervalo válido (1 a nums.length) e não seja duplicado.
    // Isso é feito in-place, sem usar espaço extra.
//    public static int missingNumber(int[] A){
//        for (int i = 0; i < A.length; i++) {
//            int correctIndex = A[i] - 1; // Índice onde o número deveria estar
//            boolean isWithinValidRange = A[i] > 0 && A[i] <= A.length; // Verifica se está no intervalo [1, nums.length]
//            if (isWithinValidRange && A[correctIndex] != A[i] && correctIndex != i) {
//                int temp = A[correctIndex];
//                A[correctIndex] = A[i];
//                A[i] = temp;
//            }
//        }
//        boolean negativeNumber = true;
//        for (int i = 0; i < A.length-1; i++) {
//            if(A[i] >= 0){
//                negativeNumber = false;
//                if(A[i+1] != A[i] + 1)
//                    return A[i]+1;
//            }
//        }
//        if(negativeNumber)
//            return 1;
//
//        return A.length + 1;
//    }

    public static int missingNumber1(int[] A){
        for (int i = 0; i < A.length; i++) {
            int correctIndex = A[i] - 1;
            boolean isWithinValidRange = A[i] > 0 && A[i] <= A.length;
            if (isWithinValidRange && A[correctIndex] != A[i] && correctIndex != i) {
                int temp = A[correctIndex];
                A[correctIndex] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < A.length-1; i++) {
            if(A[i+1] != A[i] + 1)
                return A[i]+1;
        }
        return A.length + 1;
    }

}
