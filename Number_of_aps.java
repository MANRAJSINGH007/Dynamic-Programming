import java.util.*;

public class Solution {

	public static int numOfAP(int arr[], int n){
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output.
	 	 * Taking input is handled automatically.
		 */
      
      ArrayList<HashMap<Integer,Integer>> list=new ArrayList<>();
      
      for(int i=0;i<n;i++)
      {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        list.add(map);
        
      }
      
      int ans=n+1;
      
      for(int i=0;i<n-1;i++)
      {
        for(int j=i+1;j<n;j++)
        {
          int diff=arr[j]-arr[i];
          HashMap<Integer,Integer> temp=list.get(i);
          if(temp.containsKey(diff))
          {
            int freq=temp.get(diff);
            freq++;
            temp.put(diff,freq);
            
          }
          else
          {
            temp.put(diff,1);
          }
        }
        
      }
      
      for(int i=n-3;i>=0;i--)
      {
        for(int k=i+1;k<n;k++)
        {
          int diff=arr[k]-arr[i];
          HashMap<Integer,Integer> map1=list.get(i);
          HashMap<Integer,Integer> map2=list.get(k);
          
          if(map2.containsKey(diff))
          {
            int freq=map2.get(diff);
            if(map1.containsKey(diff))
            {
              int prev=map1.get(diff);
              long t=(long)0+prev+freq;
              prev=(int)t%100001;
              map1.put(diff,prev);
              
            }
            else
            {
              map1.put(diff,freq);
              
            }
          }
          else
          {
            
          }
          
        }
        
      }
      
      for(int i=0;i<n;i++)
      {
        HashMap<Integer,Integer> temp=list.get(i);
        Set<Integer> keys=temp.keySet();
        for(Integer j : keys)
        {
          ans=(int)((long)0+ans+temp.get(j))%100001;
          
        }
        
      }
      
      
      return ans;
      
  }
}
