package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,2,8};
        int number = singleNumber(nums);
        System.out.println(number);
//        mapTests();
    }

    /**
     * Given an integer array nums where every element appears three times except for one, which appears exactly once.
     * Find the single element and return it.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Example 1:
     *
     *  Input: nums = [2,2,3,2]
     *  Output: 3
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){ // O(n)
            if(map.get(num) != null){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ // O(n)
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }


    public static int singleNumber3(int[] nums){
        int value = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.merge(num, value, Integer::sum);
        }
        return map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == value)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    public static int singleNumber2(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.merge(num, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }



    private static void mapTests() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 15);
        map.putIfAbsent(2,30);
        System.out.println(map);
        Integer integer = map.get(1);
//        System.out.println(integer);
//        System.out.println(map);
//        System.out.println("values: " + map.values());
        Integer orDefault = map.getOrDefault(10, 55);
//        System.out.println("orDefault: " + orDefault);

        System.out.println();
        System.out.println(map.entrySet());

        Integer integer1 = map.entrySet().stream().map(integerIntegerEntry -> {
            if (integerIntegerEntry.getValue() == 30) {
                return integerIntegerEntry.getKey();
            } else {
                return 0;
            }
        }).findFirst().get();

//        Integer key = map.entrySet().stream().filter(a -> a.getValue() == 30).findFirst().get().getKey();
//        Integer key = map.entrySet().stream().filter(a -> a.getValue() == 31)
//                .findFirst().orElse(new AbstractMap.SimpleEntry<>(0,0)).getKey();
        Integer key = map.entrySet().stream().filter(a -> a.getValue() == 30).findFirst().orElseThrow(IllegalAccessError::new).getKey();
        System.out.println("Index key equal 30: " + key);

//        Optional<Map.Entry<Integer, Integer>> first = map.entrySet().stream().filter(a -> a.getValue() == 30).findFirst();
//        if(first.isPresent()){
//            Integer key = first.get().getKey();
//            System.out.println("Index key equal 30: " + key);
//        } else {
//            System.out.println("Key nao encontrada");
//        }
//        System.out.println("Index key equal 30: " + key);
    }
}
