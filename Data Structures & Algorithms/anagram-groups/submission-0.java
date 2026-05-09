class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            String strHash = generateHash(str);
            if(map.containsKey(strHash)){
                map.get(strHash).add(str);
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(str);
            map.put(strHash, temp);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> pair: map.entrySet()){
            ans.add(pair.getValue());
        }
        return ans;
    }
    public String generateHash(String str){
        int[] arr = new int[26];
        for(char c: str.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder s = new StringBuilder();
        for(int x:arr){
            s.append("_"+x);
        }
        return s.toString();
    }
}
