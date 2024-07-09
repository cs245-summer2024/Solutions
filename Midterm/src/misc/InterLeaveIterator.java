package misc;

import java.util.*;

/*
    Question 3:
 */
public class InterLeaveIterator implements Iterator<java.lang.Character> {

    private List<String> stringsToInterleave;
    private int stringIdx = 0;
    private int charIdx = 0;
    private int numStrings;
    private boolean[] haveCheckedString;
    public InterLeaveIterator(List<String> s) {
        stringsToInterleave = new ArrayList<>(s);
        numStrings = s.size();
        haveCheckedString = new boolean[numStrings];

        while(!haveVisitedAllStrings() && charIdx >= stringsToInterleave.get(stringIdx).length()) {
            haveCheckedString[stringIdx] = true;
            stringIdx = (stringIdx + 1) % numStrings;
        }
    }

    public boolean hasNext() {
        int nextstringIdx = stringIdx;
        boolean haveCycled = false;

        while(!haveCycled) {
            String nextCandidateString = stringsToInterleave.get(nextstringIdx % numStrings);
            if(charIdx < nextCandidateString.length()) {
                return true;
            }
            nextstringIdx = (nextstringIdx + 1) % numStrings;
            haveCycled = nextstringIdx == stringIdx;
        }
        return false;
    }

    public java.lang.Character next() {
        char toReturn = stringsToInterleave.get(stringIdx).charAt(charIdx);
        haveCheckedString[stringIdx] = true;
        stringIdx = (stringIdx + 1) % numStrings;

        while(!haveVisitedAllStrings() && charIdx >= stringsToInterleave.get(stringIdx).length()) {
            haveCheckedString[stringIdx] = true;
            stringIdx = (stringIdx + 1) % numStrings;
        }

        if(haveVisitedAllStrings()) {
            charIdx += 1;
            haveCheckedString = new boolean[numStrings];

            while(!haveVisitedAllStrings() && charIdx >= stringsToInterleave.get(stringIdx).length()) {
                haveCheckedString[stringIdx] = true;
                stringIdx = (stringIdx + 1) % numStrings;
            }
        }

        return toReturn;
    }

    private boolean haveVisitedAllStrings() {
        boolean haveCheckedAll = true;
        for(boolean b: haveCheckedString) {
            haveCheckedAll = haveCheckedAll && b;
        }
        return haveCheckedAll;
    }
}
