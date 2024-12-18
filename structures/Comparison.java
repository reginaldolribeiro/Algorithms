package structures;

import java.util.ArrayList;
import java.util.LinkedList;

public class Comparison {

    // LinkedList =  Nodes are in 2 parts (data + address)
    //                        Nodes are in non-consecutive memory locations
    //                        Elements are linked using pointers

    //    advantages?
    //    1. Dynamic Data Structure (allocates needed memory while running)
    //    2. Insertion and Deletion of Nodes is easy. O(1)
    //    3. No/Low memory waste

    //    disadvantages?
    //    1. Greater memory usage (additional pointer)
    //    2. No random access of elements (no index [i])
    //    3. Accessing/searching elements is more time consuming. O(n)

    //    uses?
    //    1. implement Stacks/Queues
    //    2. GPS navigation
    //    3. music playlist
    //

    // *****************************************************

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for(int i=0; i < 1000000; i++){
            linkedList.add(i);
            arrayList.add(i);
        }


        // ******************* LinkedList *******************
        startTime = System.nanoTime();

        // do something
//        linkedList.get(0);
//        linkedList.get(500000);
//        linkedList.get(999999);
//        linkedList.remove(0);
//        linkedList.remove(500000);
        linkedList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("LinkedList:\t" + elapsedTime + " ns");

        // ******************* ArrayList  *******************

        startTime = System.nanoTime();

        // do something
//        arrayList.get(0);
//        arrayList.get(50000);
//        arrayList.get(999999);
//        arrayList.remove(0);
//        arrayList.remove(500000);
        arrayList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("ArrayList:\t" + elapsedTime + " ns");

    }
}
