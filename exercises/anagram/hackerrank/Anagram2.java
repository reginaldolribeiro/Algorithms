package exercises.anagram.hackerrank;

public class Anagram2 {
    /*public static void main(String[] args) {
        int x = 20;
        int divided = x/2;
        System.out.println(divided);

        System.out.println("Resto da divisao de " + x + " por 2: " + x % 2);
    }*/

    public static void main(String[] args) {
//        String s = "aaaaaa";
//        String s = "aaabbb";
//        String s = "abccde";
//        String s = "ab";
        String s = "abc";
//        String s = "mnop";
//        String s = "xyyx";
//        String s = "xaxbbbxx";
//        String s = "vakhotzflsuglmkrxowvqrbaegxskgghgrpwmodzjafwornlhlgydjajrybeehlmaajoroncouyconnvywtdfumzsndyxokzrvqkkfoaamdqbslzoffwbtvvjatiqfhjbztnfjnhvsxwliyzpfxqyunjuirnobwrasehbtozmlvxuvylawebsr";
        int changes = anagram(s);
        if(changes >= 0){
            System.out.println("We need " + changes + " changes to make an anagram");
        } else {
            System.out.println("It's not possible to make an Anagram!");
        }
    }

    public static int anagram(String s){
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("String must not be null");

        // If the rest of the division is not zero, it's impossible
        if(s.length()%2 != 0)
            return -1;

        char firstLetter = s.charAt(0);
        boolean sameCharacter = true;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != firstLetter){
                sameCharacter = false;
                break;
            }
        }

        // String with same letters
        if(sameCharacter)
            return 0;

        int middle = s.length()/2;
        String firstString = s.substring(0, middle);
        String secondString = s.substring(middle);

        int[] charFrequencies = new int[26];
        for (int i = 0; i < firstString.length(); i++) {
            int value = firstString.charAt(i);
            int index = value - 'a';
            charFrequencies[index]++;
        }

        for (int i = 0; i < secondString.length(); i++) {
            int value = secondString.charAt(i);
            int index = value - 'a';
            charFrequencies[index]--;
        }

        int changes = 0;
        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] > 0)
                changes += charFrequencies[i];
        }

        return changes;
    }
}
