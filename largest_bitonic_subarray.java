
public class Solution {
	
	public static int longestBitonicSubarray(int[] arr){

	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
      int n=arr.length;
      
      int inc[]=new int[n];
      int dec[]=new int[n];
      
      for(int i=1;i<n;i++)
      {
        for(int k=0;k<i;k++)
        {
          if(arr[k]<arr[i] && inc[i]<inc[k]+1)
          {
            inc[i]=inc[k]+1;
            
          }
        }
      }
      
      for(int i=n-2;i>=0;i--)
      {
        for(int k=n-1;k>i;k--)
        {
          if(arr[k]<arr[i] && dec[i]<dec[k]+1)
          {
            dec[i]=dec[k]+1;
          }
        }
      }
      
      int max=1;
      
      for(int i=0;i<n;i++)
      {
        if(dec[i]+inc[i]+1>max)
        {
          max=inc[i]+dec[i]+1;
        }
      }
      
      return max;
		
	}
	
}
