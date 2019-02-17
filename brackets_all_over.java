import java.util.*;
public class Main {
    
    static int mod=(int)Math.pow(10,9)+7;
    
    public static int func(String s, int n, int m, HashMap<String,Integer> map)
    {
        if(map.containsKey(s))
        {
            return map.get(s);
        }
        
        if(m==n)
        {
            int c1=0;
            int c2=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='(')
                {
                    c1++;
                }
                else
                {
                    c2++;
                }
                
                if(i!=n-1 && c1<c2)
                {
                    map.put(s,0);
                    return 0;
                }
                
            }
            
            if(c1!=c2){
                
                map.put(s,0);
                return 0;
            }
            
            
            map.put(s,1);
            
            return 1;
            
        }
        
        
        
        int m1=func('('+s,n,m+1,map);
        int m2=func(')'+s,n,m+1,map);
        int m3=func(s+'(',n,m+1,map);
        int m4=func(s+')',n,m+1,map);
        
        
        if(m1+m2==0){
            
            long temp=0;
            temp+=(long)0+m3+m4;
            
            map.put(s,(int)temp%mod);
            
            return (int)temp%mod;
            
        }
            
        if(m3+m4==0){
            
            long temp=0;
            temp+=(long)0+m1+m2;
            
            map.put(s,(int)temp%mod);
            
            return (int)temp%mod;
            
            
        }
        
        
        long temp=0;
        temp+=(long)0+(long)1*(m1+m2)*(m3+m4);
        
        map.put(s,(int)temp%mod);
            
        return (int)temp%mod;
        
    }
    
    
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        String s=sc.next();
        
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        
        
        int ans=func(s,n,m,map);
        
        System.out.println(ans);

    }
}
