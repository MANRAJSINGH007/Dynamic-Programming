import java.util.Scanner;

class Pair{
  
  int fe;
  int fu;
  
  Pair(int fe, int fu){
    
    this.fe=fe;
    this.fu=fu;
    
  }
  
  
}


public class Main {
	
  	public static Pair func(int[] fee, int[] fun, int n, int i, int budget, Pair[][] dp){
      
      if(budget==0 || i==n){
        return new Pair(0,0);
      }
      
      if(dp[i][budget]!=null){
       return dp[i][budget];
      }
      
      Pair m1=func(fee,fun,n,i+1,budget,dp);
      Pair m2=new Pair(0,0);
      
      if(budget>=fee[i]){
        m2=func(fee,fun,n,i+1,budget-fee[i],dp);
        
      }
      
      if(m1.fu>m2.fu+fun[i] || budget<fee[i]){
        return dp[i][budget]=new Pair(m1.fe,m1.fu);
      }
        
      //  added else if
      else if(m1.fu==m2.fu+fun[i]){
          
          if(m2.fe+fee[i]<m1.fe){
              return dp[i][budget]=new Pair(m2.fe+fee[i],m2.fu+fun[i]);
          }
          
          return dp[i][budget]=new Pair(m1.fe,m1.fu);
          
      }
      
      return dp[i][budget]=new Pair(m2.fe+fee[i],m2.fu+fun[i]);
      
    }
	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      
      while(true){
        
        int budget=sc.nextInt();
        int n=sc.nextInt();

        if(budget==0 && n==0){
          break;
        }

        int fee[]=new int[n];
        int fun[]=new int[n];

        for(int i=0;i<n;i++){
          fee[i]=sc.nextInt();
          fun[i]=sc.nextInt();

        }  
        
        Pair dp[][]=new Pair[n][budget+1];
        
        Pair ans=func(fee,fun,n,0,budget,dp);
        System.out.println(ans.fe+" "+ans.fu);
        
      }
      
      
      

	}

}
