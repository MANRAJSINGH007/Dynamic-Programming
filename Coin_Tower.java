public class solution {

	public  String solve(int n,int x,int y){
		
		// Write your code here .
      boolean dp[]=new boolean[n+1];
      // a boolean array
      if(n==1)
      {
        return "Beerus";
      }
      dp[0]=false;
      dp[1]=true;//winning state
      for(int i=2;i<=n;i++)
      {
        boolean b1=true;
        boolean b2=true;
        if(i>=x)
        {
          b1=dp[i-x];
        }
        if(i>=y)
        {
          b2=dp[i-y];
        }
        boolean b3=dp[i-1];
        if(b1 && b2 && b3)
        {
          dp[i]=false;//loosing state
        }
        else
        {
          dp[i]=true;//winning state
        }
      }
      
      if(dp[n]==true)
      {
        return "Beerus";
      }
      
      return "Whis";
      
	}
	
}
