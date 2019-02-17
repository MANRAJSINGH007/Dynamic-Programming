import java.util.Scanner;

public class Main {
  
  	static int mod=(int)Math.pow(10,9)+7;
  	
  	public static int gcd(int a, int b) 
    {  
        if (a == 0) 
          return b; 
      
        if (b == 0) 
          return a; 
       
        if (a == b) 
            return a; 

        if (a > b) 
            return gcd(a%b, b); 
      
        return gcd(a, b%a); 
    } 
  
  	public static int func(int[] arr, int n){
      
      long dp[][]=new long[n][101];
      
      for(int i=0;i<n;i++){
        
        dp[i][arr[i]]=1;
        
      }
      
      for(int i=1;i<n;i++){
        
        
        for(int j=0;j<i;j++){
          
          
          if(arr[j]<arr[i]){
            
            
            for(int k=0;k<=100;k++){
              
              if(dp[j][k]!=0){
                
                int new_gcd=gcd(k,arr[i]);
                dp[i][new_gcd]+=dp[j][k];
                
              }
              
              
            }
            
            
          }
          
          
        }
        
        
        
      }
      
      long sum=0;
      
      for(int i=0;i<n;i++){
        
        long temp=dp[i][1];
        sum=(sum+temp)%mod;
        
      }
      
      return (int)sum%mod;
      
    }
  
  
	public static void main(String[] args) {
		// Write your code here
      
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      
      int arr[]=new int[n];
      
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
        
      }
      
      System.out.println(func(arr,n));
     

	}

}
