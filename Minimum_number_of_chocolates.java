
public class Solution {

	public static int getMin(int arr[], int n){
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output.
	 	 * Taking input is handled automatically.
		 */
      
      int candies[]=new int[n];
      candies[0]=1;
      for(int i=0;i<n-1;i++)
      {
        if(arr[i+1]>arr[i])
        {
          candies[i+1]=candies[i]+1;
        }
        else
        {
          candies[i+1]=1;
        }
      }
      
      for(int i=n-1;i>=1;i--)
      {
        if(arr[i]<arr[i-1])
        {
          if(candies[i-1]<candies[i]+1)
          candies[i-1]=candies[i]+1;
        }
      }
      
      int sum=0;
      for(int i=0;i<n;i++)
      {
        sum+=candies[i];
      }
      
      return sum;
      
  }
}
