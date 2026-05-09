class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] numsLeft = new int[n];
        int[] numsRight = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                numsLeft[0] = nums[i];
                numsRight[n-1] = nums[n-1];
            }
            else if(i==n-1){
                numsLeft[n-1] = numsLeft[n-2]*nums[n-1];
                numsRight[0] = numsRight[1]*nums[0];
            }
            else{
                numsLeft[i] = nums[i] * numsLeft[i-1];
                numsRight[n-i-1] = nums[n-i-1] * numsRight[n-i];
            }
        }
        int[] productArr = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                productArr[0] = numsRight[i+1];
            }
            else if(i+1 == n){
                productArr[n-1] = numsLeft[n-2];
            }
            else{
                productArr[i]= numsLeft[i-1]*numsRight[i+1];
            }
        }
        return productArr;
    }
}  
