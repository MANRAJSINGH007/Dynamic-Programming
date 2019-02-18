import java.util.*;

public class flipping_Game{
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
            
            if(arr[i]==0){
                arr[i]=1;
            }
            else{
                arr[i]=-1;
            }
        }
        
        // 0 is 1
        // 1 is -1
        // find max sum subarray using kadane
        
        int max=-Integer.MIN_VALUE;
        int curr=0;
        
        for(int i=0;i<n;i++){
            
            curr+=arr[i];

            if(curr>=0){

                if(curr>max){
                    max=curr;
                }

            }
            else{
                curr=0;

            }
        }
        
        int s=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int start=0;
        int end=0;

        for(int i=0;i<n;i++){
            s+=arr[i];
            if(map.containsKey(s-max)){
                end=i;
                start=map.get(s-max)+1;
                break;
            }

            map.put(s,i);

        }


        if(curr>max){
            max=curr;
        }
        
        int cnt=0;
        
        for(int i=0;i<start;i++){
            if(arr[i]==-1){
                cnt++;
            }
        } 
        for(int i=start;i<=end;i++){
            if(arr[i]==1){
                cnt++;
            }
        } 
        
        for(int i=end+1;i<n;i++){
            if(arr[i]==-1){
                cnt++;
            }
        }
        
        if(sum==0){
            cnt=n;    
        }
        if(sum==n){
            cnt=n-1;
        }
        
        System.out.println(cnt);
        // System.out.println(start+" "+end+" ");
    }
    
}
