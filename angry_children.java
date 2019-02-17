import java.util.Scanner;
import java.util.Arrays;

public class Main {
  
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      
      long arr[]=new long[n];
      int k=sc.nextInt();
      
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextLong();
        
      }
      
      Arrays.sort(arr);
    
      long ans=Long.MAX_VALUE;
      
      long currAns=0;
      long sum=arr[0];
      
      for(int i=1;i<k;i++)
      {
        currAns+=(i*arr[i]-sum);
        sum+=arr[i];
        
      }
      
      if(currAns<ans)
      {
        ans=currAns;
        
      }
      
      for(int i=k;i<n;i++)
      {
        sum-=arr[i-k];
        currAns=currAns-(sum-(k-1)*arr[i-k]);
        currAns+=((k-1)*arr[i]-sum);
        if(currAns<ans)
        {
          ans=currAns;
          
        }
        
        sum+=arr[i];
        
      }
      
      System.out.println(ans);

	}

}
