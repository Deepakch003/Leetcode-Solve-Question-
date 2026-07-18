class Solution {

    public static int gcd(int a , int b ){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];


        for(int i=1;i<nums.length;i++){
            max=Math.max(nums[i],max);
            min=Math.min(nums[i],min);
        }


        return gcd(min,max);
        
    }
}