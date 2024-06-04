package hw1;
public class Main {
    /*
        5. Given a sorted array of integers, remove duplicate elements such that
        each element only appears one time. The relative ordering of the elements must stay
        the same.
     */

    /*
        Solution Explanation: Recall that the input array is sorted. That means
        that if we have duplicate elements, they are going to be next to each other.
        We maintain a variable (i.e insertionLocation) that stores where we will insert
        the next unique element we come across. Whenever we come across a new value, we
        set numbers[insertionLocation] to this new value and update this pointer.
     */
    public static void squishArray(int[] numbers){
        if(numbers == null || numbers.length <= 1) {
            return;
        }

        int arrLen = numbers.length;
        int insertionLocation = 1;
        int currentVal = numbers[0];
        for(int runnerIdx = 1; runnerIdx < arrLen; runnerIdx ++) {
            if(numbers[runnerIdx] != currentVal) {
                currentVal = numbers[runnerIdx];
                numbers[insertionLocation] = numbers[runnerIdx];
                insertionLocation += 1;
            }
        }
        for(; insertionLocation < arrLen; insertionLocation ++) {
            numbers[insertionLocation] = -1;
        }
    }

    /*
        6. Strings can have runs of characters, where consecutive elements are repeated.
        To generate a compressed string, we first count how many times a character is repeated.
        Then, we add this count followed by the character to our compressed string. For example,
        we can compress "aaabbcaad" to "3a2b1c2a1d".
     */
    public static String compressString(String s){
        if(s == null){
            return "";
        }
        StringBuilder compressionBuilder = new StringBuilder();
        int stringLength = s.length();

        char currentChar = s.charAt(0);
        int runLength = 1;
        for(int sIdx = 1; sIdx < stringLength; sIdx ++){
            if (s.charAt(sIdx) == currentChar){
                runLength += 1;
            } else {
                compressionBuilder.append(runLength);
                compressionBuilder.append(currentChar);
                currentChar = s.charAt(sIdx);
                runLength = 1;
            }
        }
        compressionBuilder.append(runLength);
        compressionBuilder.append(currentChar);
        return compressionBuilder.toString();
    }

}
