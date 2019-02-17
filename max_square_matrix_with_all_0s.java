
public class Solution {
	
	public static int findMaxSquareWithAllZeros(int[][] arr){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
      
      int n=arr.length;
      int m=arr[0].length;
      int max=0;
      
      int dp[][]=new int[n][m];
      
      for(int i=0;i<m;i++)
      {
        if(arr[0][i]==0)
        {
          dp[0][i]=1;
          max=1;
        }
        
      }
      
      for(int i=0;i<n;i++)
      {
        if(arr[i][0]==0)
        {
          dp[i][0]=1;
          max=1;
        }
        
      }
      
      for(int i=1;i<n;i++)
      {
        for(int k=1;k<m;k++)
        {
          if(arr[i][k]==0)
          {
          	int min=Math.min(dp[i-1][k],Math.min(dp[i-1][k-1],dp[i][k-1]));
            min++;
            dp[i][k]=min;
            if(min>max)
            {
              max=min;
            }  
          }
          
          
        }
        
      }
      
      return max;
      

	}

	
}
