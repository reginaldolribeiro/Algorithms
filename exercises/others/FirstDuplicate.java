package exercises.others;


import java.util.*;

public class FirstDuplicate {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 3, 5, 3, 2);
        // in this case the duplicate number to return is 3,because the second time that its appear it has a smaller index
        // if find the duplicate number, return it
        // if don't find the duplicate number, return -1
//        for(int i=0; i < numbers.size(); i++){
//            System.out.println("Number "+numbers.get(i));
//        }
        int duplicatedNumber = firstDuplicate(numbers);
        System.out.println("First duplicated is: " + duplicatedNumber);
    }


    /**
     * Best solution
     *
     */
    public static int firstDuplicate(List<Integer> numbers) {
        // Use the index of the numbers list to mark duplicates
        for (int i = 0; i < numbers.size(); i++) {
            int index = Math.abs(numbers.get(i)) - 1;  // Get the corresponding index (adjusted for zero-based indexing)

            if (numbers.get(index) < 0) {
                return Math.abs(numbers.get(i));  // Found the first duplicate
            }

            numbers.set(index, -numbers.get(index));  // Mark this number as visited by negating its value
        }

        return -1;  // No duplicates found
    }



    /**
     * We have just ONE Loop.
     * Best implementation because we are using "Set.contains" to search a value, which is a faster way
     * Big O Notation is O(n)
     *  Time complexity: O(n), where n is the length of the list
     *  Space complexity: O(n), due to the additional boolean array (numbersAlreadyRead)
     *
     * Compare to the other solution, here we added one more collection to store the number is already read
     *
     * @param numbers
     * @return
     */
    public static int firstDuplicate1(List<Integer> numbers){
        Set<Integer> numbersAlreadyRead = new HashSet<>();

        for(int i=0; i < numbers.size(); i++){
            if(numbersAlreadyRead.contains(numbers.get(i))){
                return numbers.get(i);
            }else{
                numbersAlreadyRead.add(numbers.get(i));
            }
        }

        return -1;
    }

    /**
     * We have just ONE Loop.
     *
     * Medium implementation because we are using "ArrayList.contains" which is not the fastest Collection to search things like this
     * Big O Notation is O(n)
     *
     * @param numbers
     * @return
     */
    public static int firstDuplicateMedium(List<Integer> numbers){
        List<Integer> numbersAlreadyRead = new ArrayList<>();

        for(int i=0; i < numbers.size(); i++){
            if(numbersAlreadyRead.contains(numbers.get(i))){ // O(n)
                return numbers.get(i);
            }else{
                numbersAlreadyRead.add(numbers.get(i));
            }
        }

        return -1;
    }

    /**
     * Complexity is quadratic, Big O(n^2) because we have nested loops.
     *
     * @param numbers
     * @return
     */
    private static int firstDuplicateWorstCase(List<Integer> numbers) {
        int listSize = numbers.size(); // O(1)
        int firstDuplicatedIndex=-1;

        for(int i=0; i < listSize; i++){ // O(n)
            for(int j=i+1; j < listSize; j++){ // O(n)
                if(numbers.get(j) == numbers.get(i)){ // O(1)
                    if(firstDuplicatedIndex == -1 || j < firstDuplicatedIndex){
                        firstDuplicatedIndex = j;
                    }
                }
            }
        }

        System.out.println("Index " + firstDuplicatedIndex + ", Value " + numbers.get(firstDuplicatedIndex));

        if(firstDuplicatedIndex == -1) {
            return -1;
        }else{
            return numbers.get(firstDuplicatedIndex); // O(1)
        }
    }

    /**
     * Encontrar o numero repetido no array sendo que ele deve ser a segunda aparicao do numero com o menor indice
     *
     * Exemplo:
     *  Considerando o array [2, 1, 3, 5, 3, 2], o numero seria 3, porque ele aparece pela segunda vez antes do 2
     *
     * @param numbers
     * @return
     */
    private static int firstDuplicate10(List<Integer> numbers) {
        int listSize = numbers.size();
        for(int i=0; i < listSize; i++){
            for(int j=i+1; j < listSize; j++){
                if(numbers.get(j) == numbers.get(i)){
                    return numbers.get(j);
                }
            }
        }

        return -1;
    }

    // Encontra o numero de menor posicao do array que esta repetido.
    private static int minIndexNumberDuplicated(List<Integer> numbers) {
        int listSize = numbers.size();

        for(int i=0; i < listSize; i++){
            for(int j=i+1; j < listSize; j++){
                if(numbers.get(j) == numbers.get(i)){
                    return numbers.get(j);
                }
            }
        }

        return -1;
    }


    private static List<Integer> myBubbleSort3(List<Integer> integers){
        int n = integers.size()-1; // O(1)
        boolean swapped = false;
        int iterations = 0;

        for(int i=n; i > 0; i--){ // O(n)
            System.out.println("--");
            swapped = false;

            // The last "i" elements is already sorted
            for(int j=0; j < i; j++){ // O(n)
                if(integers.get(j) > integers.get(j+1)){ // O(1)
                    int temp = integers.get(j); // O(1)
                    integers.set(j, integers.get(j+1)); // O(1)
                    integers.set(j+1, temp); // O(1)
                    swapped = true;
                }
                System.out.println("Processed List " + j + " time(s): " + integers);
            }

            iterations++;

            // If there wasn't swap (or change) in this iteration, the list is already sorted
            if(!swapped) break;
        }

        System.out.println("\n iterations: " + iterations + "\n");
        return integers;

    }

    /**
     * 1. Ordena o array
     * 2. Verifica se o item da primeira posicao eh igual ao item da segunda, se for , retorna o numero
     *
     * Solucao nao serve, pois nao eh oq ta pedindo, nao podemos ordenar o array
     */
    public void test(){
        //        int i = numbers.stream().mapToInt(value -> value).min().orElse(-1);
//        System.out.println(i);

//        myBubbleSort3(numbers); // O(n^2)
//
//        for(int i=0; i<numbers.size()-1; i++){ // O(n)
//            if(numbers.get(i) == numbers.get(i+1)){
//                System.out.println("Number found is " + numbers.get(i));
////                return numbers.get(i);
//            }else{
//                System.out.println("NUmber is not found. Returning -1");
//            }
//        }
    }




}
