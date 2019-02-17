import java.util.Scanner;

public class Main {

	
  	public static int func(String s, int n, int i, int[] dp)
    {
      if(i==n)
      {
        return 1;
      }
      if(dp[i]!=-1)
      {
        return dp[i];
      }
      int m1=0;
      int m2=0;
      
      if(i<n-1)
      {
        int num=Integer.parseInt(s.substring(i,i+2));
        if(num>=10 && num<=26)
        {
          m1=func(s,n,i+2,dp);
        }
      }
      
      if(s.charAt(i)!='0')
      {
        m2=func(s,n,i+1,dp);
      }
      
      long temp=(long)0+(long)m1+(long)m2;
      
      return dp[i]=(int)(temp%1000000007);
      
      
    }
  
  
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      
      while(true)
      {
        String x=sc.next();
        if(x.equals("0"))
        {
          break;
        }
        int n=x.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
          dp[i]=-1;
        }
        System.out.println(func(x,n,0,dp));
        
      }

	}

}
