import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {

        HashSet<Integer> pairXor = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                pairXor.add(nums[i]^nums[j]);
            }
        }

        for(int ele : pairXor){
            for(int num : nums){
                ans.add(ele^num);
            }
        }

        return ans.size();
        
    }
}