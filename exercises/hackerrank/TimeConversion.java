package exercises.hackerrank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static void main(String[] args) {
        String inputTime = "09:05:45AM";

        String convertedTime = timeConversion(inputTime);
        System.out.println("Converted time: " + convertedTime);

        String convertedTime1 = timeConversion(inputTime);
        System.out.println("Converted time: " + convertedTime1);
    }

    public static String timeConversion(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
        if (s.contains("AM")) {
            return LocalTime.parse(s, formatter).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        if (s.contains("PM")) {
            return LocalTime.parse(s, formatter).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        return s; // Return original string if neither AM nor PM
    }


    public static String timeConversion1(String s) {
        if(s.contains("AM")){
            return s.replace("AM","");
        }
        if(s.contains("PM")){
            LocalTime localTime = LocalTime.parse(s.replace("PM",""), DateTimeFormatter.ISO_TIME)
                    .plusHours(12);
            return localTime.toString();
        }
        return s;
    }
}
