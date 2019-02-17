public class Solution{	
	
  	public static int function(int n, int[] dp)
    {
      if(n==0 || n==1)
      {
        return 1;
      }
      
      if(dp[n]!=-1)
      {
        return dp[n];
      }
      
      int ans=0;
      
      for(int p=1;p<=n;p++)
      {
        long small=(long)1*function(p-1,dp)*function(n-p,dp);
        ans=(ans+(int)small%1000000007)%1000000007;
      }
      
      return dp[n]=ans;
      
    }
  
  
	public static int countTrees(int n) {
	/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
      int dp[]=new int[n+1];
      
      for(int i=0;i<=n;i++)
      {
        dp[i]=-1;
      }
      
      return function(n,dp);
		
	}
}
