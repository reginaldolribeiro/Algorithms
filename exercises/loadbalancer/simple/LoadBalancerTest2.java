package exercises.loadbalancer.simple;

import java.util.List;

public class LoadBalancerTest2 {
    public static void main(String[] args) {
        List<String> instances = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        int requests = 3;
        int nextInstanceIndex = loadBalancerRoundRobin(instances, requests, 0);
        System.out.println("Next Instance is: " + instances.get(nextInstanceIndex));

        System.out.println("******");
        nextInstanceIndex = loadBalancerRoundRobin(instances, 8, nextInstanceIndex);
        System.out.println("Next Instance is: " + instances.get(nextInstanceIndex));
    }

    private static int loadBalancerRoundRobin(List<String> instances, int requests, int nextInstance) {
        int nextIndex = nextInstance;
        for (int i = 1; i <= requests ; i++) {
            if(nextIndex == instances.size()-1){
                nextIndex = 0;
            }else{
                nextIndex++;
            }
        }
        return nextIndex;
    }

    private static int loadBalancerRandom(List<String> instances, int requests, int nextInstance) {
        int nextIndex = nextInstance;
        for (int i = 1; i <= requests ; i++) {
            if(nextIndex == instances.size()-1){
                nextIndex = 0;
            }else{
                nextIndex++;
            }
        }
        return nextIndex;
    }
}
