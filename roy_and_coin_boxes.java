import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class Main {
  
  	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        }  
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }

	
	public static void main(String[] args) throws IOException{
		// Write your code here
     Reader sc = new Reader();
     
      int n=sc.nextInt();
      int m=sc.nextInt();
      
      int ans[]=new int[n];
      
      for(int i=0;i<m;i++)
      {
        int l=sc.nextInt();
        int r=sc.nextInt();
        // indexing is 1 based.
        l--;
        r--;
        
        ans[l]++;
        if(r!=n-1)
        {
          ans[r+1]--;
          
        }  
        
      }
     
      int s=0;
      int max=0;
      for(int i=0;i<n;i++)
      {
        s+=ans[i];
        ans[i]=s;
        if(s>max)
        {
          max=s;
        }
      }
      
      int brr[]=new int[max+1];
      for(int i=0;i<n;i++)
      {
        brr[ans[i]]++;
        
      }
      
      s=0;
      for(int i=max;i>=0;i--)
      {
        s+=brr[i];
        brr[i]=s;
        
      }
      
      int q=sc.nextInt();
      for(int i=0;i<q;i++)
      {
        int x=sc.nextInt();
        if(x>max)
        {
          System.out.println(0);
        }
        else
        	System.out.println(brr[x]);
      }
      
	}

}
