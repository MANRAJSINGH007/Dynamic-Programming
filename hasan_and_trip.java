import java.util.Scanner;
import java.util.*;


class Triplet{
  
  int x;
  int y;
  int happiness;
  
  Triplet(int x, int y, int happiness)
  {
    this.x=x;
    this.y=y;
    this.happiness=happiness;
    
  }
  
  
}

public class Main {

  	public static double function(Triplet[] arr, int n, int i, int prev, double[][] dp)
    {
      if(i==n-1)
      {
        return (double)(arr[i].happiness)-(double)Math.sqrt(Math.pow(arr[i].x-arr[prev].x,2)+Math.pow(arr[i].y-arr[prev].y,2));
        
      }
      
      if(dp[i][prev]!=-1.000000)
      {
        return dp[i][prev];
      }

      double c1=function(arr,n,i+1,prev,dp);
      double c2=function(arr,n,i+1,i,dp)+(double)(arr[i].happiness)-(double)Math.sqrt(Math.pow(arr[i].x-arr[prev].x,2)+Math.pow(arr[i].y-arr[prev].y,2));
      
      return dp[i][prev]=(double)Math.max(c1,c2);
      
    }
  
	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      
      Triplet arr[]=new Triplet[n];
      
      for(int i=0;i<n;i++)
      {
        int x=sc.nextInt();
        int y=sc.nextInt();
        int happiness=sc.nextInt();
        arr[i]=new Triplet(x,y,happiness);
        
      }
      
      double dp[][]=new double[n][n];
      
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          dp[i][j]=1.000000*(double)(-1);
          
        }
      }
      
      Formatter fmt=new Formatter();
      System.out.println(fmt.format("%.6f",arr[0].happiness+function(arr,n,1,0,dp)));
      

	}

}
