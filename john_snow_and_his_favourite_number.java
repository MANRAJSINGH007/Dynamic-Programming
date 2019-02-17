import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int k=sc.nextInt();
      int x=sc.nextInt();
      
      int arr[]=new int[1024];
      
      for(int i=0;i<n;i++){
        
        arr[sc.nextInt()]++;
        
      }
      
      for(int p=0;p<k;p++){
        
        int aux[]=new int[1024];
        int cnt=0;
        
        for(int i=0;i<1024;i++){
          
          int val=arr[i];
          
          if(val==0){
            continue;
          }
          
          if(arr[i]%2==0){
            
            int temp=x^i;
            aux[temp]+=arr[i]/2;
            aux[i]+=arr[i]/2;
            
          }
          
          else{
            
            if(cnt%2==0){
              
            int temp=x^i;
            aux[temp]+=arr[i]/2+1;
            aux[i]+=arr[i]/2;
              
            }
            
            else{
              
            int temp=x^i;
            aux[temp]+=arr[i]/2;
            aux[i]+=arr[i]/2+1;
              
            }
            
          }
          
          cnt+=val;
          
        }
        
        for(int i=0;i<1024;i++){
          
          arr[i]=aux[i];
          
        }
        
        
      }
      
      
      int min=0;
      int max=0;
      
      for(int i=0;i<1024;i++){
        
        if(arr[i]!=0){
          min=i;
          break;
        }
      }
      
      for(int i=1023;i>=0;i--){
        
        if(arr[i]!=0){
          max=i;
          break;
        }
      }
      
      System.out.println(max+" "+min);

	}

}
