package exercises.hackerrank;

import java.util.Arrays;

public class CamelCase {
    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        int words = camelcase(s);
        System.out.println("Quantity of words " + words);
    }


    private static int camelcase(String s){
        return s.split("[A-Z]").length; // not include upper case letters
//        return s.split("(?=[A-Z])").length; // include upper case letters
    }

    private static int camelcase2(String s){
        int count = 1; // starts with 1 because the first word isn't UpperCase
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                count++;
            }
        }
        return count;
    }
}
