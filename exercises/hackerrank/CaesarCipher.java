package exercises.hackerrank;

public class CaesarCipher {
    public static void main(String[] args) {
        String s = "yxAbc";
//        String s = "middle-Outz";
//        String s = "www.abc.xy";
//        String s = "159357lcfd";
        int rotates = 2;
//        int rotates = 98;
        String encryptedString = caesarCipher(s, rotates);
        System.out.println("Original String: " + s + ". Encrypted: " + encryptedString);
    }

    /**
     * Encrypts a given string using the Caesar Cipher technique by rotating its letters
     * based on the provided rotation factor.
     *
     * <p><b>Big O Notation:</b>
     * <ul>
     *   <li><b>Time:</b> O(n) – Linear time due to a single pass through the string.</li>
     *   <li><b>Space:</b> O(n) – Linear space for the encrypted string.</li>
     * </ul>
     *
     * <p><b>Description:</b>
     * This method generates an encrypted version of the input string by shifting each alphabetical
     * character by a specified number of positions in the alphabet. The rotation wraps around
     * the alphabet using modulo arithmetic to ensure it stays within the 26-letter range.
     *
     * <p><b>Purpose:</b> Ensure the rotation wraps within the 26-letter alphabet.
     * <b>Strategy:</b> Calculate {@code k % 26} to get the effective rotation.
     *
     * <p><b>Example:</b>
     * <ul>
     *   <li>If {@code k = 27}, then {@code 27 % 26 = 1}, so rotate by 1.</li>
     *   <li>This prevents overshooting and maintains correct character shifting.</li>
     * </ul>
     *
     * <p>This approach ensures that any rotation value greater than 26 cycles back appropriately
     * within the alphabet range.
     *
     * <p><b>Steps:</b>
     * <ol>
     *   <li>If the string is null or empty, return an empty string.</li>
     *   <li>If the rotation is zero, return the original string.</li>
     *   <li>If the rotation is greater than the size of the alphabet, reset it using modulo.</li>
     *   <li>Create a {@code StringBuilder} initialized with the length of the original string.</li>
     *   <li>Iterate through each character in the string and perform the following:
     *     <ul>
     *       <li>If the character is a lowercase letter:
     *         <ol>
     *           <li>Calculate its index using {@code (value - 'a')}.</li>
     *           <li>Add the rotation value to this index.</li>
     *           <li>Apply modulo 26 to the result to ensure it wraps around the alphabet if necessary.
     *             <ul>
     *               <li>Example:
     *                 <ul>
     *                   <li>{@code newIndex = (122 - 97 + 1) % 26 = 26 % 26 = 0}</li>
     *                   <li>{@code newChar = (char) ('a' + 0) = 'a'}</li>
     *                 </ul>
     *               </li>
     *             </ul>
     *           </li>
     *           <li>Add this new index to 'a' to get the resulting new character.</li>
     *           <li>Append this new character to the encrypted string.</li>
     *         </ol>
     *       </li>
     *       <li>If the character is an uppercase letter:
     *         <ol>
     *           <li>Calculate its index using {@code (value - 'A')}.</li>
     *           <li>Add the rotation value to this index.</li>
     *           <li>Apply modulo 26 to the result to ensure it wraps around the alphabet if necessary.
     *             <ul>
     *               <li>Example:
     *                 <ul>
     *                   <li>{@code newIndex = (90 - 65 + 2) % 26 = 27 % 26 = 1}</li>
     *                   <li>{@code newChar = (char) ('A' + 1) = 'B'}</li>
     *                 </ul>
     *               </li>
     *             </ul>
     *           </li>
     *           <li>Add this new index to 'A' to get the resulting new character.</li>
     *           <li>Append this new character to the encrypted string.</li>
     *         </ol>
     *       </li>
     *       <li>If the character is neither uppercase nor lowercase, leave it unchanged.</li>
     *     </ul>
     *   </li>
     *   <li>Continue iterating through the string until the end.</li>
     *   <li>Return the new encrypted string.</li>
     * </ol>
     *
     * @param s the original string to be encrypted
     * @param k the number of positions to rotate each alphabetical character
     * @return the encrypted string after applying the Caesar Cipher
     */
    public static String caesarCipher(String s, int k) {
        if(s == null || s.isEmpty())
            return "";

        if(k <= 0)
            return s;

        // Original alphabet: abcdefghijklmnopqrstuvwxyz
        StringBuilder encryptedString = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if(Character.isLowerCase(value)){
                int index = value - 'a';
                int newIndex = (index + k) % 26;
                char newChar = (char) ('a' + newIndex);
                encryptedString.append(newChar);
            } else if(Character.isUpperCase(value)){
                int index = value - 'A';
                int newIndex = (index + k) % 26;
                char newChar = (char) ('A' + newIndex);
                encryptedString.append(newChar);
            } else {
                encryptedString.append(value);
            }
        }

        return encryptedString.toString();
    }

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(n), because we need to create a new string
     *
     *  Encrypt a given string generating another string as a result according to the number of rotates you received.
     *
     * @param s
     * @param k
     * @return encryptedString
     */
    public static String caesarCipher1(String s, int k) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string.");
        if(k == 0) return s;

        String originalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] charFrequencies = originalAlphabet.toCharArray();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);
            if(Character.isLetter(currentValue)){
                int currentIndex = Character.toLowerCase(currentValue) - 'a';
                int newIndex = (currentIndex + k) % originalAlphabet.length();

                char newValue = Character.isUpperCase(currentValue) ?
                        Character.toUpperCase(charFrequencies[newIndex]) : charFrequencies[newIndex];

                encryptedString.append(newValue);
            } else {
                encryptedString.append(currentValue);
            }
        }

        return encryptedString.toString();
    }

    public static String caesarCipher2(String s, int k) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string.");
        if(k == 0) return s;

        String originalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] charFrequencies = originalAlphabet.toCharArray();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);

            if(Character.isLetter(currentValue)){
                int currentIndex = Character.toLowerCase(currentValue) - 'a';
                int newIndex = currentIndex + k;
                int lastIndex = charFrequencies.length - 1;

                while(newIndex > lastIndex){
                    newIndex = (newIndex - lastIndex)-1;
                }

                char newValue = Character.isUpperCase(currentValue) ?
                        Character.toUpperCase(charFrequencies[newIndex]) : charFrequencies[newIndex];
                encryptedString.append(newValue);
            } else {
                encryptedString.append(currentValue);
            }
        }

        return encryptedString.toString();
    }

}
