package exercises.loadbalancer.robust;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private List<LoadBalancerInstance> instances;
    private int nextInstance = 0;

    public LoadBalancer(List<LoadBalancerInstance> instances){
        this.instances = new ArrayList<>(instances); // Ensure mutability
    }

    public List<LoadBalancerInstance> getInstances() {
        return instances;
    }

    public void registerInstance(LoadBalancerInstance newInstance){
        this.instances.add(newInstance);
    }

    public void deregisterInstance(LoadBalancerInstance newInstance){
        this.instances.remove(newInstance);
    }

    public void registerInstances(List<LoadBalancerInstance> instances){
        this.instances.addAll(instances);
    }

    public void deregisterInstances(List<LoadBalancerInstance> instances){
        this.instances.removeAll(instances);
    }

    public String getInstanceRoundRobin() {
        if (instances.isEmpty())
            throw new IllegalStateException("No instances available to handle requests");

        int checked = 0;
        int availableIndex = -1;

        while (checked < instances.size()) {
            var currentInstance = instances.get(nextInstance);

            if(currentInstance.available()){
                availableIndex = nextInstance;
                getNextInstance(); // Move to the next instance

                if (instances.get(nextInstance).available())
                    return instances.get(nextInstance).name();

            }

            // Always move to the next instance
            getNextInstance();
            checked++;
        }

        if(availableIndex >= 0)
            return instances.get(availableIndex).name();

        throw new IllegalStateException("No available instances to handle requests");
    }

    private void getNextInstance() {
        if (nextInstance == instances.size() - 1) {
            nextInstance = 0;
        } else {
            nextInstance++;
        }
    }

    /**
     * 1. Shuffled Indices:
     * 	• Ensures all instances are checked exactly once in a random order.
     * 2. Efficiency:
     * 	• Avoids repeated random selection of the same unavailable instances.
     * 3. Guarantee:
     * 	• Fully iterates through all instances, ensuring fairness and correctness.
     *
     * @return
     */
    public String getInstanceRandom() {
        if (instances.isEmpty())
            throw new IllegalStateException("No instances available to handle requests");

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < instances.size(); i++) {
            indexes.add(i);
        }
        Collections.shuffle(indexes);

        for (Integer index : indexes){
            var current = instances.get(index);
            if(current.available())
                return current.name();
        }

        throw new IllegalStateException("No available instances to handle requests");
    }

}
