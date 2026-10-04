class Solution {

    public static void subSet1(int arr[], int ind, List<Integer> ds, List<List<Integer>> ans) {
        
        ans.add(new ArrayList<>(ds));
        
    for(int i=ind;i<arr.length;i++){
       if(i!=ind && arr[i]==arr[i-1]) continue;
       ds.add(arr[i]);
       subSet1(arr,i+1,ds,ans);
       ds.remove(ds.size()-1);
    }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

      
        subSet1(nums, 0, ds, ans);

        return ans;
    }
}