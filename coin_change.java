
public class Solution {

  	public static int function(int[] arr, int n, int i, int sum, int[][] dp)
    {
      if(i==n)
      {
        if(sum==0)
        {
          return 1;
        }
        
        return 0;
      }
      if(dp[i][sum]!=-1)
      {
        return dp[i][sum];
      }
      int curr=0;
      int ans=0;
      while(curr<=sum)
      {
        ans+=function(arr,n,i+1,sum-curr,dp);
        curr+=arr[i];
        
      }
      
      
      return dp[i][sum]=ans;
      
      
    }
	
	public static int countWaysToMakeChange(int denominations[], int value){

	
      int n=denominations.length;
      int dp[][]=new int[n][value+1];
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<=value;j++)
        {
          dp[i][j]=-1;
        }
      }
      
      
      return function(denominations,n,0,value,dp);

	}
	
}
