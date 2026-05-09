class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String str: strs){
            sb.append(str.length()+"");
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] charStr = str.toCharArray();
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<charStr.length){
            sb = new StringBuilder();
            while(charStr[i] != '#'){
                sb.append(charStr[i]);
                i++;
            }
            i++;
            int length = Integer.valueOf(sb.toString());
            sb = new StringBuilder();
            while(length > 0){
                sb.append(charStr[i]);
                i++;
                length--;
            }
            
            ans.add(sb.toString());
        }
        return ans;
    }
}
