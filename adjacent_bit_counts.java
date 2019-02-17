import java.util.Scanner;

public class Main {

  	static int count=0;
  
  	public static int func(int n, int curr, int prev, int[][][] dp)
    {
      if(n==0)
      {
        if(curr==count)
        {
          return 1;
        }
        
        return 0;
        
      }
      
      if(dp[n][curr][prev]!=-1)
      {
        return dp[n][curr][prev];
        
      }
      
      if(prev==0)
      {
        int ways1=func(n-1,curr,1,dp);
        int ways2=func(n-1,curr,0,dp);
        long temp=(long)0+ways1+ways2;
        
        return dp[n][curr][prev]=(int)temp%1000000007;
        
      }
      
      else
      {
        int ways1=func(n-1,curr+1,1,dp);
        int ways2=func(n-1,curr,0,dp);
        long temp=(long)0+ways1+ways2;
        
        return dp[n][curr][prev]=(int)temp%1000000007;
        
      }
      
      
    }
  
	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      for(int q=0;q<t;q++)
      {
        int index=sc.nextInt();
        
        int n=sc.nextInt();
        
        int k=sc.nextInt();
        
        count=k;
        
        int dp[][][]=new int[n+1][n+1][2];
        
        for(int i=0;i<=n;i++)
        {
          for(int j=0;j<=n;j++)
          {
            for(int p=0;p<2;p++)
            {
              dp[i][j][p]=-1;
            }
          }
        }
        
        
        System.out.println((index)+" "+((long)0+func(n-1,0,0,dp)+func(n-1,0,1,dp))%1000000007);
        
      }
	}

}
