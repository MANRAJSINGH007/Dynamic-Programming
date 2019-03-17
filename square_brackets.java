import java.util.Scanner;

public class Main {

	public static int func(int opening, int i, int[] index, int n, int[][] dp){
        
        if(i==2*n){
            
            if(opening==0){
                return 1;
            }
            
            return 0;
        }
        
        if(dp[opening][i]!=-1){
            return dp[opening][i];
        }
        
        if(opening==0 || index[i]==1){
            
            return dp[opening][i]=func(opening+1,i+1,index,n,dp);
        }
        
        return dp[opening][i]=func(opening+1,i+1,index,n,dp)+func(opening-1,i+1,index,n,dp);
        
        
    }
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++){
            
            int n=sc.nextInt();
            int k=sc.nextInt();
            
            int index[]=new int[2*n];
            
            for(int i=0;i<k;i++){
                
                index[sc.nextInt()-1]=1;
            }
            
            int dp[][]=new int[2*n][2*n];
            
            for(int i=0;i<2*n;i++){
                for(int q=0;q<2*n;q++){
                    dp[i][q]=-1;
                }
            }
            
            
            System.out.println(func(0,0,index,n,dp)); 
            
            
        }

	}

}
