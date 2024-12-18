package exercises.others;

public class CountChar {
    public static void main(String[] args) {

        String originalString = "geeksforgeeks";
        char stringToCount = 'e';

        System.out.println("Original String: " + originalString);
        int result = countString(originalString, stringToCount);

        System.out.println("The quantity of letter " + stringToCount + " in " + originalString + " is " + result);
    }

    private static int countString(String originalString, char stringToCount) {
        int count = 0;
        for(char c : originalString.toCharArray()){
            if(c == stringToCount)
                count++;
        }
        return count;
    }


}
