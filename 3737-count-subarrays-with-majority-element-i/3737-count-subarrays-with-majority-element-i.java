class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
         int ans =0;

         int len =0;
          int sim =0;
         int n = nums.length;
          for( int num : nums){
        if(num==target){
            sim++;
        }
       }

       if(n==sim){
        return (n*(n+1)/2);
       }

      // return 0;

         for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    count++;
                }
                len=j-i+1;

                if(count*2>len){
                    ans++;
                }
            }
         } 
        

      

      return ans;


    }
}