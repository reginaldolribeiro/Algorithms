package exercises.hackerrank;

public class MarsExploration {
    public static void main(String[] args) {
        String s1 = "SOSTOT";
        String s2 = "SOSOT";
        String s3 = "SOSSPSSQSSOR";
        System.out.println("Original string: " + s1 + ". Changes: " + marsExploration(s1));
        System.out.println("Original string: " + s2 + ". Changes: " + marsExploration(s2));
        System.out.println("Original string: " + s3 + ". Changes: " + marsExploration(s3));
    }

    /**
     * O(n)
     * O(1)
     *
     * @param s
     * @return
     */
    public static int marsExploration(String s){
        if(s.length() < 3)
            throw new IllegalArgumentException("String must be at least 3 characters");

        int changed = 0;
        for (Character c : s.toCharArray()){ // O(n)
            if(Character.toLowerCase(c) != 's' && Character.toLowerCase(c) != 'o'){
                changed++;
            }
        }
        return changed;
    }
}
