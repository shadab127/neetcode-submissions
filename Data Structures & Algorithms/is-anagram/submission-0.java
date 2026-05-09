class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for(char c: s.toCharArray()){
            countS[c-'a']++;
        }
        for(char c: t.toCharArray()){
            countT[c-'a']++;
        }
        return checkAnagram(countS, countT);
    }
    public boolean checkAnagram(int[] s, int[] t){
        for(int i=0;i<26;i++){
            if(s[i] != t[i]){
                return false;
            }
        }
        return true;
    }
}
