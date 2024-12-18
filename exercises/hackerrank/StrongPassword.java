package exercises.hackerrank;

import java.util.Set;

public class StrongPassword {
    public static void main(String[] args) {
//        String input = "#Hackerrank";
//        String input = "4700";
        String input = "&+^&";

//        strongPasswordWithRegex();

        int value = strongPassword(input);
        System.out.println("Quantidades de caracteres faltantes " + value);

    }

    private static int strongPassword(String password) {
        int countUpperCase = 0, countLowerCase = 0, countNumber = 0, countSymbol = 0;
        Set<String> symbols = Set.of("!", "@", "#", "$", "%","^","&","*","(",")","-","+");

        for (char c : password.toCharArray()){
            if(Character.isUpperCase(c)) countUpperCase++;
            if(Character.isLowerCase(c)) countLowerCase++;
            if(Character.isDigit(c)) countNumber++;
            if(symbols.contains(c)) countSymbol++;
        }

        int missingTypes = 0;
        if(countUpperCase == 0) missingTypes++;
        if (countLowerCase == 0) missingTypes++;
        if (countSymbol == 0) missingTypes++;
        if(countNumber == 0) missingTypes++;

        int minLengthNeeded = 6;
        int missingLength = minLengthNeeded - password.length();

        if(password.length() >= minLengthNeeded){
            return missingTypes;
        } else if(missingTypes > missingLength){
            return missingTypes;
        } else {
            return missingLength;
        }
    }

    private static int strongPassword1(String password) {
        int countUpperCase = 0, countLowerCase = 0, countNumber = 0, countSymbol = 0;
        Set<String> stringSet = Set.of("!", "@", "#", "$", "%","^","&","*","(",")","-","+");

        for (int i = 0; i < password.length(); i++) {
            char value = password.charAt(i);
            if(Character.isUpperCase(value))
                countUpperCase++;
            if (Character.isLowerCase(value))
                countLowerCase++;
            if (stringSet.contains(String.valueOf(value)))
                countSymbol++;
            if(Character.isDigit(value))
                countNumber++;
        }

        int missingTypes = 0;
        if(countUpperCase == 0){
            missingTypes++;
            System.out.println("Missing Upper case");
        }
        if (countLowerCase == 0){
            missingTypes++;
            System.out.println("Missing Lower case");
        }
        if (countSymbol == 0){
            missingTypes++;
            System.out.println("Missing symbol");
        }
        if(countNumber == 0){
            missingTypes++;
            System.out.println("Missing number");
        }

        int minLengthNeeded = 6;
        int missingLength = minLengthNeeded - password.length();
        if(password.length() >= minLengthNeeded){
            return missingTypes;
        } else if(missingTypes > missingLength){
            return missingTypes;
        } else {
            return missingLength;
        }
    }


//    private static boolean isInteger(String value) {
//        if(value == null)
//            return false;
//        try{
//            int anInt = Integer.parseInt(value);
//            return true;
//        } catch (NumberFormatException e){
//            return false;
//        }
//    }



    private static void strongPasswordWithRegex() {
        String regex = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[0-9])(?=.*[!@#$%^&*()-+ ]).{6,}$";

//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);

//        boolean matches = input.matches(regex);
//        if(matches){
//            System.out.println("Strong password");
//        }else{
//            System.out.println("The password is not strong!");
//        }
    }


}
