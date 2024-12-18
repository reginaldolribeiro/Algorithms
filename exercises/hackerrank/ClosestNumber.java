package exercises.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClosestNumber {

    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(50, 20, 3, 7, 8, 9, 10);
        List<Integer> arr = Arrays.asList(50, 20, 3, 7, 8, 9, 11);
        System.out.println("Unordered array: " + arr);

        List<Integer> result = closestNumbers(arr);
        System.out.println("Ordered array: " + result);
    }


    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Sort array
        arr.sort(null);

        int minDiff = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> pairsWithDiffBetween = new HashMap<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            int currentValue = arr.get(i);
            int nextValue = arr.get(i + 1);
            int currentDiff = nextValue - currentValue;

            if(currentDiff <= minDiff){
                if(pairsWithDiffBetween.containsKey(currentDiff)){
                    pairsWithDiffBetween.get(currentDiff).add(currentValue);
                    pairsWithDiffBetween.get(currentDiff).add(nextValue);
                }else{
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(currentValue);
                    temp.add(nextValue);
                    pairsWithDiffBetween.put(currentDiff, temp);
                }
                minDiff = currentDiff;
            }
        }
        return pairsWithDiffBetween.get(minDiff);
    }

    /*public static List<Integer> closestNumbers(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int currentDiff = arr.get(i+1) - arr.get(i);
            if(i==0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(arr.get(i));
                temp.add(arr.get(i+1));
                map.put(currentDiff, temp);
                minDiff = currentDiff;
            }else{
                if(currentDiff <= minDiff){
                    if(map.containsKey(currentDiff)){
                        map.get(currentDiff).add(arr.get(i));
                        map.get(currentDiff).add(arr.get(i+1));
                    }else{
                        List<Integer> temp2 = new ArrayList<Integer>();
                        temp2.add(arr.get(i));
                        temp2.add(arr.get(i+1));
                        map.put(currentDiff, temp2);
                    }
                    minDiff = currentDiff;
                }
            }
        }
        List<Integer> result = map.get(minDiff);
        return result;
    }*/


//    public static void main(String[] args) {
//
//        // 1. Array desordenado
////        int i = new int; {5,2,3,4,1};
//        List<Integer> arr = Arrays.asList(50, 20, 3, 7, 8, 9, 10);
//        System.out.println("Unordered array: " + arr);
//
//        // 2. Ordenar o array
//        arr.sort(null);
//        System.out.println("Ordered array: " + arr);
//
//        // 3. Dividir o array em pares
//        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
//
//        for (int i = 0; i < arr.size()-1; i++) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            temp.add(arr.get(i));
//            temp.add(arr.get(i+1));
//            pairs.add(temp);
//        }
//        System.out.println("Pairs: " + pairs);
//
//        // 4. Verificar a diferenca de valor entre os pares e escolher o par de menor diff
//        ArrayList<Integer> indexes = new ArrayList<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        int minorIndex = 0;
//
//        for (int j = 0; j < pairs.size()-1; j++) {
//            int minorDiff = 0;
//            int currentDiff = 0;
//
//            currentDiff = pairs.get(j).get(1) - pairs.get(j).get(0);
//
//            if(j == 0){
//                minorIndex = j;
//            } else {
//                minorDiff = pairs.get(j-1).get(1) - pairs.get(j-1).get(0);
//                if(currentDiff < minorDiff){
//                    minorIndex = j;
//                    // adiciona no HashMap colocando o indice na key e o minorDiff no value
//                    // Busca no map o menor minorDiff
//                    // Adiciona ele no novo array
//                }
//            }
//        }
//        result.add(pairs.get(minorIndex).get(0));
//        result.add(pairs.get(minorIndex).get(1));
//        System.out.println(result);
//
//        // 5. Retornar um array com os pares
//
////        System.out.println("ClosestNumbers: " + closestNumbers);
//    }

//    public static List<Integer> closestNumbers(List<Integer> arr) {
//
//        int minorDiff = 0;
////        List<Integer> minorDiffArray = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
//
//        for (int i = 0; i < arr.size()-1; i++) {
//            Integer firstIndex = arr.get(i);
//            Integer secondIndex = arr.get(i + 1);
//            minorDiff = secondIndex - firstIndex;
//
//        }
//
//        return arr;
//    }
}
