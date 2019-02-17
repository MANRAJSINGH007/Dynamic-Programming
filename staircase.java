
public class Solution {
	
  public static long stair(int n, long[] dp)
  {
    if(n==1)
    {
      return 1;
    }

    if(n==2)
    {
      return 2;
    }

    if(n==3)
    {
      return 4;
    }

    if(dp[n]!=-1)
    {
      return dp[n];
    }

    return dp[n]=stair(n-1,dp)+stair(n-2,dp)+stair(n-3,dp);

  }
  
		
  public static long staircase(int n){

      /* Your class should be named Solution.
       * Don't write main() function.
       * Don't read input, it is passed as function argument.
       * Return output and don't print it.
       * Taking input and printing output is handled automatically.
       */
    long dp[]=new long[n+1];
    for(int i=0;i<=n;i++)
    {
      dp[i]=-1;
    }
    
    return stair(n,dp);

  }
	
}
