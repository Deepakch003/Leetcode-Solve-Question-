class Solution {
    public static void funct(int arr[] , int n , int k , int i,List<Integer> ds , List<List<Integer>>ans , int sz){
        
        if(sz==k){
            if(n==0){
            ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(i==arr.length || n<=0){
            return;
        }

        if(arr[i]<=n){
            ds.add(arr[i]);
            
            funct(arr,n-arr[i],k,i+1,ds,ans,sz+1);
            ds.remove(ds.size()-1);

        }
            funct(arr,n,k,i+1,ds,ans,sz);
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        int arr[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        funct(arr,n,k,0,ds,ans,0);
        return ans;
    }
}