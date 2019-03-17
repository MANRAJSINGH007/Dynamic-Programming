public class Solution {
    
    public static int func(String str, int n, int i, int j, int[][] dp){
        
        if(i==n || j==n){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(i==j){
            return dp[i][j]=Math.max(func(str,n,i+1,j,dp),func(str,n,i,j+1,dp));
        }
        
        if(str.charAt(i)==str.charAt(j)){
            return dp[i][j]=1+func(str,n,i+1,j+1,dp);
        }
        
        return dp[i][j]=Math.max(func(str,n,i+1,j,dp),func(str,n,i,j+1,dp));
        
        
    }
    
    public int anytwo(String str) {
        
        int n=str.length();
        
        int dp[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
            
        }
        
        if(func(str,n,0,0,dp)>=2){
            return 1;
        }
        
        return 0;
    
    }
}
