import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int m=sc.nextInt();
      
      int arr[][]=new int[n][m];
      
      for(int i=0;i<n;i++){
        
        for(int j=0;j<m;j++){
          
          arr[i][j]=sc.nextInt();
          
        }
        
      }
      
      int dp[][]=new int[n][m];
      
      for(int j=0;j<m;j++){
        
        for(int i=0;i<n;i++){
          
          if(i==0){
            
            dp[i][j]=0;
            continue;
            
          }
          
          if(arr[i][j]<arr[i-1][j]){
            
            dp[i][j]=i;
            
          }
          
          else{
            
            dp[i][j]=dp[i-1][j];
            
          }
          
        }
        
        
      }
      
      int k=sc.nextInt();
      
      for(int p=0;p<k;p++){
        
        int l=sc.nextInt();
        int r=sc.nextInt();
        
        l--;
        r--;
        
        String ans="No";
        
        for(int j=0;j<m;j++){
          
          if(dp[r][j]<=l){
            
            ans="Yes";
            break;
            
          }
          
        }
        
        
        System.out.println(ans);
        
      }
      

	}

}
