import java.util.*;
public class Main {
    
    public static int func(int[] petrol, int[] distance)
    {
        int n=petrol.length;
        int sum=0;
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            sum+=petrol[i]-distance[i];
            
        }
        
        if(sum<0)
        {
            return -1;
        }
        
        sum=0;
        int j=0;
        
        while(j<=n)
        {
            if(j==n)
            {
                return ans;
            }
            
            sum+=petrol[j]-distance[j];
            if(sum>=0)
            {
                j++;
            }
            else
            {
                ans=j+1;
                sum=0;
                j=ans;
                
            }
        }
        
        return ans;
    }
    
    public static void main (String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int petrol[]=new int[n];
        int distance[]=new int[n];
        for(int i=0;i<n;i++)
        {
            petrol[i]=sc.nextInt();
            distance[i]=sc.nextInt();
        }
        
        System.out.println(func(petrol,distance));
        

    }
}
