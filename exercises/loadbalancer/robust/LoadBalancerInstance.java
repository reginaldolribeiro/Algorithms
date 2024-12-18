package exercises.loadbalancer.robust;

public record LoadBalancerInstance(
        String name,
        String address,
        boolean available
){}
