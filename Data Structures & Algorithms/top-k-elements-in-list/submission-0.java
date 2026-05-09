class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int num: nums){
            if(myMap.containsKey(num)){
                myMap.put(num, myMap.get(num)+1);
            }
            else{
                myMap.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: myMap.entrySet()){
            q.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        int i = 0;
        while(!q.isEmpty() && i<k){
            ans[i] = q.poll()[0];
            i++;
        }
        return ans;
    }
}
