import java.util.*;
public class Main {
   
    public static void main (String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        
        long dp[][]=new long[n+1][2];
        
        dp[1][0]=0;
        dp[1][1]=k-1;
        
        for(int i=2;i<=n;i++)
        {
            dp[i][0]=dp[i-1][1];
            dp[i][1]=(k-1)*(dp[i-1][0]+dp[i-1][1]);
            
        }
        
        System.out.println(dp[n][0]+dp[n][1]);

    }
}
