import java.util.*;
public class Main {
    
    public static int func(int[] arr, int[] brr, int n, int m, int i, int j, int[][] dp)
    {
        if(i==n)
        {
            return 0;
        }
        
        if(j==m)
        {
            return Integer.MAX_VALUE;
            
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int c1=func(arr,brr,n,m,i+1,j+1,dp);
        int c2=func(arr,brr,n,m,i,j+1,dp);
        
        if(c1!=Integer.MAX_VALUE)
        {
            c1+=Math.abs(arr[i]-brr[j]);
        }
        
        return dp[i][j]=Math.min(c1,c2);
        
    }
    
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int arr[]=new int[n];
        int brr[]=new int[m];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        for(int i=0;i<m;i++)
        {
            brr[i]=sc.nextInt();
            
        }
        
        Arrays.sort(arr);
        Arrays.sort(brr);
        
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int p=0;p<m;p++)
            {
                dp[i][p]=-1;
            }
        }
        
        System.out.println(func(arr,brr,n,m,0,0,dp));

    }
}
