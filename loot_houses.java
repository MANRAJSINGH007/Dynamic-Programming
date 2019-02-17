
public class Solution {
	public static int getMaxMoney(int arr[], int n){
			
      	if(n==1)
        {
          return arr[0];
        }
      	int m1=arr[0];
        int m2=arr[0];
      	if(arr[1]>arr[0])
        {
          m2=arr[1];
          
        }
      
      	for(int i=2;i<n;i++)
        {
          int num=arr[i];
          int temp=num+m1;
          if(temp>m2)
          {
           	m1=m2;
            m2=temp;
          }
          else
          {
            m1=m2;
          }
        }
      
      return m2;

	}
}
