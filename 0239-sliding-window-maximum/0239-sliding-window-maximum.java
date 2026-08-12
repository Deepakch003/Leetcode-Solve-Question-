class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();

        int [] ans = new int[n-k+1];

        int p=0;

        for(int i=0;i<k;i++){
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }


        for(int i=k;i<nums.length;i++){
            ans[p++]=nums[dq.peekFirst()];

            while(dq.size()>0 && dq.peekFirst()<=i-k)
            {
                dq.removeFirst();
            }

             while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

        }

        ans[p++]=nums[dq.peekFirst()];
        return ans;
        
    }
}