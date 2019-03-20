
public class solution {
	
    public static long func(int[][] like, int n, int[] visited, int i, long[] dp){
        
        if(i==n){
            return 1;
        }
        
        int mask=0;
        for(int k=0;k<n;k++){
            if(visited[k]==1)
                mask+=(int)Math.pow(2,k);
        }
        
        if(dp[mask]!=-1){
            return dp[mask];
        }
        
        long ans=0;
        
        for(int k=0;k<n;k++){
            if(visited[k]==0 && like[i][k]==1){
                
                visited[k]=1;
                ans+=func(like,n,visited,i+1,dp);
                visited[k]=0;
                
            }
        }
        
        return dp[mask]=ans;
        
    }
    
    
    
	long solve(int[][] like,int n){
		
		//Write your code here.
        long dp[]=new long[(int)Math.pow(2,n)];
        
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        
        int visited[]=new int[n];
        
        return func(like,n,visited,0,dp);
		
	}
	
}
