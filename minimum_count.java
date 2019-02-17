
public class Solution {
	
    public static int func(int n,int[] arr)
    {
      if(arr[n]!=0)
      {
        return arr[n];
      }
      int f=(int)Math.floor(Math.sqrt(n));
      int c=(int)Math.ceil(Math.sqrt(n));
      if(f==c)
      {
        return 1;
      }
      
      int m1=0;
      int m2=0;
      int min=Integer.MAX_VALUE;
      
      for(int k=n-1;k>=n/2;k--)
      {
        m1=func(k,arr);
        m2=func(n-k,arr);
        if(m1+m2<min)
        {
          min=m1+m2;
        }
      }
      //arr[n]=min;
      return arr[n]=min;
    }
    
    public static int minCount(int n){
	    
      int arr[]=new int[n+1];
      return func(n,arr);
}

	
}
