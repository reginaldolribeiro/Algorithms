package algorithms.data.structures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStudy {

    //    *********************************************
    //
    //    Queue = FIFO data structure. First-In First-Out
    //            A collection designed for holding elements prior to processing
    //            Linear data structure
    //
    //          add     = enqueue, offer ()
    //          remove  = dequeue, poll()
    //          peek    = return the head of the queue, element()
    //
    //   Where are queues useful?
    //      1. Keyboard Buffer (letters should appear on the screen in the order they're pressed)
    //      2. Printer Queue (Print jobs should be completed in order)
    //      3. Used in LinkedLists, PriorityQueues, Breadth-first search

    //    *********************************************
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        System.out.println("The queue is empty? " + queue.isEmpty());
        System.out.println("The queue " + queue);

        // Adding people in line
        System.out.println("Adding people in line...\n");

//        queue.add("Test1"); add and queue has the same function
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println("Now we have " + queue.size() + " people in the line: \n" + queue);
        System.out.println("The queue is empty? " + queue.isEmpty());

        System.out.println("Is Harold in line? " + queue.contains("Harold"));

        // Removing people from the line
//        System.out.println(queue.peek());
        queue.poll(); //dequeue
        queue.poll(); //dequeue

        System.out.println("\nRemoving people from the line \nPeople in the queue: " + queue);
    }
}
