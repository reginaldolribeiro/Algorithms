package exercises.practice;

public class TheTownJudge {
    public static void main(String[] args) {
//        int n = 3;
//        int[][] trust = {{1,3},{2,3}}; // output 3
//        int n = 3;
//        int[][] trust = {{1,2},{2,3}}; // output -1
        int n = 2;
        int[][] trust = {{1,2}}; // output 2
//        int n = 3;
//        int[][] trust = {{1,3},{2,3},{3,1}}; // output -1
//        int n = 0;
//        int[][] trust = {{1,3},{2,3},{3,1}}; // output -1
//        int n = 1;
//        int[][] trust = {{1,3},{2,3},{3,1}}; // output -1
//        int n = 1;
//        int[][] trust = {{1,2}}; // output -1
//        int n = 1;
//        int[][] trust = {}; // output 1
//        int n = 4;
//        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}}; // output 3
        int result = findJudge(n, trust);
        System.out.println(result);
//        for(int[] c : trust){
//            System.out.println(c[0] + " - " + c[1]);
//        }
    }

    /**
     * Identifies the town judge based on trust relationships.
     *
     * The town judge is defined as:
     * 1. A person who does not trust anyone (their trust count is 0).
     * 2. A person who is trusted by everyone else (trusted by exactly n-1 people).
     *
     * Algorithm:
     * 1. Validate the input:
     *    - If the trust array is null, throw an exception.
     *    - Handle special cases:
     *      - If `n == 1` and `trust` is empty, the only person is the judge.
     *      - If `n < 1`, return -1 (invalid case).
     * 2. Use two arrays to track trust relationships:
     *    - `regular`: Counts how many people each person trusts.
     *    - `judges`: Counts how many people trust each person.
     * 3. Iterate through the trust array:
     *    - Increment the `regular` count for the person who trusts (`first`).
     *    - Increment the `judges` count for the person being trusted (`second`).
     * 4. Identify the judge:
     *    - A person is the judge if:
     *      - Their `regular` count is 0 (does not trust anyone).
     *      - Their `judges` count is `n-1` (trusted by everyone else).
     * 5. Return the judge if found; otherwise, return -1.
     *
     * Big O Notation:
     * - Time Complexity: O(n + trust.length) — Traverses the trust array and checks the results.
     * - Space Complexity: O(n) — Uses two arrays of size `n` to track trust relationships.
     *
     * @param n     The number of people in the town.
     * @param trust The trust relationships represented as a 2D array.
     * @return The label of the town judge, or -1 if no judge exists.
     * @throws IllegalArgumentException If the trust array is null.
     */
    private static int findJudge(int n, int[][] trust){
        if(trust == null)
            throw new IllegalArgumentException("Invalid array");

        // Special cases: Single person with no trust relationships is the judge
        if(n == 1 && trust.length == 0)
            return n;

        if(n < 1) return -1; // Invalid case: No people in the town

        // Arrays to track trust relationships
        int[] regular = new int[n + 1]; // Tracks how many people each person trusts
        int[] judges = new int[n + 1]; // Tracks how many people trust each person

        // Process the trust array
        for (int[] line : trust) {
            int first = line[0];  // Person who trusts
            int second = line[1]; // Person being trusted
            regular[first]++;     // Increment trust count for the first person
            judges[second]++;     // Increment trust count for the second person
        }

        // Identify the judge
        for (int person = 1; person <= n; person++) {
            if(regular[person] == 0 && judges[person] == n-1)
                return person;
        }

        return -1; // No judge found
    }
}
