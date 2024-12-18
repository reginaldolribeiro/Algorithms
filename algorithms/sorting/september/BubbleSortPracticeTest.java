package algorithms.sorting.september;

import java.util.Arrays;
import java.util.List;

public class BubbleSortPracticeTest {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
//        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);
        System.out.println("\nInitial List: " + integers + "\n");

        myBubbleSort(integers);

        System.out.println("FINAL List: " + integers);
    }

    // Percorrer o array ate o ultimo indice comparando se o elemento atual é maior que o posterior, se for,
    // faz a troca de posicao, se nao for, continua percorrendo o array ate o final.
    // A cada iteracao no array o maior elemento vai sendo empurrado para a ultima posicao, ou seja, a cada vez
    // que percorremos o array, o ultimo elemento ja esta ordenado
    // Podemos ir diminuindo o ultimo indice do array a cada iteracao completa
    // Devemos guardar tambem se houve troca de posicao ou nao, porque caso nao tenha tido, o array ja esta ordenado
    //
    public static void myBubbleSort(List<Integer> list){
        if(list.size() > 1){
            int lastIndex = list.size()-1;
            while(lastIndex > 0){
                boolean swapped = false;
                for (int i = 0; i < lastIndex; i++) {
                    if(list.get(i) > list.get(i+1)){
                        int temp = list.get(i+1);
                        list.set(i+1, list.get(i));
                        list.set(i, temp);
                        swapped = true;
                    }
                }
                if(!swapped)
                    return;
                lastIndex--;
            }
        }
    }

}
