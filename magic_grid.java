import java.util.Scanner;

public class Main {

  	public static int func(int[][] arr , int n, int m, int i, int j, int[][] dp)
    {
      if(i==n || j==m)
      {
        return Integer.MAX_VALUE;
      }
      
      if(i==n-1 && j==m-1)
      {
        if(arr[i][j]>0)
        {
          return 0;
        }
        
        return dp[i][j]=1-arr[i][j];
        
      }
      
      if(dp[i][j]!=-1)
      {
        return dp[i][j];
      }
      
      int m1=0;
      int m2=0;
      
      m1=func(arr,n,m,i+1,j,dp);
      m2=func(arr,n,m,i,j+1,dp);
      
      int ans=Math.min(m1,m2);
      
      if(ans==0)
      {
        if(arr[i][j]>0)
        {
          return dp[i][j]=0;
        }
        
        return dp[i][j]=1-arr[i][j];
        
      }
      
      if(arr[i][j]<=0)
      {
        return dp[i][j]=-arr[i][j]+ans;
        
      }
      
      if(arr[i][j]>=ans)
      {
        return dp[i][j]=0;
      }
      
      return dp[i][j]=ans-arr[i][j];
      
    }
  
	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      
      for(int j=0;j<t;j++)
      {
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        int dp[][]=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
          for(int k=0;k<m;k++)
          {
            arr[i][k]=sc.nextInt();
            dp[i][k]=-1;
          }
        }

        System.out.println(func(arr,n,m,0,0,dp));
        
        /*for(int i=0;i<n;i++)
        {
          for(int k=0;k<m;k++)
          {
            System.out.print(dp[i][k]+" ");
          }
          System.out.println();
          
        }
        System.out.println();
        */
        
      }

	}

}
