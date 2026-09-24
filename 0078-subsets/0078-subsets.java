class Solution {

    public static void subset1(int [] nums , List<Integer> ans , int i,List<List<Integer>> main){
        if(i==nums.length){
          main.add(new ArrayList<>(ans));

            return;
        }
        ans.add(nums[i]);
        subset1(nums,ans,i+1,main);

        ans.remove(ans.size()-1);

        subset1(nums,ans,i+1,main);

           
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        subset1(nums,ans,0,main);

        return main;


        
    }
}