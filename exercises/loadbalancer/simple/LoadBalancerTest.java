package exercises.loadbalancer.simple;

import java.util.List;

public class LoadBalancerTest {
    public static void main(String[] args) {
        List<String> instances = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

        var loadBalancer = new LoadBalancer(instances);
        System.out.println("Initializing instances: " + loadBalancer.getInstances());

        System.out.println("\n*** Testing Round-Robin Strategy ***");
        int request = 3;
        String nextInstance = null;
        for (int i = 1; i <= request ; i++) {
            nextInstance = loadBalancer.getInstanceRoundRobin();
        }
        System.out.println("For " + request + " requests, Next Instance is: " + nextInstance);

//        request = 8;
//        for (int i = 1; i <= request ; i++) {
//            nextInstance = loadBalancer.getInstanceRoundRobin();
//        }
//        System.out.println("For " + request + " requests, Next Instance is: " + nextInstance);
//
//        System.out.println("\n*** Testing Random Strategy ***");
//        request = 3;
//        for (int i = 1; i <= request ; i++) {
//            nextInstance = loadBalancer.getInstanceRandom();
//        }
//        System.out.println("For " + request + " requests, Next Instance is: " + nextInstance);
//
//        request = 8;
//        for (int i = 1; i <= request ; i++) {
//            nextInstance = loadBalancer.getInstanceRandom();
//        }
//        System.out.println("For " + request + " requests, Next Instance is: " + nextInstance);
//
//        System.out.println("\n*** Adding New Instances ***");
//        loadBalancer.registerInstance("K");
//        System.out.println("Instances: " + loadBalancer.getInstances());
//
//        System.out.println("\n*** Testing Round-Robin Strategy ***");
//        request = 12;
//        for (int i = 1; i <= request ; i++) {
//            nextInstance = loadBalancer.getInstanceRoundRobin();
//        }
//        System.out.println("For " + request + " requests, Next Instance is: " + nextInstance);
    }

}
