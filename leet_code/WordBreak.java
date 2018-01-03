/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".


*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return forwards(s, wordDict);
        
    }
    
    private boolean forwards(String s, List<String> wordDict){
        System.out.println("\n---- START s: " + s);
        if(s.length() == 0)
            return true;
        
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            temp += s.charAt(i);
            System.out.println(temp);
            if(wordDict.contains(temp)){
                boolean check = forwards(s.substring(temp.length()), wordDict);
                if(check)
                    return true;
                System.out.println("s:" + s);
            }
            
        }
        return false;
    }
}
