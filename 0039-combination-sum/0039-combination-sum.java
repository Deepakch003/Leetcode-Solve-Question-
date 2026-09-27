class Solution {

    public static void comb(int cand [] , int i , int target , List<List<Integer>> ans , List<Integer> ds){

       if (target == 0) { 
        ans.add(new ArrayList<>(ds));
         return;
          } 
       
       
       if (i == cand.length) { 
        return;
        
         }


        if(cand[i]<=target){
            ds.add(cand[i]);
            comb(cand,i,target-cand[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        comb(cand,i+1,target,ans,ds);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        comb(candidates,0,target,ans,ds);
        return ans;
        
    }
}