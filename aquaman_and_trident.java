import java.util.*;
public class Main {
    
    public static void func2(int x, int y, int j, ArrayList<Integer> ans){
        
      if(x==0){
       
       for(int p=0;p<ans.size();p++){
           
           System.out.print(ans.get(p)+" ");
           
       }
       
       System.out.println();
       
       return ;
       
     }
     
     for(int i=j; ;i++){
       
       int number=(int)Math.pow(i,y);
       if(number>x){
         
         return;
         
       }
       
       ans.add(i);
       func2(x-number,y,i+1,ans);
       ans.remove(ans.size()-1);
       
     }
        
        
    }
    
    
     public static int function(int x, int y, int j, int[][] dp){
     
     if(x==0){
       
       return 1;
       
     }
     
     if(dp[x][j]!=-1){
       
       return dp[x][j];
       
     }
     
     int ways=0;
     
     for(int i=j; ;i++){
       
       int number=(int)Math.pow(i,y);
       if(number>x){
         
         break;
         
       }
       
       ways+=function(x-number,y,i+1,dp);
       
     }
     
     
     return dp[x][j]=ways;
     
     
   }
    
    public static void main(String args[]) {
        
         Scanner sc=new Scanner(System.in);
         int x=sc.nextInt();
         int y=sc.nextInt();
        
         int i=0;
         while((int)Math.pow(i,y)<=x){
           i++;
           
         }
         
         int dp[][]=new int[x+1][i+1];
         
         for(int p=0;p<=x;p++){
           
           for(int j=0;j<=i;j++){
             
             dp[p][j]=-1;
             
           }
           
         }
         
         
         func2(x,y,1,new ArrayList<Integer>());
         
         System.out.println(function(x,y,1,dp));
        
        

    }
}
