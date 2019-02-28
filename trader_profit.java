import java.util.Scanner;

public class Main {

	public static int func(int[] arr, int n, int i, int k, int[][] dp){
        
        if(k==0 || i>=n-1){
            return 0;
        }
        
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        
        int max=func(arr,n,i+1,k,dp);
        
        for(int j=i+1;j<n;j++){
            
            if(arr[j]>arr[i]){
                int x2=arr[j]-arr[i]+func(arr,n,j+1,k-1,dp);
                max=Math.max(x2,max);
            }
            
        }
        
        return dp[i][k]=max;
        
        
    }	
  
  
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int q=sc.nextInt();
      
      for(int j=0;j<q;j++){
        
        int k=sc.nextInt();
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
        }
        
        int dp[][]=new int[n][k+1];
          
        for(int i=0;i<n;i++){
            for(int p=0;p<=k;p++){
                dp[i][p]=-1;
            }
        }
          
        System.out.println(func(arr,n,0,k,dp));
        
      }

	}

}
