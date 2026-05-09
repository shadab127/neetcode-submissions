class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set myset = new HashSet<>();
        for(int num: nums){
            if(myset.contains(num)){
                return true;
            }
            myset.add(num);
        }
        return false;
    }
}