package exercises.loadbalancer.robust;

import java.util.List;

public class LoadBalancerTest {
    public static void main(String[] args) {
        List<LoadBalancerInstance> instances = List.of(
          new LoadBalancerInstance("A","172.10.2.100", true),
          new LoadBalancerInstance("B","172.10.2.101", true),
          new LoadBalancerInstance("C","172.10.2.102", true)
        );

        var loadBalancer = new LoadBalancer(instances);
        System.out.println("Instances: " + loadBalancer.getInstances());

        int request = 3;
        String nextInstance = null;
        for (int i = 1; i <= request; i++) {
            nextInstance = loadBalancer.getInstanceRoundRobin();
        }
        System.out.println("Next instance: " + nextInstance);
    }
}
