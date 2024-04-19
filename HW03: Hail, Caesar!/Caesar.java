/**
* Name: Caroline Begg
* Pennkey: cbegg
* Execution:
*       to encrypt: java Caesar encrypt plaintext.txt G
*       to decrypt: java Caesar decrypt cipher.txt G
*       to crack: java Caesar crack cipher.txt english.txt
*
* Program Description: create a program that can encrypt a message, decrypt a
* message, and crack a coded message with a brute force attack.
*/

public class Caesar {
    
    /* String to Symbol Array Function
    * Description: converts a string to a symbol array,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  the message text to be converted
    * Output: integer encoding of the message
    */
    
    public static int[] stringToSymbolArray(String str) {
        str = str.toUpperCase();
        int[] text = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            char charStrToSym = str.charAt(i);
            text[i] = (int) charStrToSym - 'A';
        }
        return text;
    }
    
    /* Symbol Array to String Function
    * Description: converts an array of symbols to a string,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  integer encoding of the message
    * Output: the message text
    */
    public static String symbolArrayToString(int[] symbols) {
        String numsToText = "";
        
        for (int i = 0; i < symbols.length; i++) {
            numsToText += (char) (symbols[i] + 'A');
        }
        return numsToText;
    }
    
    /* Shift Function
    * Description: shifts the value of a character based on the provided key
    * Input:  the character, how much it should be shifted by
    * Output: the shifted character
    */
    public static int shift(int symbol, int offset) {
        int shiftedPosition = symbol;
        
        if (shiftedPosition >= 0 && shiftedPosition <= 25) {
            if ((shiftedPosition + offset) >= 26) {
                shiftedPosition = (shiftedPosition + offset) % 26;
            }
            else {
                shiftedPosition = shiftedPosition + offset;
            }
        }
        else {
            return shiftedPosition;
        }
        
        return shiftedPosition;
    }
    
    /* Unshift Function
    * Description: unshifts the value of a chracter based on the provided key
    * Input: the character, how much it should be unshifted by
    * Output: the unshifted character
    */
    
    public static int unshift(int symbol, int offset) {
        int unshiftedPosition = symbol;
        if (unshiftedPosition >= 0 && unshiftedPosition <= 25) {
            if ((unshiftedPosition - offset + 26) >= 26) {
                unshiftedPosition = (unshiftedPosition - offset + 26) % 26;
            }
            else {
                unshiftedPosition = unshiftedPosition - offset + 26;
            }
        }
        else {
            return unshiftedPosition;
        }
        return unshiftedPosition;
    }
    
    /* Encryption Function
    * Inputs: the unhidden message, the encryption key
    * Outputs: encrypted message
    * Description: uses a given key to encrypt a message
    */
    
    public static String encrypt(String message, int key) {
        String cipherText = "";
        int[] encryptedArr = stringToSymbolArray(message);
        
        for (int i = 0; i < encryptedArr.length; i++) {
            encryptedArr[i] = shift(encryptedArr[i], key);
        }
        cipherText = symbolArrayToString(encryptedArr);
        return cipherText;
    }
    
    /* Decryption Function
    * Inputs: the encrypted message, the decryption key
    * Outputs: the secret message
    * Description: uses a given key to decrypt a message
    */
    
    public static String decrypt(String cipher, int key) {
        String plainText = "";
        int[] decryptedArr = stringToSymbolArray(cipher);
        
        for (int i = 0; i < decryptedArr.length; i++) {
            decryptedArr[i] = unshift(decryptedArr[i], key);
        }
        plainText = symbolArrayToString(decryptedArr);
        return plainText;
    }
    
    /* Get Dictionary Frequencies Function
    * Inputs: name of the file containing the dictionary frequencies of english
    letters
    * Outputs: array containing the numeric dictionary frequency of each letter
    * Description: reads a text file containing numeric frequency values for
    english letters and stores them as doubles in an array
    */
    
    public static double[] getDictionaryFrequencies(String filename) {
        In inStream = new In(filename);
        double[] dicFreq = new double[26];
        for (int i = 0; i < 26; i++) {
            dicFreq[i] = inStream.readDouble();
        }
        return dicFreq;
    }
    
    /* Calculate Letter Frequencies Within the Text Function
    * Inputs: int array containing the chars from the ciphertext as ints
    * Outputs: double containing the frequencies of the characters in the text
    * Description: reads an array of integers to determine how many times a
    given character appears in array and then divides by the
    total number of characters to find the frequency of that char
    */
    
    public static double[] findFrequencies(int[] symbols) {
        double total = 0.0;
        double[] ciphFreq = new double[26];
        for (int i = 0; i < ciphFreq.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j] >= 0 && symbols[j] <= 25) {
                    if (symbols[j] == i) {
                        total = total + 1;
                        ciphFreq[i] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            ciphFreq[i] = ciphFreq[i] / total;
        }
        return ciphFreq;
    }
    
    /* Comparing Frequencies From Dictionary and Text Function
    * Inputs: a double array containing the dictionary frequencies of letters in
    the english language and a double array containing the frequencies
    of the letters in the ciphertext
    * Outputs: total frequency score of a given encrypted text string
    * Description: scores the frequencies of these two arrays by subtracting them
    from one another and then adding their absolute values in order
    to create a total score for the string
    */
    public static double scoreFrequencies(double[] english, double[] currentFreqs) {
        double freqScore = 0.0;
        for (int i = 0; i < english.length; i++) {
            freqScore = Math.abs(english[i] - currentFreqs[i]);
            freqScore += freqScore;
        }
        return freqScore;
    }
    
    /* Crack Function
    * Inputs: string of encoded text
    * Outputs: decoded string
    * Description: uses a brute force attack to crack an ecrypted string without a
    key. decrypts the string with all keys A-Z, tests their
    frequencies, and then compares them to see which has the lowest
    frequency score.
    */
    public static String crack(String ciphText, String engFreqFile) {
        double minScore = 100;
        int correctKey = 0;
        
        for (int key = 0; key < 25; key++) {
            String decryptedText = decrypt(ciphText, key);
            int[] storeDecryps = stringToSymbolArray(decryptedText);
            double[] freqOfStoredDecrypts = findFrequencies(storeDecryps);
            double[] engFreq = getDictionaryFrequencies(engFreqFile);
            double comparedScores = scoreFrequencies(engFreq, freqOfStoredDecrypts);
            
            if (comparedScores < minScore) {
                minScore = comparedScores;
                correctKey = key;
            }
        }
        String crackCode = decrypt(ciphText, correctKey);
        
        return crackCode;
    }
    
    public static void main(String[] args) {
        String whichFunction = args[0];
        
        if (whichFunction.equals("encrypt")) {
            String filename = args[1];
            int letterKey = (int) args[2].charAt(0) - 'A';
            
            In inStream = new In(filename);
            String message = inStream.readAll();
            String cipher = encrypt(message, letterKey);
            System.out.println(cipher);
        }
        
        if (whichFunction.equals("decrypt")) {
            String filename = args[1];
            int letterKey = (int) args[2].charAt(0) - 'A';
            
            In inStream = new In(filename);
            String cipher = inStream.readAll();
            String message = decrypt(cipher, letterKey);
            System.out.println(message);
        }
        
        if (whichFunction.equals("crack")) {
            String filenameOne = args[1];
            String filenameTwo = args[2];
            
            In inStream = new In(filenameOne);
            String freqText = inStream.readAll();
            
            String crackedCode = crack(freqText, filenameTwo);
            System.out.println(crackedCode);
        }
    }
}
