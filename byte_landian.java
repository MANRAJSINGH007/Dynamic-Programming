
public class Solution {

    
	public static long bytelandian(long n){
		// Write your code here
        
        int dp[]=new int[(int)(n+1)];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[(int)i]=Math.max(i,dp[(int)(i/2)]+dp[(int)(i/3)]+dp[(int)(i/4)]);
        }
        
        return (int)dp[(int)n];

	}
}
