/*
    Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

    You may assume the integer do not contain any leading zero, except the number 0 itself.

    The digits are stored such that the most significant digit is at the head of the list.

    Ex: [9,9] --> [1,0,0]
*/

class Solution {
    public int[] plusOne(int[] digits) {
        boolean plusOneCheck = plusOneRec(digits, digits.length-1, false);
        if(!plusOneCheck)
            return digits;

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i = 1; i < digits.length; i++)
            newDigits[i] = digits[i-1];
        return newDigits;
    }
    
    private boolean plusOneRec(int[] digits, int i, boolean carryOne){
        if(i >= 0){
            if(digits[i] == 9){
                digits[i] = 0;
                carryOne = plusOneRec(digits, i-1, true);
            }else{
                digits[i]++;
                return false;
            }
        }
        return carryOne;
    }
}

