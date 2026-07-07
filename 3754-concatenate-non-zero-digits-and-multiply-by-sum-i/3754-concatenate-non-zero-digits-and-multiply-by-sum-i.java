class Solution {
    public long sumAndMultiply(int n) {
        int xrev=0;
        long sum=0;
        int x=0;

        while(n>0){
            int last = n%10;
            if(last!=0){

                 xrev=xrev*10+last;
                 sum+=last;

            }
            n=n/10;
        }

        while(xrev>0){
            int last1=xrev%10;
            x=x*10+last1;
            xrev=xrev/10;


        }

       return x*sum;
        
        
    }
}