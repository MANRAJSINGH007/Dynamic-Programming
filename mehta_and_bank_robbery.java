import java.util.Scanner;

public class Main {

    // static long[][][] dp=new long[2001][2001][1024];
    
    public static long func(int[] weight, int[] profit, int n, int i, int[] prime, int w, int[] visited){ 
        
        if(i==n || w==0){
            return 0;
        }
        
        long max=0;
        
        // omit the item
        max=Math.max(max,func(weight,profit,n,i+1,prime,w,visited));
        
        if(weight[i]<=w){
            
            for(int k=0;k<10;k++){
                if(visited[k]!=1){
                    
                    visited[k]=1;
                    long ans=(long)1*profit[i]*prime[k]+func(weight,profit,n,i+1,prime,w-weight[i],visited);
                    visited[k]=0;
                    max=Math.max(max,ans);
                }
            }
            
            max=Math.max(max,profit[i]+func(weight,profit,n,i+1,prime,w-weight[i],visited));
        }
        
        return max;
        
    }
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        
        int weight[]=new int[n];
        int profit[]=new int[n];
        
        for(int i=0;i<n;i++){
            
           profit[i]=sc.nextInt();
           weight[i]=sc.nextInt();
            
        }
        
        int prime[]=new int[10];
        prime[0]=2;
        prime[1]=3;
        prime[2]=5;
        prime[3]=7;
        prime[4]=11;
        prime[5]=13;
        prime[6]=17;
        prime[7]=19;
        prime[8]=23;
        prime[9]=29;
        
        int visited[]=new int[10];
        
        System.out.println(func(weight,profit,n,0,prime,w,visited));
        

	}

}
