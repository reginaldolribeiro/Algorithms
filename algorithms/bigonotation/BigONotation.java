package algorithms.bigonotation;

import java.util.List;

public class BigONotation {

    public static void main(String[] args) {
        printFirst1(List.of("Reginaldo", "Ribeiro"));
    }

    // Notation Big O(1) because it only prints one item (first position)
    public static void printFirst1(List<String> items){
        System.out.println(items.get(0)); // Big O(1)
    }

    // Notation Big O(n) because prints how many elements the list will have
    //
    public static void printFirst2(List<String> items){
        System.out.println(items.get(0)); // Big O(1)

        // Este algoritmo cresce linearmente
        // Se receber uma lista de 3 elementos, vai crescer O(3)
        // Se receber uma lista de 100 elementos, vai crescer de 0(100)
        // ....
        items.forEach(item ->{ // Big O(n) n = quantity of items
            System.out.println(item); // Big O(1)
        });

    }

}
