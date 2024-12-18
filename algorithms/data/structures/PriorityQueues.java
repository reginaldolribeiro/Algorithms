package algorithms.data.structures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {

    //
    //  Priority Queue = A FIFO data structure that serves elements
    //                  with the highest priorities first
    //                  before elements with lower priority
    //
    public static void main(String[] args) {

        System.out.println("*********** QUEUE ************\n");

        Queue<Double> queue = new LinkedList<>();

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        System.out.println("Populated queue " + queue);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        System.out.println("Queue after poll() " + queue);

        System.out.println("\n*********** PRIORITY DOUBLE QUEUE ************\n");

        Queue<Double> priorityQueue = new PriorityQueue<>();
//        Queue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.offer(3.0);
        priorityQueue.offer(2.5);
        priorityQueue.offer(4.0);
        priorityQueue.offer(1.5);
        priorityQueue.offer(2.0);

        System.out.println("Populated priorityQueue " + priorityQueue);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

        System.out.println("Priority Queue after poll() " + priorityQueue);

        System.out.println("\n*********** PRIORITY STRING QUEUE ************\n");

        Queue<String> priorityStringQueue = new PriorityQueue<>();
//        Queue<String> priorityStringQueue = new PriorityQueue<>(Collections.reverseOrder());

        priorityStringQueue.offer("C");
        priorityStringQueue.offer("E");
        priorityStringQueue.offer("A");
        priorityStringQueue.offer("D");
        priorityStringQueue.offer("B");

        System.out.println("Populated STRING priorityStringQueue " + priorityStringQueue);

        while (!priorityStringQueue.isEmpty()){
            System.out.println(priorityStringQueue.poll());
        }

        System.out.println("Priority STRING Queue after poll() " + priorityStringQueue);
    }
}
