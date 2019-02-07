public class Solution{	
	
public static int findSum(int arr[],int n){
  		
	int sum=0;
	int flag=0;
	int max=Integer.MIN_VALUE;
	for(int i=0;i<n;i++)
        {
          if(arr[i]>0)
          {
            flag=1;
          }
          if(arr[i]+sum<0)
          {
            sum=0;
          }
          else
          {
            sum=arr[i]+sum;
            if(sum>max)
            {
              max=sum;
            }
          }
        }
      if(flag==0)
      {
        max=arr[0];
	for(int i=1;i<n;i++)
        {
          if(arr[i]>max)
          {
            max=arr[i];
          }
        }
        
        return max;
	      
      }
  
  return max;

 }
	
}
