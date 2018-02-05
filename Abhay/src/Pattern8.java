import java.io.*;
public class Pattern8
{
    public static void main(String args[]) throws IOException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(isr);
        System.out.print("Enter the no. of lines: "); 
        int n= Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++)
        {    
            char ch='A';
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++)
            {
                System.out.print(ch);
                if((k+1)<=i)
                    ch++;
                else
                    ch--;
                    
            }
            
            System.out.println();    
        }
        
        
        for(int i=n-1;i>=1;i--)
        {    
            char ch='A';
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++)
            {
                System.out.print(ch);
                if((k+1)<=i)
                    ch++;
                else
                    ch--;
                    
            }
            
            System.out.println();    
        }
        
    }
    
}
