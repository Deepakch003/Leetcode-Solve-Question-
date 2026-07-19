class Solution {
    public String smallestSubsequence(String s) {

        int last[] = new int[26];

        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }

        boolean visit[] = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(visit[ch-'a']){
                continue;
            }

            while(!st.isEmpty()&& st.peek()>ch && last[st.peek()-'a']>i){
                visit[st.pop()-'a']=false;
            }

            st.push(ch);
            visit[ch-'a']=true;


        }

        StringBuilder ans = new StringBuilder();

        for(char ch :st){
            ans.append(ch);
        }

        return ans.toString();
    }
}