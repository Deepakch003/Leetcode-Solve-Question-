class Solution {
    public static void func(String s , int ind , List<String> ds , List<List<String>> ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<s.length();++i){
            if(ispalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                func(s,i+1,ds,ans);
                ds.remove(ds.size()-1);
            }
        }
    }


    public static boolean ispalindrome(String s , int start , int end){
        while(start<=end){
            if(s.charAt(start++)!= s.charAt(end--)){
                return false;
            }


        }
        return true;
    }
    public List<List<String>> partition(String s) {

        List<String> ds = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        func(s,0,ds,ans);
        return ans;
        
    }
}