package exercises.loadbalancer.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private List<String> instances;
    private int nextInstance = 0;

    public LoadBalancer(List<String> instances){
        this.instances = new ArrayList<>(instances); // Ensure mutability
    }

    public List<String> getInstances() {
        return instances;
    }

    public void registerInstance(String newInstance){
        this.instances.add(newInstance);
    }

    public void deregisterInstance(String newInstance){
        this.instances.remove(newInstance);
    }

    public void registerInstances(List<String> instances){
        this.instances.addAll(instances);
    }

    public void deregisterInstances(List<String> instances){
        this.instances.removeAll(instances);
    }

    public String getInstanceRoundRobin(){
        if (instances.isEmpty())
            throw new IllegalStateException("No instances available to handle requests");

//        nextInstance = (nextInstance + 1) % instances.size();
        // OR
        if(nextInstance == instances.size()-1){
            nextInstance = 0;
        }else{
            nextInstance++;
        }
        return instances.get(nextInstance);
    }

    public String getInstanceRandom(){
        if (instances.isEmpty())
            throw new IllegalStateException("No instances available to handle requests");

        int randomIndex = new Random().nextInt(instances.size());
        return instances.get(randomIndex);
    }

}
