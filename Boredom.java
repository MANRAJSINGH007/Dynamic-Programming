import java.util.*;
public class solution {
  	
  	
	public int solve(int n,int arr[])
	{
      
      int freq[]=new int[1001];
      for(int i=0;i<n;i++)
      {
        freq[arr[i]]++;
      }
      
      int dp[]=new int[1001];
      dp[1]=freq[1];
      for(int i=2;i<=1000;i++)
      {
        int m1=dp[i-1];
        int m2=dp[i-2]+freq[i]*i;
        if(m1>m2)
        {
          dp[i]=m1;
        }
        else
        {
          dp[i]=m2;
        }
      }
      
      return dp[1000];
      
	}
}
