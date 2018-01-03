/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
    public String decodeString(String s) {
        String ret = "";
        for(int i = 0; i < s.length(); i ++){
            if(Character.isDigit(s.charAt(i))){
                String toCompress = matchBrackets(s.substring(i));
                String decompressed = decompRec(toCompress);
                ret += decompressed;
                i += toCompress.length()-1;
            }else
                ret += s.charAt(i);
            System.out.println("ret:" + ret);
        }
        return ret;

    }
               
    private String matchBrackets(String s){
        int count = 0;
        boolean hasBrackets = false;
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            ret += s.charAt(i);
            if(s.charAt(i) == '['){
                count++;
                hasBrackets = true;
            }
            if(s.charAt(i) == ']')
                count--;
            if(count == 0 && hasBrackets)
                break;
        }
        return ret;
    }
                                
    private String decompRec(String s){
        System.out.println("s: " + s);
        int num = Integer.parseInt(s.substring(0, s.indexOf("[")));
        String ret = "";
        // number of times to print out pattern
        for(int i = 0; i < num; i++){
             // iterate through actual pattern
            for(int k = s.indexOf('[')+1; k < s.length(); k++){
                if(s.charAt(k) == ']' || s.charAt(k) == '[')
                    continue;
                else if(Character.isDigit(s.charAt(k))){
                    String toComp = matchBrackets(s.substring(k));
                    String temp = decompRec(toComp);
                    ret += temp;
                    k += toComp.length()-1;
                }else
                    ret += s.charAt(k);
            }
            System.out.println("rec ret:" + ret);
        }
        return ret;
    }

}
