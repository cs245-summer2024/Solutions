package misc;

public class MT {
    /**
     * Question 1: Return a boolean indicating whether or not the robot can reach position
     * if following the instruction sequence.
     * @param s: A string cons
     * @param p
     * @return boolean
     */
    public static boolean canReach(String s, int p) {
        int direction = 1;
        int stepSize = 1;
        int position = 0;
        char prevDirection = 'F';

        for(char instruction: s.toCharArray()) {
            if(instruction == prevDirection) {
                position += stepSize * direction;
                stepSize *= 2;
            } else {
                direction *= -1;
                position += direction;

                stepSize = 2;
                prevDirection = instruction;
            }
        }

        return position == p;
    }

    /**
        Question 2:
     */
    public static void tilt(int[][] gameBoard) {
        int numRows = gameBoard.length;
        int numCols = gameBoard[0].length;
        for(int colIdx = 0; colIdx < numCols; colIdx ++) {
            tiltColumnUp(gameBoard, numRows, colIdx);
        }
    }

    public static void tiltColumnUp(int[][] gameBoard, int numRows, int colIdx) {
        int nextOpenRow = 0;
        for(int rowIdx = 1; rowIdx < numRows; rowIdx ++) {
            if(gameBoard[rowIdx][colIdx] != -1) {
                int tileNumber = gameBoard[rowIdx][colIdx];
                if(gameBoard[nextOpenRow][colIdx] == -1) { // open space
                    gameBoard[nextOpenRow][colIdx] = tileNumber;
                    gameBoard[rowIdx][colIdx] = -1;
                }else if(tileNumber == gameBoard[nextOpenRow][colIdx]) { // merge
                    gameBoard[nextOpenRow][colIdx] *= 2;
                    gameBoard[rowIdx][colIdx] = -1;
                    nextOpenRow += 1;
                } else { // No merge or open space
                    if(nextOpenRow + 1  < numRows) { // Required check to see if tile is moving
                        gameBoard[rowIdx][colIdx] = -1;
                        gameBoard[nextOpenRow + 1][colIdx] = tileNumber;
                        nextOpenRow += 1;
                    }
                }
            }
        }
    }

    /**
     * Question 4
     * @param A
     * @param B
     * @param C
     * @return
     */
    public static boolean correctSum(int[] A, int[] B, int[] C) {
        A = stripLeadingZeros(A);
        B = stripLeadingZeros(B);
        C = stripLeadingZeros(C);

        int lengthofA = A.length;
        int lengthofB = B.length;
        int lengthofC = C.length;
        int carryOver = 0;
        int aIdx = lengthofA - 1;
        int bIdx = lengthofB - 1;
        int cIdx = lengthofC - 1;

        // Can't add two positive numbers and get a shorter number
        if(lengthofC < Math.max(lengthofA, lengthofB)){
            return false;
        }

        while(aIdx >= 0 && bIdx >= 0) {
            int digitSum = A[aIdx] + B[bIdx] + carryOver;
            if(C[cIdx] != digitSum % 10) {
                return false;
            }
            carryOver = digitSum / 10;
            aIdx -= 1;
            bIdx -= 1;
            cIdx -= 1;
        }
        if(aIdx < 0 && bIdx < 0) {
            if(carryOver == 0) {
                return cIdx < 0;
            }
            return C[cIdx] == carryOver && cIdx == 0;
        }
        if(aIdx >= 0) {
            return handleRemainders(A, aIdx, C, cIdx, carryOver);
        }
        return handleRemainders(B, bIdx, C, cIdx, carryOver);
    }

    public static boolean handleRemainders(int[] operandArray, int opIdx, int[] resultArray, int resIdx, int carry) {
        while(opIdx >= 0) {
            int digitSum = operandArray[opIdx] + carry;
            if(resultArray[resIdx] != digitSum % 10) {
                return false;
            }
            carry = digitSum / 10;
            opIdx -= 1;
            resIdx -= 1;
        }

        if(carry == 0) {
            return resIdx < 0;
        }
        return resultArray[resIdx] == carry && resIdx == 0;
    }

    public static int[] stripLeadingZeros(int[] arrNumber) {
        int arrLen = arrNumber.length;
        int searchIdx = 0;
        while(searchIdx < arrLen && arrNumber[searchIdx] == 0) {
            searchIdx += 1;
        }
        if(searchIdx == arrLen) {
            int[] stripped = {0};
            return stripped;
        }

        int[] stripped = new int[arrLen - searchIdx];
        System.arraycopy(arrNumber, searchIdx, stripped, 0, arrLen - searchIdx);
        return stripped;
    }
}
