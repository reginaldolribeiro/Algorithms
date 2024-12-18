package algorithms.data.structures;

import java.util.Hashtable;

public class HashTableStudy {

    // Hashtable = A data structure that stores unique keys to values. Ex.<Integer, String>
    //              Each key/value pair is known as an Entry
    //              FAST insertion, look up, deletion of key/value pairs
    //              Not ideal for small datasets, great with large datasets
    //
    // hashing = takes a key and computes an integer (formula will vary based on key & data type)
    //          In a Hashtable we use the hash % capacity to calculate an index number
    //
    //          key.hashCode() % capacity = index
    //
    // bucket = an indexed storage location for one or more Entries
    //          can store multiple Entries in case of a collision (linked similarly a LinkedList)
    //
    // collision = hash function generates the same index for more than one key
    //              less collision = more efficiency
    //
    // Runtime complexity: Best Case O(1)
    //                      Worst Case O(n)
    //
    public static void main(String[] args) {
        System.out.println("\n***** INTEGER TABLE *****\n");

        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(100, "Spongebob");
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "Squidward");
        table.put(777, "Gary");

//        System.out.println(table.get(100));
//        table.remove(777);

//        table.forEach((k,v) -> System.out.println(k + "\t" + table.get(k)));
        for(Integer key : table.keySet()){
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        }

        System.out.println("\n***** STRING TABLE *****\n");

        Hashtable<String, String> stringTable = new Hashtable<>(10);
        stringTable.put("100", "Spongebob");
        stringTable.put("123", "Patrick");
        stringTable.put("321", "Sandy");
        stringTable.put("555", "Squidward");
        stringTable.put("777", "Gary");

//        System.out.println(table.get(100));
//        table.remove(777);

//        table.forEach((k,v) -> System.out.println(k + "\t" + table.get(k)));
        for(String key : stringTable.keySet()){
            System.out.println(key.hashCode()%10 + "\t" + key + "\t" + stringTable.get(key));
        }
    }

}
