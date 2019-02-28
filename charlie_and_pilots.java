import java.util.Scanner;

public class Main {

    public static int func(int[] arr, int[] brr, int n, int i, int c1, int[][] dp){
        
        if(i==n){
            return 0;
        }
        
        if(dp[i][c1]!=-1){
            return dp[i][c1];
        }
        
        if(c1==0){    
            return dp[i][c1]=brr[i]+func(arr,brr,n,i+1,1,dp);
        }
        
        if(n-i==c1){
            return dp[i][c1]=arr[i]+func(arr,brr,n,i+1,c1-1,dp);
        }
        
        int cost1=brr[i]+func(arr,brr,n,i+1,c1+1,dp);
        int cost2=arr[i]+func(arr,brr,n,i+1,c1-1,dp);
        
        return dp[i][c1]=Math.min(cost1,cost2);
        
        
    }
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int captain[]=new int[n];
        int assistant[]=new int[n];
        
        for(int i=0;i<n;i++){
            captain[i]=sc.nextInt();
            assistant[i]=sc.nextInt();
            
        }
        
        int dp[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        
        System.out.println(func(captain,assistant,n,0,0,dp));

	}

}
